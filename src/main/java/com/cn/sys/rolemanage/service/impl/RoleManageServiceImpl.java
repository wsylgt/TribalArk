/**
 * 角色管理service接口
 * <p>角色管理service接口</p>
 * Copyright 2016-2016 .
 */
package com.cn.sys.rolemanage.service.impl;

import com.cn.component.CodeMasterManage;
import com.cn.component.ContextManage;
import com.cn.component.SystemDateManage;
import com.cn.component.SystemLog;
import com.cn.content.Constant;
import com.cn.dao.entity.AmRoleResourceAuthorityEntity;
import com.cn.dao.entity.UmRoleEntity;
import com.cn.dao.entity.UmUserEntity;
import com.cn.dao.entity.UmUserRoleEntity;
import com.cn.dao.repositorys.AmRoleResourceAuthorityRepository;
import com.cn.dao.repositorys.UmRoleRepository;
import com.cn.dao.repositorys.UmUserRepository;
import com.cn.dao.repositorys.UmUserRoleRepository;
import com.cn.sys.rolemanage.model.AddUserModel;
import com.cn.sys.rolemanage.model.RoleModel;
import com.cn.sys.rolemanage.model.UserModel;
import com.cn.sys.rolemanage.service.IRoleManageService;
import com.cn.utils.ConvertUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色管理Service接口实现
 * <p>角色管理Service接口实现</p>
 *
 * @author 王成龙
 * @version 1.0 2016/5/16
 */
@Service
@Transactional
public class RoleManageServiceImpl implements IRoleManageService {

    /**
     * 日志处理的导入
     */
    private static final Log logger = LogFactory.getLog(RoleManageServiceImpl.class);

    /**
     * 角色管理表DAO
     */
    @Resource
    private UmRoleRepository iUmRoleRepository;
    /**
     * 用户管理表DAO
     */
    @Resource
    private UmUserRepository iUmUserRepository;
    /**
     * 用户角色DAO
     */
    @Resource
    private UmUserRoleRepository iUmUserRoleRepository;
    /**
     * 编码信息表DAO
     */
    @Resource
    private CodeMasterManage codeMasterManage;
    /**
     * 角色资源权限管理表DAO
     */
    @Resource
    private AmRoleResourceAuthorityRepository iAmRoleResourceAuthorityRepository;
    /**
     * 用户信息DAO
     */
    @Resource
    private ContextManage context;

    @Resource
    private SystemDateManage systemDateManage;

    /**
     * 取得角色List
     * <p>取得角色List</p>
     *
     * @param
     * @return roleModelList 角色List
     */
    @Override
    public List<RoleModel> getRoleList() {
        logger.debug("getRoleList:取得角色List---开始---" + context.getUser().getUsername());
        // 取得角色List
        List<UmRoleEntity> roleEntityList = iUmRoleRepository.findAll();
        List<UmRoleEntity> roleList = new ArrayList<UmRoleEntity>();
        // 将超级管理员的角色去掉
        for (UmRoleEntity role : roleEntityList) {
            if (!Constant.ROLE_MANAGER.equals(role.getRoleMark())) {
                roleList.add(role);
            }
        }
        // 角色List作成
        List<RoleModel> roleModelList = new ArrayList<RoleModel>();
        // 将entity转换成model
        for (UmRoleEntity roleEntity : roleList) {
            roleModelList.add(ConvertUtils.entityToModel(roleEntity, RoleModel.class));
        }

        // 取得属于该角色的用户数
        List<UmUserRoleEntity> userRoleEntityList = iUmUserRoleRepository.findAll();
        for (int i = 0; i < roleModelList.size(); i++) {
            List<UmUserRoleEntity> userRoleList = new ArrayList<UmUserRoleEntity>();
            // 如果角色Id相同，则放到临时用户角色List中
            for (UmUserRoleEntity userRole : userRoleEntityList) {
                if (roleModelList.get(i).getRoleId() == userRole.getRoleId()) {
                    userRoleList.add(userRole);
                }
            }
            // 将用户数放到角色Model中
            roleModelList.get(i).setUserCount(userRoleList.size());
        }

        return roleModelList;
    }

