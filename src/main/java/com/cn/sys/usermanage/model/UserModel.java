package com.cn.sys.usermanage.model;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.Date;
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

    /** 邮箱 */
    @Email(message = "{Message_Id_0033}")
    private String email;
    
    /** 身份证号码 */
    @Size(max = 30, message = "{Message_Id_0007}")
    private String idCardNo;

    /** 手机号 */
    @Size(max = 11, message = "{Message_Id_0007}")
    private String cellphoneNo;

    /** 工号 */
    @Size(max = 20, message = "{Message_Id_0007}")
    private String employeeNo;

    /** 用户描述 */
    @Size(max = 20, message = "{Message_Id_0007}")
    private String userDescription;
    
    /** 性别编码ID */
    private String sexCodeId;

    /** 用户性质编码ID */
    private String userPropertyCodeId;

    /** 用户状态编码ID */
    private String userStatusCodeId;
    
    /** 是否删除, 0: 否, 1: 是 */
    private String isDelete;
    
    /** 创建时间 */
    private Date createTime;
    
    /** 角色ID集合 */
    private Set<Long> roleIdSet;
    
    /** 角色ID */
    private long roleId;
    
    /** Page对象 */
    private Page<UserModel> page;

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
     * @return isDelete 返回
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete 设定
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
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
     * @return roleIdSet 返回
     */
    public Set<Long> getRoleIdSet() {
        return roleIdSet;
    }

    /**
     * @param roleIdSet 设定
     */
    public void setRoleIdSet(Set<Long> roleIdSet) {
        this.roleIdSet = roleIdSet;
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
     * @return page 返回
     */
    public Page<UserModel> getPage() {
        return page;
    }

    /**
     * @param page 设定
     */
    public void setPage(Page<UserModel> page) {
        this.page = page;
    }
}
