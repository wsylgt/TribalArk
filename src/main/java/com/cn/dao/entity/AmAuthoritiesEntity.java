package com.cn.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限表
 * <p>权限表<br>
 * @author 王成龙
 * @version 1.0 2016/4/25
 */
@Entity
@Table(name="am_authorities_t")
public class AmAuthoritiesEntity implements Serializable {

    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 权限ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="authority_id")
    private long authorityId;

    /** 权限标识 */
    @Column(name="authority_mark")
    private String authorityMark;

    /** 权限描述 */
    @Column(name="authority_describe")
    private String authorityDescribe;

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
     * 权限ID的取得
     * @return 权限ID
     */
    public long getAuthorityId() {
        return this.authorityId;
    }

    /**
     * 权限ID的设定
     * @param authorityId 权限ID
     */
    public void setAuthorityId(long authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * 权限标识的取得
     * @return 权限标识
     */
    public String getAuthorityMark() {
        return this.authorityMark;
    }

    /**
     * 权限标识的设定
     * @param authorityMark 权限标识
     */
    public void setAuthorityMark(String authorityMark) {
        this.authorityMark = authorityMark;
    }

    /**
     * 权限描述的取得
     * @return 权限描述
     */
    public String getAuthorityDescribe() {
        return this.authorityDescribe;
    }

    /**
     * 权限描述的设定
     * @param authorityDescribe 权限描述
     */
    public void setAuthorityDescribe(String authorityDescribe) {
        this.authorityDescribe = authorityDescribe;
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

        // 权限ID
        sbBeanContent.append("authorityId=");
        sbBeanContent.append(authorityId);
        sbBeanContent.append(",");

        // 权限标识
        sbBeanContent.append("authorityMark=");
        sbBeanContent.append(authorityMark);
        sbBeanContent.append(",");

        // 权限描述
        sbBeanContent.append("authorityDescribe=");
        sbBeanContent.append(authorityDescribe);
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
