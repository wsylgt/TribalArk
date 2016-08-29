package com.cn.sys.usermanage.service.impl;

import com.cn.component.CodeMasterManage;
import com.cn.component.ContextManage;
import com.cn.component.SystemDateManage;
import com.cn.content.Constant;
import com.cn.dao.entity.UmRoleEntity;
import com.cn.dao.entity.UmUserRoleEntity;
import com.cn.dao.repositorys.UmRoleRepository;
import com.cn.dao.repositorys.UmUserRoleRepository;
import com.cn.sys.usermanage.model.ResetPasswordModel;
import com.cn.sys.usermanage.model.RoleModel;
import com.cn.sys.usermanage.model.UserEditModel;
import com.cn.sys.usermanage.model.UserModel;
import com.cn.dao.entity.UmUserEntity;
import com.cn.dao.repositorys.UmUserRepository;
import com.cn.sys.usermanage.service.IUserManageService;
import com.cn.utils.ConvertUtils;
import com.cn.utils.Md5EncryptUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by kris on 2016/8/23.
 */
@Service
public class UserManageServiceImpl implements IUserManageService {

    /** 日志处理导入 */
    private static final Log logger = LogFactory.getLog(UserManageServiceImpl.class);


    /** 后台用户Dao接口注入 */
    @Resource
    private UmUserRepository umUserRepository;

    /** 后台用户角色Dao接口注入 */
    @Resource
    private UmUserRoleRepository umUserRoleRepository;

    /** 角色Dao接口注入 */
    @Resource
    private UmRoleRepository umRoleRepository;

    /** 上下文共通 */
    @Resource
    private ContextManage contextManage;

    /** 编码信息共通注入 */
    @Resource
    private CodeMasterManage codeMasterManage;

    /** 编码信息共通注入 */
    @Resource
    private SystemDateManage systemDateManage;

    /**
     * 获取所有用户信息列表, 包含搜索,并且分页
     * @param pageNumber: 页号
     * @param pageSize: 每页显示的条数
     * @param employeeNo: 员工号
     * @param userName: 用户名
     * @param roleId: 角色ID
     * @param isDelete: 是否删除,0: 否   1: 是
     * @return List
     */
    @Override
    public Page<UserModel> allUser(int pageNumber, int pageSize, String employeeNo, String userName, Long roleId, String isDelete) {

        logger.debug("allUser: 获取所有用户信息列表" + contextManage.getUser().getUsername());

        // 返回页面的userModelList
        List<UserModel> userModelList = new ArrayList<UserModel>();

        // 用户角色umUserRoleEntityList
        List<UmUserRoleEntity> umUserRoleEntityList = new ArrayList<UmUserRoleEntity>();

        // 获取所有用户角色
        List<UmUserRoleEntity> entityList = umUserRoleRepository.findAll();
        // 添加到用户角色umUserRoleEntityList中
        umUserRoleEntityList.addAll(entityList);

        // 用户ID userIdList
        List<Long> userIdList = new ArrayList<Long>();

        // 如果角色ID不是0,并且不是null
        if (!Constant.STRING_0.equals(roleId + "") & roleId != null) {

            // 根据角色ID查询用户角色
            List<UmUserRoleEntity> umUserRoleList = umUserRoleRepository.findByRoleId(roleId);

            // 清空umUserRoleEntityList
            umUserRoleEntityList.clear();
            // 添加到umUserRoleEntityList中
            umUserRoleEntityList.addAll(umUserRoleList);

            if (umUserRoleList.size() > 0) {
                // 将用户ID添加到userIdList中
                for (UmUserRoleEntity umUserRoleEntity : umUserRoleList) {
                    userIdList.add(umUserRoleEntity.getUserId());
                }
            } else {
                return null;
            }
        }

        // 按userId倒序排序，并分页
        Sort sort = new Sort(Sort.Direction.DESC, Constant.ORDER_BY_USERID);
        Pageable pageable = new PageRequest(pageNumber, pageSize, sort);
        Page<UmUserEntity> pageEntity = umUserRepository.searchByEmployeeNoAndUserNameAndUserId(employeeNo, userName, userIdList, isDelete, pageable);

        // 遍历pageEntity
        for (UmUserEntity umUserEntity : pageEntity.getContent()) {

            // 将Entity赋值到Model中
            UserModel userModel = ConvertUtils.entityToModel(umUserEntity, UserModel.class);

            Set<Long> roleIdSet = new HashSet<Long>();

            // 遍历用户角色
            for (UmUserRoleEntity umUserRoleEntity : umUserRoleEntityList) {

                if (umUserRoleEntity.getUserId() == umUserEntity.getUserId()) {
                    roleIdSet.add(umUserRoleEntity.getRoleId());
                }
            }
            userModel.setRoleIdSet(roleIdSet);

            userModelList.add(userModel);
        }
        Page<UserModel> pageModel = new PageImpl<UserModel>(userModelList, pageable, pageEntity.getTotalElements());
        return pageModel;
    }

