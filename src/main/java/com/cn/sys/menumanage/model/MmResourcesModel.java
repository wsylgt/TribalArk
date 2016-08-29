package com.cn.sys.menumanage.model;

import com.cn.sys.authoritymanage.model.AmAuthoritiesModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 资源表
 * <p>资源表<br>
 * @author 王成龙
 * @version 1.0 2016/4/27
 */
public class MmResourcesModel implements Serializable {

    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 资源ID */
    private long resourceId;

    /** 资源标识 */
    private String resourceMark;

    /** 资源名称 */
    private String resourceName;

    /** 资源类型 */
    private String resourceType;

    /** 资源所属ID */
    private long attributionId;

    /** 资源链接 */
    private String resourceString;

    /** 资源描述 */
    private String resourceDescribe;

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

    /** 权限List */
    private List<AmAuthoritiesModel> authorities;

    /**
     * 权限List的取得
     * @return 权限List
     */
    public List<AmAuthoritiesModel> getAuthorities() {
        return authorities;
    }

    /**
     * 权限List的设定
     * @param authorities 权限List
     */
    public void setAuthorities(List<AmAuthoritiesModel> authorities) {
        this.authorities = authorities;
    }

    /**
     * 资源ID的取得
     * @return 资源ID
     */
    public long getResourceId() {
        return this.resourceId;
    }

    /**
     * 资源ID的设定
     * @param resourceId 资源ID
     */
    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 资源标识的取得
     * @return 资源标识
     */
    public String getResourceMark() {
        return this.resourceMark;
    }

    /**
     * 资源标识的设定
     * @param resourceMark 资源标识
     */
    public void setResourceMark(String resourceMark) {
        this.resourceMark = resourceMark;
    }

    /**
     * 资源名称的取得
     * @return 资源名称
     */
    public String getResourceName() {
        return this.resourceName;
    }

    /**
     * 资源名称的设定
     * @param resourceName 资源名称
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * 资源类型的取得
     * @return 资源类型
     */
    public String getResourceType() {
        return this.resourceType;
    }

    /**
     * 资源类型的设定
     * @param resourceType 资源类型
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * 资源所属ID的取得
     * @return 资源所属ID
     */
    public long getAttributionId() {
        return this.attributionId;
    }

    /**
     * 资源所属ID的设定
     * @param attributionId 资源所属ID
     */
    public void setAttributionId(long attributionId) {
        this.attributionId = attributionId;
    }

    /**
     * 资源链接的取得
     * @return 资源链接
     */
    public String getResourceString() {
        return this.resourceString;
    }

    /**
     * 资源链接的设定
     * @param resourceString 资源链接
     */
    public void setResourceString(String resourceString) {
        this.resourceString = resourceString;
    }

    /**
     * 资源描述的取得
     * @return 资源描述
     */
    public String getResourceDescribe() {
        return this.resourceDescribe;
    }

    /**
     * 资源描述的设定
     * @param resourceDescribe 资源描述
     */
    public void setResourceDescribe(String resourceDescribe) {
        this.resourceDescribe = resourceDescribe;
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

        // 资源ID
        sbBeanContent.append("resourceId=");
        sbBeanContent.append(resourceId);
        sbBeanContent.append(",");

        // 资源标识
        sbBeanContent.append("resourceMark=");
        sbBeanContent.append(resourceMark);
        sbBeanContent.append(",");

        // 资源名称
        sbBeanContent.append("resourceName=");
        sbBeanContent.append(resourceName);
        sbBeanContent.append(",");

        // 资源类型
        sbBeanContent.append("resourceType=");
        sbBeanContent.append(resourceType);
        sbBeanContent.append(",");

        // 资源所属ID
        sbBeanContent.append("attributionId=");
        sbBeanContent.append(attributionId);
        sbBeanContent.append(",");

        // 资源链接
        sbBeanContent.append("resourceString=");
        sbBeanContent.append(resourceString);
        sbBeanContent.append(",");

        // 资源描述
        sbBeanContent.append("resourceDescribe=");
        sbBeanContent.append(resourceDescribe);
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

        sbBeanContent.append(authorities.toString());

        return sbBeanContent.toString();
    }
}