    /**
     * 根据角色Id取得角色信息
     * <p>根据角色Id取得角色信息</p>
     *
     * @param
     * @return role 角色信息
     */
    @Override
    public RoleModel getRoleInfo(long roleId) {
        logger.debug("getRoleInfo:根据角色Id取得角色信息---开始---" + context.getUser().getUsername());
        // 根据角色Id取得角色信息
        RoleModel role = ConvertUtils.entityToModel(iUmRoleRepository.findByRoleId(roleId), RoleModel.class);

        return role;
    }

    /**
     * 根据角色Id取得属于该角色的所有用户
     * <p>根据角色Id取得属于该角色的所有用户</p>
     *
     * @param
     * @return roleModelList 角色List
     */
    @Override
    public List<UserModel> getUserList(long roleId) {
        logger.debug("getUserList:根据角色Id取得属于该角色的所有用户---开始---"
                + context.getUser().getUsername());
        // 根据角色Id从【用户角色表】中取得用户Id
        List<UmUserRoleEntity> userRoleEntityList = iUmUserRoleRepository.findByRoleId(roleId);
        // 用户Id List
        List<Long> userIdList = new ArrayList<Long>();
        for (UmUserRoleEntity userRoleEntity : userRoleEntityList) {
            userIdList.add(userRoleEntity.getUserId());
        }
        // 根据用户Id list 取得用户信息
        List<UmUserEntity> userEntityList = iUmUserRepository.findByUserIdIn(userIdList);
        // 用户信息ModelList
        List<UserModel> userList = new ArrayList<UserModel>();
        // 循环将Entity转换成Model
        for (UmUserEntity userEntity : userEntityList) {
            userList.add(ConvertUtils.entityToModel(userEntity, UserModel.class));
        }

        // 根据codeId设定code名
        for (int i = 0; i < userList.size(); i++) {
            // 【用户状态】名设定
            userList.get(i).setUserStatusName(
                    codeMasterManage.getCodeName(
                            Constant.USER_STATUS_GROUP_ID, userList.get(i).getUserStatusCodeId()));
            // 【用户性质】名设定
            userList.get(i).setUserPropertyName(codeMasterManage.getCodeName(
                    Constant.USER_PROPERTY_GROUP_ID, userList.get(i).getUserPropertyCodeId()));
        }

        return userList;
    }

    /**
     * 根据员工号或者用户名，取得用户信息
     * <p>根据员工号或者用户名，取得用户信息</p>
     *
     * @param userModel 用户Model
     * @return userList 用户List
     */
    @Override
    public List<UserModel> searchUser(UserModel userModel) {
        logger.debug("searchUser:根据员工号或者用户名，取得用户信息---开始---"
                + context.getUser().getUsername());
        // 员工号
        String employeeNo = userModel.getEmployeeNo();
        if (!Constant.STRING_EMPTY.equals(
                employeeNo.replace(Constant.STRING_SPACE, Constant.STRING_EMPTY))) {
            employeeNo = employeeNo + Constant.STRING_PER_CENT;
        }
        // 用户名
        String userName = userModel.getUserName();
        if (!Constant.STRING_EMPTY.equals(
                userName.replace(Constant.STRING_SPACE, Constant.STRING_EMPTY))) {
            userName = Constant.STRING_PER_CENT + userName + Constant.STRING_PER_CENT;
        }
        // 如果员工号和用户名都为空，则取得属于该角色的所有用户
        if (Constant.STRING_EMPTY.equals(
                employeeNo.replace(Constant.STRING_SPACE, Constant.STRING_EMPTY))
                && Constant.STRING_EMPTY.equals(
                userName.replace(Constant.STRING_SPACE, Constant.
                        STRING_EMPTY))) {

            employeeNo = Constant.STRING_PER_CENT;
            userName = Constant.STRING_PER_CENT;
        }
        // 根据员工号和用户名进行模糊查询
        List<UmUserEntity> searchUserEntityList = iUmUserRepository.findByEmployeeNoLikeOrUserNameLike(
                employeeNo, userName);

        // 根据角色Id从【用户角色表】中取得用户
        List<UmUserRoleEntity> userRoleEntityList = iUmUserRoleRepository.findByRoleId(userModel.getRoleId());

        // 两个EntityList的交集用List
        List<UmUserEntity> userEntityList = new ArrayList<UmUserEntity>();

        // 如果该角色下不存在查询到的用户则移除该条查询结果
        for (UmUserEntity userEntity : searchUserEntityList) {
            for (UmUserRoleEntity userRoleEntity : userRoleEntityList) {
                if (userEntity.getUserId() == userRoleEntity.getUserId()) {
                    userEntityList.add(userEntity);
                }
            }
        }

        List<UserModel> userList = new ArrayList<UserModel>();
        // 将Entity转换成Model
        for (UmUserEntity userEntity : userEntityList) {
            userList.add(ConvertUtils.entityToModel(userEntity, UserModel.class));
        }

        // 根据codeId设定code名
        for (int i = 0; i < userList.size(); i++) {
            // 【用户状态】名设定
            userList.get(i).setUserStatusName(
                    codeMasterManage.getCodeName(
                            Constant.USER_STATUS_GROUP_ID, userList.get(i).getUserStatusCodeId()));
            // 【用户性质】名设定
            userList.get(i).setUserPropertyName(codeMasterManage.getCodeName(
                    Constant.USER_PROPERTY_GROUP_ID, userList.get(i).getUserPropertyCodeId()));
        }

        return userList;
    }

