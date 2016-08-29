package com.cn.sys.usermanage.model;

import org.springframework.data.domain.Page;

public class UserRoleModel {

    /** 用户角色ID */
    private long userRoleId;

    /** 角色ID */
    private long roleId;

    /** 用户ID */
    private long userId;

    /** 备注 */
    private String remarks;

    /** Page对象 */
    private Page<UserRoleModel> page;

    /**
     * 用户角色ID取得
     * @return userRoleId
     */
    public long getUserRoleId() {
        return userRoleId;
    }

    /**
     * 用户角色ID设定
     * @param userRoleId
     */
    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * 角色ID取得
     * @return roleId
     */
    public long getRoleId() {
        return roleId;
    }

    /**
     * 角色ID设定
     * @param roleId
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    /**
     * 用户ID的取得
     * @return userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * 用户ID的设定
     * @param userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * 备注取得
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注设定
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * Page对象的取得
     * @return page
     */
    public Page<UserRoleModel> getPage() {
        return page;
    }

    /**
     * Page对象的设定
     * @param page
     */
    public void setPage(Page<UserRoleModel> page) {
        this.page = page;
    }

    
}