    /**
     * 获取所有角色
     * @return List
     */
    @Override
    public List<RoleModel> allRole() {
        logger.debug("allRole: 获取所有角色" );

        // 返回页面的List
        List<RoleModel> roleModelList = new ArrayList<RoleModel>();

        // 获取所有角色信息
        List<UmRoleEntity> umRoleEntityList = umRoleRepository.findAll();

        // 遍历umRoleEntityList, 将Entity添加到Model中
        for (UmRoleEntity umRoleEntity : umRoleEntityList) {
            RoleModel roleModel = ConvertUtils.entityToModel(umRoleEntity, RoleModel.class);
            roleModelList.add(roleModel);
        }
        return roleModelList;
    }

    /**
     * 添加一个用户
     * @param userModel: UserModel对象
     * @return String
     */
    @Override
    @Transactional
    public String saveUser(UserModel userModel) {
        //logger.debug("saveUser: 添加一个用户" + contextManage.getUser().getUsername());

        // 返回的状态
        String status = Constant.STATUS_DB_ERROR;

        // 如果userModel不是null
        if (userModel != null) {

            // 将Model赋值到Entity中
            UmUserEntity umUserEntity = ConvertUtils.modelToEntity(userModel, UmUserEntity.class);
            // 对密码加密
            umUserEntity.setPassword(Md5EncryptUtils.getMd5Encrypt(userModel.getPassword(),userModel.getUserName()));
            // 性别编码组ID设定
            umUserEntity.setSexGroupId(Constant.CODE_GROUP_ID_SEX);
            // 用户状态编码组ID设定
            umUserEntity.setUserStatusGroupId(Constant.USER_STATUS_GROUP_ID);
            umUserEntity.setUserStatusCodeId(Constant.USER_STATUS_CODE_ID_NORMAL);

            Date systeDate = systemDateManage.getSystemTime();
            // 设定操作人, 操作时间等
            umUserEntity.setCreateUser(contextManage.getUser().getUsername());
            umUserEntity.setCreateTime(systeDate);
            umUserEntity.setUpdateUser(contextManage.getUser().getUsername());
            umUserEntity.setUpdateTime(systeDate);

            // 设定用户角色
            UmUserRoleEntity umUserRoleEntity = new UmUserRoleEntity();
            umUserRoleEntity.setRoleId(userModel.getRoleId());
            // 设定操作人, 操作时间等
            umUserRoleEntity.setCreateUser(contextManage.getUser().getUsername());
            umUserRoleEntity.setCreateTime(systeDate);
            umUserRoleEntity.setUpdateUser(contextManage.getUser().getUsername());
            umUserRoleEntity.setUpdateTime(systeDate);

            // 保存到数据库
            UmUserEntity userEntity = umUserRepository.save(umUserEntity);

//            // 如果userEntity不是null
//            if (userEntity != null) {
//                umUserRoleEntity.setUserId(userEntity.getUserId());
//                UmUserRoleEntity roleEntity = umUserRoleRepository.save(umUserRoleEntity);
//
//                // 如果roleEntity不是null, 就返回成功
//                if (roleEntity != null) {
//                    status = Constant.STATUS_OK;
//                }
//            }else{
//                return status;
//            }
        }
        return status;
    }

