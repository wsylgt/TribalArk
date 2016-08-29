/**
 * 角色管理service接口
 * <p>角色管理service接口</p>
 * Copyright 2016-2016 .
 */
package com.cn.sys.rolemanage.service;

import com.cn.sys.rolemanage.model.AddUserModel;
import com.cn.sys.rolemanage.model.RoleModel;
import com.cn.sys.rolemanage.model.UserModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色管理Service接口
 * <p>角色管理Service接口</p>
 *
 * @author 王成龙
 * @version 1.0 2016/5/16
 */
@Transactional
public interface IRoleManageService {

    /**
     * 取得角色List
     * <p>取得角色List<br>
     *
     * @param
     */
    public List<RoleModel> getRoleList();

    /**
     * 根据角色Id取得角色信息
     * <p>根据角色Id取得角色信息</p>
     *
     * @param
     */
    public RoleModel getRoleInfo(long roleId);

    /**
     * 根据角色Id取得属于该角色的所有用户
     * <p>根据角色Id取得属于该角色的所有用户</p>
     *
     * @param
     */
    public List<UserModel> getUserList(long roleId);

    /**
     * 根据搜索框中输入的员工号或者用户名，取得用户信息
     * <p>根据搜索框中输入的员工号或者用户名，取得用户信息</p>
     *
     * @param userModel
     */
    public List<UserModel> searchUser(UserModel userModel);

    /**
     * 根据角色Id，用户Id删除【用户角色表】中的数据
     * <p>根据角色Id，用户Id删除【用户角色表】中的数据</p>
     *
     * @param userModel
     */
    public String deleteUser(UserModel userModel);

    /**
     * 添加角色
     * <p>添加角色</p>
     *
     * @param roleModel
     */
    public String addRole(RoleModel roleModel);

    /**
     * 为某一个角色下添加用户时，先得到用户List
     *
     * @param userModel
     * @return
     */
    public List<UserModel> getAddUserList(UserModel userModel);

    /**
     * 用户角色表中添加用户
     *
     * @param addUserModel
     * @return
     */
    public String saveUserRole(AddUserModel addUserModel);

    /**
     * 编辑角色信息
     * <p>编辑角色信息</p>
     *
     * @param roleModel
     */
    public String editRole(RoleModel roleModel);

    /**
     * 根据角色Id删除【角色表】和【角色权限资源表】中的数据
     * <p>根据角色Id删除【角色表】和【角色权限资源表】中的数据</p>
     *
     * @param roleId
     */
    public String deleteRole(long roleId);

    /**
     * 角色名是否唯一check
     *
     * @param roleName
     * @return
     */
    public String roleNameUniqueCheck(long roleId, String roleName);
}
