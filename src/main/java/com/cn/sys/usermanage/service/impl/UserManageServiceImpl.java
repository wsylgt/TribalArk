package com.cn.sys.usermanage.service.user.impl;

import com.cn.api.usermanage.model.UserModel;
import com.cn.dao.entity.UmUserEntity;
import com.cn.dao.repositorys.UmUserRepository;
import com.cn.sys.usermanage.service.user.IUserManageService;
import com.cn.utils.ConvertUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

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

    /**
     * 根据用户名查询用的详细信息
     * @param username: 用户名
     * UserModel
     */
    @Override
    public UserModel findByUserName(String username) {
        logger.debug("findByUserId: 根据用户ID查询用的详细信息" + username);

        UserModel userModel = new UserModel();


        // 如果userId不是,就根据userId查询用户信息
        if (username != null) {

            UmUserEntity umUserEntity = umUserRepository.findByUserName(username);

            // 如果umUserRoleEntity不是null
            if (umUserEntity != null) {

                // 赋值到Model中
                userModel = ConvertUtils.entityToModel(umUserEntity, UserModel.class);

                // 角色ID集合
                Set<Long> roleIdSet = new HashSet<Long>();

                userModel.setRoleIdSet(roleIdSet);
            }
        }
        return userModel;
    }

}