    /**
     * 编辑用户信息
     * @param model: UserEditModel对象
     * @return String
     */
    @Override
    public String editUser(UserEditModel model) {
        logger.debug("editUser: 编辑用户信息" + contextManage.getUser().getUsername());

        // 返回的状态
        String status = Constant.STATUS_DB_ERROR;

        // 非空判断
        if (model != null) {

            // 根据后台用户ID获取用户信息
            UmUserEntity userEntity = umUserRepository.findOne(model.getUserId());

            if (userEntity != null) {

                // 员工号
                userEntity.setEmployeeNo(model.getEmployeeNo());
                // 用户名
                userEntity.setUserName(model.getUserName());

                // 手机号
                if (!"".equals(model.getCellphoneNo())) {
                    userEntity.setCellphoneNo(model.getCellphoneNo());
                } else {
                    userEntity.setCellphoneNo(null);
                }
                // 邮箱
                if (!"".equals(model.getEmail())) {
                    userEntity.setEmail(model.getEmail());
                } else {
                    userEntity.setEmail(null);
                }
                // 邮箱
                if (!"".equals(model.getUserDescription())) {
                    userEntity.setUserDescription(model.getUserDescription());
                } else {
                    userEntity.setUserDescription(null);
                }
                // 用户性别
                userEntity.setSexCodeId(model.getSexCodeId());

                // 执行保存
                UmUserEntity entity = umUserRepository.save(userEntity);

                // 非空判断
                if (entity != null) {

                    // 返回成功
                    status = Constant.STATUS_OK;
                }
            }
        }
        return status;
    }

    /**
     * 根据用户ID查询用的详细信息
     * @param userId: 用户ID
     * UserModel
     */
    @Override
    public UserModel findByUserId(Long userId) {
        logger.debug("findByUserId: 根据用户ID查询用的详细信息" + contextManage.getUser().getUsername());

        UserModel userModel = new UserModel();

        // 获取所有用户角色
        List<UmUserRoleEntity> umUserRoleEntityList = umUserRoleRepository.findAll();

        // 如果userId不是,就根据userId查询用户信息
        if (userId != null) {

            UmUserEntity umUserEntity = umUserRepository.findOne(userId);

            // 如果umUserRoleEntity不是null
            if (umUserEntity != null) {

                // 赋值到Model中
                userModel = ConvertUtils.entityToModel(umUserEntity, UserModel.class);

                // 角色ID集合
                Set<Long> roleIdSet = new HashSet<Long>();

                // 遍历用户角色umUserRoleEntityList
                for (UmUserRoleEntity umUserRoleEntity : umUserRoleEntityList) {

                    if (umUserRoleEntity.getUserId() == umUserEntity.getUserId()) {

                        roleIdSet.add(umUserRoleEntity.getRoleId());
                    }
                }
                userModel.setRoleIdSet(roleIdSet);
            }
        }
        return userModel;
    }

    /**
     * 根据用户ID冻结用户账户
     * @param userId: 用户ID
     * @return String
     */
    @Override
    public String freezeAccount(Long userId) {
        logger.debug("fnFreezeAccount: 冻结用户账户" + contextManage.getUser().getUsername());

        //返回页面的状态信息,默认返回失败
        String status = Constant.STATUS_DB_ERROR;

        // 如果userId不是null,就根据Id查询用户
        if (userId != null) {
            UmUserEntity umUserEntity = umUserRepository.findOne(userId);

            // 如果umUserEntity不是null
            if (umUserEntity != null) {
                umUserEntity.setUserStatusCodeId(Constant.USER_STATUS_CODE_ID_FREEZE);

                UmUserEntity entity = umUserRepository.save(umUserEntity);

                // 如果entity不是null,就返回成功
                if (entity != null) {
                    status = Constant.STATUS_OK;
                }
            }
        }
        return status;
    }

    /**
     * 根据用户ID恢复用户账户
     * @param userId: 用户ID
     * @return String
     */
    @Override
    public String recoveryAccount(Long userId) {
        logger.debug("fnRecoveryAccount: 恢复用户账户" + contextManage.getUser().getUsername());

        //返回页面的状态信息,默认返回失败
        String status = Constant.STATUS_DB_ERROR;

        // 如果userId不是null,就根据Id查询用户
        if (userId != null) {
            UmUserEntity umUserEntity = umUserRepository.findOne(userId);

            // 如果umUserEntity不是null
            if (umUserEntity != null) {
                umUserEntity.setUserStatusCodeId(Constant.USER_STATUS_CODE_ID_NORMAL);

                UmUserEntity entity = umUserRepository.save(umUserEntity);

                // 如果entity不是null,就返回成功
                if (entity != null) {
                    status = Constant.STATUS_OK;
                }
            }
        }
        return status;
    }

