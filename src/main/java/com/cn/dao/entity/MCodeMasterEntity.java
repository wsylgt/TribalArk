package com.cn.dao.entity;

import com.cn.dao.entity.id.MCodeMasterPk;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


/**
 * 编码信息表Entity
 * <p>保存编码信息表数据的Entity类<br>
 * @author 孙亮
 * @version 1.0 2016/5/4
 */
@Entity
@Table(name="m_code_master_t")
@IdClass(MCodeMasterPk.class)
public class MCodeMasterEntity implements Serializable {

    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 编码组ID */
    @Id
    @Column(name="code_group_id")
    private String codeGroupId;

    /** 编码ID */
    @Id
    @Column(name="code_id")
    private String codeId;

    /** 编码组名称 */
    @Column(name="code_group_name")
    private String codeGroupName;

    /** 编码名称 */
    @Column(name="code_name")
    private String codeName;

    /** 编码别名 */
    @Column(name="code_aliases")
    private String codeAliases;

    /** 表示标识 */
    @Column(name="show_flag")
    private String showFlag;

    /** 表示顺序 */
    @Column(name="sort_order")
    private Integer sortOrder;

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

    /**
     * 编码组ID的取得
     * @return 编码组ID
     */
    public String getCodeGroupId() {
        return this.codeGroupId;
    }

    /**
     * 编码组ID的设定
     * @param codeGroupId 编码组ID
     */
    public void setCodeGroupId(String codeGroupId) {
        this.codeGroupId = codeGroupId;
    }

    /**
     * 编码ID的取得
     * @return 编码ID
     */
    public String getCodeId() {
        return this.codeId;
    }

    /**
     * 编码ID的设定
     * @param codeId 编码ID
     */
    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    /**
     * 编码组名称的取得
     * @return 编码组名称
     */
    public String getCodeGroupName() {
        return this.codeGroupName;
    }

    /**
     * 编码组名称的设定
     * @param codeGroupName 编码组名称
     */
    public void setCodeGroupName(String codeGroupName) {
        this.codeGroupName = codeGroupName;
    }

    /**
     * 编码名称的取得
     * @return 编码名称
     */
    public String getCodeName() {
        return this.codeName;
    }

    /**
     * 编码名称的设定
     * @param codeName 编码名称
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    /**
     * 编码别名的取得
     * @return 编码别名
     */
    public String getCodeAliases() {
        return this.codeAliases;
    }

    /**
     * 编码别名的设定
     * @param codeAliases 编码别名
     */
    public void setCodeAliases(String codeAliases) {
        this.codeAliases = codeAliases;
    }

    /**
     * 表示标识的取得
     * @return 表示标识
     */
    public String getShowFlag() {
        return this.showFlag;
    }

    /**
     * 表示标识的设定
     * @param showFlag 表示标识
     */
    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
    }

    /**
     * 表示顺序的取得
     * @return 表示顺序
     */
    public Integer getSortOrder() {
        return this.sortOrder;
    }

    /**
     * 表示顺序的设定
     * @param sortOrder 表示顺序
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
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

        // 编码组ID
        sbBeanContent.append("codeGroupId=");
        sbBeanContent.append(codeGroupId);
        sbBeanContent.append(",");

        // 编码ID
        sbBeanContent.append("codeId=");
        sbBeanContent.append(codeId);
        sbBeanContent.append(",");

        // 编码组名称
        sbBeanContent.append("codeGroupName=");
        sbBeanContent.append(codeGroupName);
        sbBeanContent.append(",");

        // 编码名称
        sbBeanContent.append("codeName=");
        sbBeanContent.append(codeName);
        sbBeanContent.append(",");

        // 编码别名
        sbBeanContent.append("codeAliases=");
        sbBeanContent.append(codeAliases);
        sbBeanContent.append(",");

        // 表示标识
        sbBeanContent.append("showFlag=");
        sbBeanContent.append(showFlag);
        sbBeanContent.append(",");

        // 表示顺序
        sbBeanContent.append("sortOrder=");
        sbBeanContent.append(sortOrder);
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