    /**
     * 根据角色Id，用户Id删除【用户角色表】中的数据
     * <p>根据角色Id，用户Id删除【用户角色表】中的数据</p>
     *
     * @param userModel 用户Model
     * @return status 删除结果
     */
    @Override
    @SystemLog(methodDescription = "删除【用户角色表】中的数据")
    public String deleteUser(UserModel userModel) {
        logger.debug("deleteUser:根据角色Id，用户Id删除【用户角色表】中的数据---开始---"
                + context.getUser().getUsername());
        String status = Constant.STATUS_DB_ERROR;
        // 用户角色Entity
        UmUserRoleEntity userRoleEntity = new UmUserRoleEntity();

        // 根据角色Id和用户Id取得用户角色数据
        List<UmUserRoleEntity> userRoleEntityList = iUmUserRoleRepository.findAll();
        for (UmUserRoleEntity userRole : userRoleEntityList) {
            // 取得画面传回的用户Id和角色Id相匹配的数据
            if (userRole.getRoleId() == userModel.getRoleId() &&
                    userRole.getUserId() == userModel.getUserId()) {
                userRoleEntity = userRole;
            }
        }

        // 如果用户角色不为空
        if (userRoleEntity != null) {
            iUmUserRoleRepository.delete(userRoleEntity);
            status = Constant.STATUS_OK;
        }

        return status;
    }

    /**
     * 添加角色
     * <p>添加角色</p>
     *
     * @param roleModel 角色Model
     * @return status 添加结果
     */
    @Override
    @SystemLog(methodDescription = "添加角色")
    public String addRole(RoleModel roleModel) {
        logger.debug("addRole:添加角色---开始---" + context.getUser().getUsername());
        String status = Constant.STATUS_DB_ERROR;

        // 取得系统时间
        Date sysDate = systemDateManage.getSystemTime();
        // 取得当前登录用户名
        String userName = context.getUser().getUsername();

        UmRoleEntity roleEntity = new UmRoleEntity();

        // 角色标识
        roleEntity.setRoleMark(Constant.ROLE_USER);
        // 角色名称
        roleEntity.setRoleName(roleModel.getRoleName());
        // 角色描述
        roleEntity.setRoleDescription(roleModel.getRoleDescription());
        // 创建用户
        roleEntity.setCreateUser(userName);
        // 创建时间
        roleEntity.setCreateTime(sysDate);
        // 更新用户
        roleEntity.setUpdateUser(userName);
        // 更新时间
        roleEntity.setUpdateTime(sysDate);

        //插入【角色表】
        UmRoleEntity returnRoleEntity = iUmRoleRepository.save(roleEntity);
        // 如果返回的角色Entity不为空，则处理成功
        if (returnRoleEntity != null) {
            status = Constant.STATUS_OK;
        }

        return status;
    }

