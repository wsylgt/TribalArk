package com.cn.sys.menumanage.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作管理表
 * <p>操作管理表<br>
 * @author 王成龙
 * @version 1.0 2016/4/26
 */
public class MmHandleManageModel implements Serializable {

    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 操作ID */
    private long handleId;

    /** 操作标识 */
    private String handleMark;

    /** 操作名 */
    private String handleName;

    /** 操作属性 */
    private String handleProperty;

    /** 所属菜单ID */
    private long menuId;

    /** 操作描述 */
    private String handleDescribe;

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

    /**
     * 操作ID的取得
     * @return 操作ID
     */
    public long getHandleId() {
        return this.handleId;
    }

    /**
     * 操作ID的设定
     * @param handleId 操作ID
     */
    public void setHandleId(long handleId) {
        this.handleId = handleId;
    }

    /**
     * 操作标识的取得
     * @return 操作标识
     */
    public String getHandleMark() {
        return this.handleMark;
    }

    /**
     * 操作标识的设定
     * @param handleMark 操作标识
     */
    public void setHandleMark(String handleMark) {
        this.handleMark = handleMark;
    }

    /**
     * 操作名的取得
     * @return 操作名
     */
    public String getHandleName() {
        return this.handleName;
    }

    /**
     * 操作名的设定
     * @param handleName 操作名
     */
    public void setHandleName(String handleName) {
        this.handleName = handleName;
    }

    /**
     * 操作属性的取得
     * @return 操作属性
     */
    public String getHandleProperty() {
        return this.handleProperty;
    }

    /**
     * 操作属性的设定
     * @param handleProperty 操作属性
     */
    public void setHandleProperty(String handleProperty) {
        this.handleProperty = handleProperty;
    }

    /**
     * 所属菜单ID的取得
     * @return 所属菜单ID
     */
    public long getMenuId() {
        return this.menuId;
    }

    /**
     * 所属菜单ID的设定
     * @param menuId 所属菜单ID
     */
    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    /**
     * 操作描述的取得
     * @return 操作描述
     */
    public String getHandleDescribe() {
        return this.handleDescribe;
    }

    /**
     * 操作描述的设定
     * @param handleDescribe 操作描述
     */
    public void setHandleDescribe(String handleDescribe) {
        this.handleDescribe = handleDescribe;
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

        // 操作ID
        sbBeanContent.append("handleId=");
        sbBeanContent.append(handleId);
        sbBeanContent.append(",");

        // 操作标识
        sbBeanContent.append("handleMark=");
        sbBeanContent.append(handleMark);
        sbBeanContent.append(",");

        // 操作名
        sbBeanContent.append("handleName=");
        sbBeanContent.append(handleName);
        sbBeanContent.append(",");

        // 操作属性
        sbBeanContent.append("handleProperty=");
        sbBeanContent.append(handleProperty);
        sbBeanContent.append(",");

        // 所属菜单ID
        sbBeanContent.append("menuId=");
        sbBeanContent.append(menuId);
        sbBeanContent.append(",");

        // 操作描述
        sbBeanContent.append("handleDescribe=");
        sbBeanContent.append(handleDescribe);
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
