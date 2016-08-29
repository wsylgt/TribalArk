package com.cn.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 菜单管理表
 * <p>菜单管理表<br>
 * @author 王成龙
 * @version 1.0 2016/4/25
 */
@Entity
@Table(name="mm_menu_manage_t")
public class MmMenuManageEntity implements Serializable {

    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 菜单ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="menu_id")
    private long menuId;

    /** 菜单标识 */
    @Column(name="menu_mark")
    private String menuMark;

    /** 菜单名 */
    @Column(name="menu_name")
    private String menuName;

    /** 菜单描述 */
    @Column(name="menu_describe")
    private String menuDescribe;

    /** 所属菜单组ID */
    @Column(name="menu_group_id")
    private long menuGroupId;

    /** 备注 */
    @Column(name="remarks")
    private String remarks;

    /** 创建用户 */
    @Column(name="create_user")
    private String createUser;

    /** 创建时间 */
    @Column(name="create_time")
    private Date createTime;

    /** 更新用户 */
    @Column(name="update_user")
    private String updateUser;

    /** 更新时间 */
    @Column(name="update_time")
    private Date updateTime;

    /** 版本号 */
    @Version
    @Column(name="version_no")
    private Long versionNo;

    /**
     * 菜单ID的取得
     * @return 菜单ID
     */
    public long getMenuId() {
        return this.menuId;
    }

    /**
     * 菜单ID的设定
     * @param menuId 菜单ID
     */
    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    /**
     * 菜单标识的取得
     * @return 菜单标识
     */
    public String getMenuMark() {
        return this.menuMark;
    }

    /**
     * 菜单标识的设定
     * @param menuMark 菜单标识
     */
    public void setMenuMark(String menuMark) {
        this.menuMark = menuMark;
    }

    /**
     * 菜单名的取得
     * @return 菜单名
     */
    public String getMenuName() {
        return this.menuName;
    }

    /**
     * 菜单名的设定
     * @param menuName 菜单名
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 菜单描述的取得
     * @return 菜单描述
     */
    public String getMenuDescribe() {
        return this.menuDescribe;
    }

    /**
     * 菜单描述的设定
     * @param menuDescribe 菜单描述
     */
    public void setMenuDescribe(String menuDescribe) {
        this.menuDescribe = menuDescribe;
    }

    /**
     * 所属菜单组ID的取得
     * @return 所属菜单组ID
     */
    public long getMenuGroupId() {
        return this.menuGroupId;
    }

    /**
     * 所属菜单组ID的设定
     * @param menuGroupId 所属菜单组ID
     */
    public void setMenuGroupId(long menuGroupId) {
        this.menuGroupId = menuGroupId;
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
     * 版本号的取得
     * @return 版本号
     */
    public Long getVersionNo() {
        return versionNo;
    }

    /**
     * 版本号的设定
     * @param versionNo 版本号
     */
    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
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

        // 菜单ID
        sbBeanContent.append("menuId=");
        sbBeanContent.append(menuId);
        sbBeanContent.append(",");

        // 菜单标识
        sbBeanContent.append("menuMark=");
        sbBeanContent.append(menuMark);
        sbBeanContent.append(",");

        // 菜单名
        sbBeanContent.append("menuName=");
        sbBeanContent.append(menuName);
        sbBeanContent.append(",");

        // 菜单描述
        sbBeanContent.append("menuDescribe=");
        sbBeanContent.append(menuDescribe);
        sbBeanContent.append(",");

        // 所属菜单组ID
        sbBeanContent.append("menuGroupId=");
        sbBeanContent.append(menuGroupId);
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
        sbBeanContent.append(",");

        // 版本号
        sbBeanContent.append("versionNo=");
        sbBeanContent.append(versionNo);
        sbBeanContent.append("]");

        return sbBeanContent.toString();
    }
}
