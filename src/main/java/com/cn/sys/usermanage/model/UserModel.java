package com.cn.sys.usermanage.model;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.validation.constraints.Size;

/**
 * 用户Model
 * <p>用户Model<br>
 * @author 王成龙
 * @version 1.0 2016/4/25
 */
public class UserModel implements Serializable {

    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;

    /** 用户名 */
    @Size(max = 30, message = "{Message_Id_0007}")
    private String userName;

    /** 密码 */
    private String password;

    /** 密码 */
    private String confirmPassword;

    /** 邮箱 */
    @Email(message = "{Message_Id_0033}")
    private String email;
    
    /** 手机号 */
    @Size(max = 11, message = "{Message_Id_0007}")
    private String cellphoneNo;

    /** 座机号 */
    private String telephoneNo;

    /** QQ号 */
    private String qq;

    /** 微信号 */
    private String wechat;

    /** 工号 */
    @Size(max = 20, message = "{Message_Id_0007}")
    private String employeeNo;

    /** 所在部门 */
    private String department;

    /** 用户描述 */
    @Size(max = 20, message = "{Message_Id_0007}")
    private String userDescription;
    
    /** 性别编码ID */
    private String sexCodeId;

    /** 性别 */
    private String sex;

    /** 用户性质编码ID */
    private String userPropertyCodeId;

    /** 用户状态编码ID */
    private String userStatusCodeId;

    /**
     * 用户状态
     */
    private String userStatus;

    /** 备注 */
    private String remarks;

    /** 创建时间 */
    private Date versionNo;
    

    /**
     * @return userId 返回
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId 设定
     */
    public void setUserId(Long userId) {
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
     * @return password 返回
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password 设定
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return confirmPassword 返回
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword 设定
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return email 返回
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 设定
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return cellphoneNo 返回
     */
    public String getCellphoneNo() {
        return cellphoneNo;
    }

    /**
     * @param cellphoneNo 设定
     */
    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }

    /**
     * @return employeeNo 返回
     */
    public String getEmployeeNo() {
        return employeeNo;
    }

    /**
     * @param employeeNo 设定
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * @return userDescription 返回
     */
    public String getUserDescription() {
        return userDescription;
    }

    /**
     * @param userDescription 设定
     */
    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    /**
     * @return sexCodeId 返回
     */
    public String getSexCodeId() {
        return sexCodeId;
    }

    /**
     * @param sexCodeId 设定
     */
    public void setSexCodeId(String sexCodeId) {
        this.sexCodeId = sexCodeId;
    }

    /**
     * @return sex 返回
     */
    public String getSex() {
        return sex;
    }
    /**
     * @param sex 设定
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return userPropertyCodeId 返回
     */
    public String getUserPropertyCodeId() {
        return userPropertyCodeId;
    }

    /**
     * @param userPropertyCodeId 设定
     */
    public void setUserPropertyCodeId(String userPropertyCodeId) {
        this.userPropertyCodeId = userPropertyCodeId;
    }

    /**
     * @return userStatusCodeId 返回
     */
    public String getUserStatusCodeId() {
        return userStatusCodeId;
    }

    /**
     * @param userStatusCodeId 设定
     */
    public void setUserStatusCodeId(String userStatusCodeId) {
        this.userStatusCodeId = userStatusCodeId;
    }


    /**
     * @return userStatus 返回
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * @param userStatus 设定
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Date versionNo) {
        this.versionNo = versionNo;
    }

}
