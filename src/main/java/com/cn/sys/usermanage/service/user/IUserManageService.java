package com.cn.sys.usermanage.service.user;

import com.cn.api.usermanage.model.UserModel;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kris on 2016/8/23.
 */
@Transactional
public interface IUserManageService {

    /**
     * 根据用户ID查询用的详细信息
     * @param username: 用户名
     * UserModel
     */
    public UserModel findByUserName(String username);
}
