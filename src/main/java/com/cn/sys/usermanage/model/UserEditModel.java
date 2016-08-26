package com.emall.um.usermanage.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * 遍历后台用户Model
 * <p>遍历后台用户Model<p>
 * @author 刘广飞
 * @version 1.0 2016/05/20
 */
public class UserEditModel implements Serializable{

    /** 序列化版本号 */
    private static final long serialVersionUID = 1L;
    
    /** 用户ID */
    private Long userId;
    
    /** 员工号 */
    @NotNull
    private String employeeNo;
    
    /** 用户名 */
    @NotNull
    private String userName;

    /** 身份证号码 */
    @Size(max = 30, message = "{Message_Id_0007}")
    private String idCardNo;
    
    /** 性别编码ID */
    private String sexCodeId;

    /** 手机号 */
    @Size(max = 11, message = "{Message_Id_0007}")
    private String cellphoneNo;
    
    /** 邮箱 */
    @Email(message = "{Message_Id_0033}")
    private String email;
    
    /** 角色ID */
    private long roleId;
    
    /** 用户性质编码ID */
    private String userPropertyCodeId;

    /** 用户描述 */
    @Size(max = 20, message = "{Message_Id_0007}")
    private String userDescription;

    /**
     * @return userId 返回
     */
    public Long getUserId() {
        return userId;
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
     * @return idCardNo 返回
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * @param idCardNo 设定
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
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
     * @return roleId 返回
     */
    public long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId 设定
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
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
     * @param userId 设定
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