    /**
     * 根据用户ID删除一个用户,逻辑删除,更改状态
     * @param userId: 用户ID
     * @return String
     */
    @Override
    public String deleteUser(Long userId) {
        logger.debug("deleteUser: 根据用户ID删除一个用户" + contextManage.getUser().getUsername());

        //返回页面的状态信息,默认返回失败
        String status = Constant.STATUS_DB_ERROR;

        // 如果userId不是null,就根据Id查询用户
        if (userId != null) {
            UmUserEntity umUserEntity = umUserRepository.findOne(userId);

            // 如果umUserEntity不是null
            if (umUserEntity != null) {

                UmUserEntity entity = umUserRepository.save(umUserEntity);

                // 如果entity不是null,就返回成功
                if (entity != null) {
                    status = Constant.STATUS_OK;
                }
            }
        }
        return status;
    }

    /**
     * 根据用户ID恢复删除的用户
     * @param userId: 用户ID
     * @return String
     */
    @Override
    public String recoveryUser(Long userId) {
        logger.debug("recoveryUser: 根据用户ID恢复删除的用户" + contextManage.getUser().getUsername());

        //返回页面的状态信息,默认返回失败
        String status = Constant.STATUS_DB_ERROR;

        // 如果userId不是null,就根据Id查询用户
        if (userId != null) {
            UmUserEntity umUserEntity = umUserRepository.findOne(userId);

            // 如果umUserEntity不是null
            if (umUserEntity != null) {

                UmUserEntity entity = umUserRepository.save(umUserEntity);

                // 如果entity不是null,就返回成功
                if (entity != null) {

                    // 返回成功
                    status = Constant.STATUS_OK;
                }
            }
        }
        return status;
    }

    /**
     * 重置后台用户密码
     * @param model: ResetPasswordModel对象
     * @return String
     */
    @Override
    public String resetPassword(ResetPasswordModel model) {
        logger.debug("resetPassword: 重置后台用户密码"+ contextManage.getUser().getUsername());

        //返回页面的状态信息,默认返回失败
        String status = Constant.STATUS_DB_ERROR;

        // 非空判断
        if (model != null) {

            // 获取后台用户信息
            UmUserEntity userEntity = umUserRepository.findOne(model.getUserId());

            // MD5对密码加密
            String md5Password = Md5EncryptUtils.getMd5Encrypt(model.getConfirmPassword(),userEntity.getUserName());
            userEntity.setPassword(md5Password);

            // 执行更新
            UmUserEntity entity = umUserRepository.save(userEntity);

            // 非空判断
            if (entity != null) {

                // 返回成功
                status = Constant.STATUS_OK;
            }
        }
        return status;
    }

    /**
     * 查询用户名、工号、手机号码是否已经存在
     * @param userName: 用户名
     * @param employeeNo: 工号
     * @param cellphoneNo: 手机号码
     * @return String
     */
    @Override
    public String isExist(String userName, String employeeNo, String cellphoneNo) {
        logger.debug("isExist: 查询用户名、工号，是否已经存在"+ contextManage.getUser().getUsername());

        // 默认返回的状态, 不存在
        String exist = Constant.DB_NOT_EXISTS;

        if (userName != null && !"".equals(userName)) {

            try {
                userName = new String(userName.getBytes(), "UTF-8");

            } catch (UnsupportedEncodingException e) {
                return null;
            }

            UmUserEntity umUserEntity = umUserRepository.findByUserName(userName);

            if (umUserEntity != null) {
                // 返回存在
                exist = Constant.DB_EXISTS;
            }
        }

        if (employeeNo != null && !"".equals(employeeNo)) {

            try {
                employeeNo = new String(employeeNo.getBytes(), "UTF-8");

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            UmUserEntity umUserEntity = umUserRepository.findByEmployeeNo(employeeNo);
            if (umUserEntity != null) {
                // 返回存在
                exist = Constant.DB_EXISTS;
            }
        }

        if (cellphoneNo != null && !"".equals(cellphoneNo)) {

            UmUserEntity umUserEntity = umUserRepository.findByCellphoneNo(cellphoneNo);

            if (umUserEntity != null) {
                // 返回存在
                exist = Constant.DB_EXISTS;
            }
        }
        return exist;
    }

}
