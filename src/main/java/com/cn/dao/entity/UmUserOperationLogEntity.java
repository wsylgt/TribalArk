package com.emall.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * 用户操作日志表Entity
 * <p>用户操作日志表</p>
 * @author 刘广飞
 * @version 1.0 2016/05/24
 */
@Entity
@Table(name = "um_user_operation_log_t")
public class UmUserOperationLogEntity implements Serializable{

    /** 版本号 */
    private static final long serialVersionUID = 1L;

    /** 日志ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private long logId;
    
    /** 操作者ID */
    @Column(name = "user_id")
    private long userId;
    
    /** 操作者名 */
    @Column(name = "user_name")
    private String userName;
    
    /** 操作内容 */
    @Column(name = "operation_content")
    private String operationContent;
    
    /** 操作时间 */
    @Column(name = "operation_date")
    private Date operationDate;

    /** 登录IP */
    @Column(name="loginIP")
    private String loginIP;

    /** 操作方法 */
    @Column(name="method")
    private String method;

    /** 请求参数 */
    @Column(name="params")
    private String params;

    /** 备注 */
    @Column(name = "remarks")
    private String remarks;
    
    /** 创建用户 */
    @Column(name = "create_user")
    private String createUser;
    
    /** 创建时间 */
    @Column(name = "create_time")
    private Date createTime;
    
    /** 更新用户 */
    @Column(name = "update_user")
    private String updateUser;
    
    /** 更新时间 */
    @Column(name = "update_time")
    private Date updateTime;
    
    /** 版本号 */
    @Version
    @Column(name="version_no")
    private Long versionNo;

    /**
     * @return logId 返回
     */
    public long getLogId() {
        return logId;
    }

    /**
     * @param logId 设定
     */
    public void setLogId(long logId) {
        this.logId = logId;
    }

    /**
     * @return userId 返回
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId 设定
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * @return userName 返回
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName 设定
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return operationContent 返回
     */
    public String getOperationContent() {
        return operationContent;
    }

    /**
     * @param operationContent 设定
     */
    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent;
    }

    /**
     * @return operationDate 返回
     */
    public Date getOperationDate() {
        return operationDate;
    }

    /**
     * @param operationDate 设定
     */
    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    /**
     * 登录IP的取得
     * @return 登录IP
     */
    public String getLoginIP() {
        return this.loginIP;
    }

    /**
     * 登录IP的设定
     * @param loginIP 登录IP
     */
    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    /**
     * 操作方法名的取得
     * @param method 使用方法名
     */
    public String getMethod() {
        return method;
    }
    
    /**
     * 操作方法名的设定
     * @param method 使用方法名
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 请求参数的取得
     * @return 请求参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 请求参数的设定
     * @param params 请求参数
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * @return remarks 返回
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks 设定
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return createUser 返回
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser 设定
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return createTime 返回
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 设定
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return updateUser 返回
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser 设定
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * @return updateTime 返回
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 设定
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
    
}
