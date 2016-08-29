/**
 * 为角色添加用户时的Model
 * <p>为角色添加用户时的Model</p>
 * Copyright 2016-2016 .
 */
package com.cn.sys.rolemanage.model;

import java.io.Serializable;
import java.util.List;

/**
 * 为角色添加用户时的Model
 * <p>为角色添加用户时的Model</p>
 *
 * @author 王成龙
 * @version 1.0 2016/05/18
 */
public class AddUserModel implements Serializable {

    /**
     * 序列化串号ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 角色Id
     */
    private long roleId;

    /**
     * 用户List
     */
    private List<UserModel> userModelList;

    /**
     * 角色Id的取得
     *
     * @return 角色Id
     */
    public long getRoleId() {
        return roleId;
    }

    /**
     * 角色Id的设定
     *
     * @param roleId 角色Id
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    /**
     * 用户ModelList的取得
     *
     * @return 用户ModelList
     */
    public List<UserModel> getUserModelList() {
        return userModelList;
    }

    /**
     * 用户ModelList的设定
     *
     * @param userModelList 用户ModelList
     */
    public void setUserModelList(List<UserModel> userModelList) {
        this.userModelList = userModelList;
    }

}
