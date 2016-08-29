/**
 * 角色Model
 * <p>系统所有的角色Model </p>
 * Copyright 2016-2016 .
 */
package com.cn.sys.usermanage.model;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 角色Model
 * <p>角色Model</p>
 * @author 王成龙
 * @version 1.0 2016/5/7
 */
public class RoleModel implements Serializable {

    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 角色ID */
    private long roleId;

    /** 角色标识 */
    private String roleMark;

    /** 角色名称 */
    @Size(min = 1, max = 30, message = "{Message_Id_0016}")
    private String roleName;

    /** 角色描述 */
    @Size(max = 60, message = "{Message_Id_0016}")
    private String roleDescription;

    /** 备注 */
    private String remarks;

    /** 创建用户 */
    private String createUser;

    /** 创建时间 */
    private Date createTime;

    /** 更新用户 */
    private String updateUser;

    /** 更新时间 */
    private Date updateTime;

    /** 属于该角色的用户数 */
    private long userCount;

    /**
     * 用户数的取得
     * @return 用户数
     */
    public long getUserCount() {
        return userCount;
    }

    /**
     * 用户数的设定
     * @param userCount 用户数
     */
    public void setUserCount(long userCount) {
        this.userCount = userCount;
    }

    /**
     * 角色ID的取得
     * @return 角色ID
     */
    public long getRoleId() {
        return this.roleId;
    }

    /**
     * 角色ID的设定
     * @param roleId 角色ID
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    /**
     * 角色标识的取得
     * @return 角色标识
     */
    public String getRoleMark() {
        return this.roleMark;
    }

    /**
     * 角色标识的设定
     * @param roleMark 角色标识
     */
    public void setRoleMark(String roleMark) {
        this.roleMark = roleMark;
    }

    /**
     * 角色名称的取得
     * @return 角色名称
     */
    public String getRoleName() {
        return this.roleName;
    }

    /**
     * 角色名称的设定
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 角色描述的取得
     * @return 角色描述
     */
    public String getRoleDescription() {
        return this.roleDescription;
    }

    /**
     * 角色描述的设定
     * @param roleDescription 角色描述
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    /**
     * 备注的取得
     * @return 备注
     */
    public String getRemarks() {
        return this.remarks;
    }

    /**
     * 备注的设定
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 创建用户的取得
     * @return 创建用户
     */
    public String getCreateUser() {
        return this.createUser;
    }

    /**
     * 创建用户的设定
     * @param createUser 创建用户
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 创建时间的取得
     * @return 创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 创建时间的设定
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新用户的取得
     * @return 更新用户
     */
    public String getUpdateUser() {
        return this.updateUser;
    }

    /**
     * 更新用户的设定
     * @param updateUser 更新用户
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 更新时间的取得
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 更新时间的设定
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 重写toString方法
     * @return 返回对象的内容
     */
    @Override
    public String toString() {

        // bean内容
        StringBuilder sbBeanContent = new StringBuilder();
        sbBeanContent.append("[");

        // 角色ID
        sbBeanContent.append("roleId=");
        sbBeanContent.append(roleId);
        sbBeanContent.append(",");

        // 角色标识
        sbBeanContent.append("roleMark=");
        sbBeanContent.append(roleMark);
        sbBeanContent.append(",");

        // 角色名称
        sbBeanContent.append("roleName=");
        sbBeanContent.append(roleName);
        sbBeanContent.append(",");

        // 角色描述
        sbBeanContent.append("roleDescription=");
        sbBeanContent.append(roleDescription);
        sbBeanContent.append(",");

        // 备注
        sbBeanContent.append("remarks=");
        sbBeanContent.append(remarks);
        sbBeanContent.append(",");

        // 创建用户
        sbBeanContent.append("createUser=");
        sbBeanContent.append(createUser);
        sbBeanContent.append(",");

        // 创建时间
        sbBeanContent.append("createTime=");
        sbBeanContent.append(createTime);
        sbBeanContent.append(",");

        // 更新用户
        sbBeanContent.append("updateUser=");
        sbBeanContent.append(updateUser);
        sbBeanContent.append(",");

        // 更新时间
        sbBeanContent.append("updateTime=");
        sbBeanContent.append(updateTime);
        sbBeanContent.append("]");
        return sbBeanContent.toString();
    }
}