    /**
     * 为某一个角色下添加用户时，先得到用户List
     * <p>为某一个角色下添加用户时，先得到用户List</p>
     *
     * @param userModel 角色Id
     * @return status 用户List
     */
    @Override
    public List<UserModel> getAddUserList(UserModel userModel) {
        logger.debug("getAddUserList:为某一个角色下添加用户时，先得到用户List---开始---"
                + context.getUser().getUsername());
        // 员工号
        String employeeNo = userModel.getEmployeeNo();
        if (!Constant.STRING_EMPTY.equals(
                employeeNo.replace(Constant.STRING_SPACE, Constant.STRING_EMPTY))) {
            employeeNo = employeeNo + Constant.STRING_PER_CENT;
        }
        // 用户名
        String userName = userModel.getUserName();
        if (!Constant.STRING_EMPTY.equals(
                userName.replace(Constant.STRING_SPACE, Constant.STRING_EMPTY))) {
            userName = Constant.STRING_PER_CENT + userName + Constant.STRING_PER_CENT;
        }
        // 如果员工号和用户名都为空，则取得属于该角色的所有用户
        if (Constant.STRING_EMPTY.equals(
                employeeNo.replace(Constant.STRING_SPACE, Constant.STRING_EMPTY))
                && Constant.STRING_EMPTY.equals(
                userName.replace(Constant.STRING_SPACE, Constant.
                        STRING_EMPTY))) {

            employeeNo = Constant.STRING_PER_CENT;
            userName = Constant.STRING_PER_CENT;
        }
        // 根据员工号和用户名进行模糊查询
        List<UmUserEntity> searchUserEntityList = iUmUserRepository.findByEmployeeNoLikeOrUserNameLike(
                employeeNo, userName);

        // 根据角色Id从【用户角色表】中取得用户
        List<UmUserRoleEntity> userRoleEntityList = iUmUserRoleRepository.findByRoleId(userModel.getRoleId());

        // 两个EntityList的差集用List
        List<UmUserEntity> userEntityList = new ArrayList<UmUserEntity>();

        // 如果该角色下不存在查询到的用户则移除该条查询结果
        for (UmUserEntity userEntity : searchUserEntityList) {
            if (userRoleEntityList.size() > 0) {
                for (UmUserRoleEntity userRoleEntity : userRoleEntityList) {
                    if (userEntity.getUserId() == userRoleEntity.getUserId()) {
                        userEntityList.add(userEntity);
                        break;
                    }
                }
            } else {
                userEntityList.add(userEntity);
            }
        }

        // 去掉已经属于该角色的数据
        if (userRoleEntityList.size() > 0) {
            for (int i = 0; i < searchUserEntityList.size(); i++) {
                for (UmUserEntity user : userEntityList) {
                    if (searchUserEntityList.get(i).getUserId() == user.getUserId()) {
                        searchUserEntityList.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }

        List<UserModel> userList = new ArrayList<UserModel>();
        // 将Entity转换成Model
        for (UmUserEntity userEntity : searchUserEntityList) {
            userList.add(ConvertUtils.entityToModel(userEntity, UserModel.class));
        }

        // 根据codeId设定code名
        for (int i = 0; i < userList.size(); i++) {
            // 【用户状态】名设定
            userList.get(i).setUserStatusName(
                    codeMasterManage.getCodeName(
                            Constant.USER_STATUS_GROUP_ID, userList.get(i).getUserStatusCodeId()));
            // 【用户性质】名设定
            userList.get(i).setUserPropertyName(codeMasterManage.getCodeName(
                    Constant.USER_PROPERTY_GROUP_ID, userList.get(i).getUserPropertyCodeId()));
        }

        return userList;
    }

    /**
     * 用户角色表中添加用户
     *
     * @param addUserModel
     * @return
     */
    @Override
    @SystemLog(methodDescription = "用户角色表中添加用户")
    public String saveUserRole(AddUserModel addUserModel) {
        logger.debug("saveUserRole:用户角色表中添加用户---开始---" + context.getUser().getUsername());
        String status = Constant.STATUS_DB_ERROR;
        // 用户ModelList
        List<UserModel> userModelList = addUserModel.getUserModelList();

        // 取得系统时间
        Date sysDate = systemDateManage.getSystemTime();
        // 取得当前登录用户名
        String userName = context.getUser().getUsername();

        // 角色Id
        long roleId = addUserModel.getRoleId();

        // 用户角色Entity
        List<UmUserRoleEntity> userRoleEntityList = new ArrayList<UmUserRoleEntity>();

        // 插入用户角色表数据做成
        for (UserModel userModel : userModelList) {
            if (userModel.getUserId() != Constant.USER_ID_ZERO) {
                // 用户角色Entity
                UmUserRoleEntity userRoleEntity = new UmUserRoleEntity();
                // 角色ID
                userRoleEntity.setRoleId(roleId);
                // 用户ID
                userRoleEntity.setUserId(userModel.getUserId());
                // 创建用户
                userRoleEntity.setCreateUser(userName);
                // 创建时间
                userRoleEntity.setCreateTime(sysDate);
                // 更新用户
                userRoleEntity.setUpdateUser(userName);
                // 更新时间
                userRoleEntity.setUpdateTime(sysDate);

                // 存入List内
                userRoleEntityList.add(userRoleEntity);
            }
        }

        // 插入【用户角色表】
        List<UmUserRoleEntity> tempEntityList = iUmUserRoleRepository.save(userRoleEntityList);

        // 如果返回值不为空，则插入成功
        if (tempEntityList.size() > 0) {
            status = Constant.STATUS_OK;
        }

        return status;
    }

    /**
     * 编辑角色信息
     * <p>编辑角色信息</p>
     *
     * @param roleModel 角色Model
     * @return status 更新结果
     */
    @Override
    @SystemLog(methodDescription = "编辑角色信息")
    public String editRole(RoleModel roleModel) {
        logger.debug("editRole:编辑角色信息---开始---" + context.getUser().getUsername());
        String status = Constant.STATUS_DB_ERROR;

        // 取得系统时间
        Date sysDate = systemDateManage.getSystemTime();
        // 取得当前登录用户名
        String userName = context.getUser().getUsername();

        // 根据角色Id取得该角色
        UmRoleEntity roleEntity = iUmRoleRepository.findByRoleId(roleModel.getRoleId());

        // 角色名称
        roleEntity.setRoleName(roleModel.getRoleName());
        // 角色描述
        roleEntity.setRoleDescription(roleModel.getRoleDescription());
        // 更新用户
        roleEntity.setUpdateUser(userName);
        // 更新时间
        roleEntity.setUpdateTime(sysDate);

        //插入【角色表】
        UmRoleEntity returnRoleEntity = iUmRoleRepository.save(roleEntity);
        // 如果返回的角色Entity不为空，则处理成功
        if (returnRoleEntity != null) {
            status = Constant.STATUS_OK;
        }

        return status;
    }

    /**
     * 根据角色Id删除【角色表】和【角色权限资源表】中的数据
     * <p>根据角色Id删除【角色表】和【角色权限资源表】中的数据</p>
     *
     * @param roleId 角色Id
     * @return status 删除结果
     */
    @Override
    @SystemLog(methodDescription = "删除角色和角色权限")
    public String deleteRole(long roleId) {
        logger.debug("deleteRole:根据角色Id删除【角色表】和【角色权限资源表】中的数据---开始---"
                + context.getUser().getUsername());
        String status = Constant.STATUS_DB_ERROR;
        // 根据角色Id取得该角色所拥有的资源
        List<AmRoleResourceAuthorityEntity> roleResAuthList =
                iAmRoleResourceAuthorityRepository.findByRoleId(roleId);
        // 根据角色Id取得角色信息
        UmRoleEntity roleEntity = iUmRoleRepository.findByRoleId(roleId);
        // 根据角色Id取得该角色下的用户
        List<UmUserRoleEntity> userEntityList = iUmUserRoleRepository.findByRoleId(roleId);

        // 如果角色不为空并且角色资源权限不为空
        if (roleEntity != null) {
            // 删除角色信息
            iUmRoleRepository.delete(roleEntity);
            // 删除该角色下的所有用户
            iUmUserRoleRepository.delete(userEntityList);
            // 删除角色所拥有的资源
            iAmRoleResourceAuthorityRepository.delete(roleResAuthList);
            // 删除状态设置为正常完了
            status = Constant.STATUS_OK;
        }

        return status;
    }

    /**
     * 角色名是否唯一check
     *
     * @param roleName 角色名
     * @return status 查询结果
     */
    @Override
    public String roleNameUniqueCheck(long roleId, String roleName) {
        logger.debug("roleNameUniqueCheck:角色名是否唯一check---开始---" + context.getUser().getUsername());
        String status = Constant.DB_NOT_EXISTS;

        // 根据角色名，取得角色表信息
        List<UmRoleEntity> roleEntityList = iUmRoleRepository.findByRoleName(roleName);

        // 如果该角色名能查到角色信息，则返回error
        if (roleEntityList.size() > 0) {
            for (UmRoleEntity role : roleEntityList) {
                if (role.getRoleId() != roleId) {
                    status = Constant.DB_EXISTS;
                }
            }
        }

        return status;
    }

}
