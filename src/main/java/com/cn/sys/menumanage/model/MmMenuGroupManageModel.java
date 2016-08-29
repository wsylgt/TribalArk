package com.cn.sys.menumanage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单组管理表
 * <p>菜单组管理表<br>
 * @author 王成龙
 * @version 1.0 2016/4/26
 */
public class MmMenuGroupManageModel implements Serializable {

    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 菜单组ID */
    private long menuGroupId;

    /** 菜单组标识 */
    private String menuGroupMark;

    /** 菜单组名 */
    private String menuGroupName;

    /** 菜单组描述 */
    private String menuGroupDescribe;

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

    /**  菜单组中的菜单项 */
    private List<MmMenuManageModel> menuList;

    /**
     * 菜单组中的菜单取得
     * @return 菜单组ID
     */
    public List<MmMenuManageModel> getMenuList() {
        return menuList;
    }

    /**
     * 菜单组中的菜单设定
     * @param menuList 菜单组ID
     */
    public void setMenuList(List<MmMenuManageModel> menuList) {
        this.menuList = menuList;
    }

    /**
     * 菜单组ID的取得
     * @return 菜单组ID
     */
    public long getMenuGroupId() {
        return this.menuGroupId;
    }

    /**
     * 菜单组ID的设定
     * @param menuGroupId 菜单组ID
     */
    public void setMenuGroupId(long menuGroupId) {
        this.menuGroupId = menuGroupId;
    }

    /**
     * 菜单组标识的取得
     * @return 菜单组标识
     */
    public String getMenuGroupMark() {
        return this.menuGroupMark;
    }

    /**
     * 菜单组标识的设定
     * @param menuGroupMark 菜单组标识
     */
    public void setMenuGroupMark(String menuGroupMark) {
        this.menuGroupMark = menuGroupMark;
    }

    /**
     * 菜单组名的取得
     * @return 菜单组名
     */
    public String getMenuGroupName() {
        return this.menuGroupName;
    }

    /**
     * 菜单组名的设定
     * @param menuGroupName 菜单组名
     */
    public void setMenuGroupName(String menuGroupName) {
        this.menuGroupName = menuGroupName;
    }

    /**
     * 菜单组描述的取得
     * @return 菜单组描述
     */
    public String getMenuGroupDescribe() {
        return this.menuGroupDescribe;
    }

    /**
     * 菜单组描述的设定
     * @param menuGroupDescribe 菜单组描述
     */
    public void setMenuGroupDescribe(String menuGroupDescribe) {
        this.menuGroupDescribe = menuGroupDescribe;
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

        // 菜单组ID
        sbBeanContent.append("menuGroupId=");
        sbBeanContent.append(menuGroupId);
        sbBeanContent.append(",");

        // 菜单组标识
        sbBeanContent.append("menuGroupMark=");
        sbBeanContent.append(menuGroupMark);
        sbBeanContent.append(",");

        // 菜单组名
        sbBeanContent.append("menuGroupName=");
        sbBeanContent.append(menuGroupName);
        sbBeanContent.append(",");

        // 菜单组描述
        sbBeanContent.append("menuGroupDescribe=");
        sbBeanContent.append(menuGroupDescribe);
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
