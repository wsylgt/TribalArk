/**
 * 用户Model
 * <p>用户Model </p>
 * Copyright 2016-2016 .
 */
package com.cn.sys.rolemanage.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户Model
 * <p>用户Model<br>
 *
 * @author 王成龙
 * @version 1.0 2016/4/25
 */
public class UserModel implements Serializable {

    /**
     * 序列化串号ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证号
     */
    private String idCardNo;

    /**
     * 手机号
     */
    private String cellphoneNo;

    /**
     * 座机号
     */
    private String telephoneNo;

    /**
     * QQ号
     */
    private String qq;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 工号
     */
    private String employeeNo;

    /**
     * 所在部门
     */
    private String department;

    /**
     * 用户描述
     */
    private String userDescription;

    /**
     * 性别编码组ID
     */
    private String sexGroupId;

    /**
     * 性别编码ID
     */
    private String sexCodeId;

    /**
     * 用户性质编码组ID
     */
    private String userPropertyGroupId;

    /**
     * 用户性质编码ID
     */
    private String userPropertyCodeId;

    /**
     * 用户性质名
     */
    private String userPropertyName;

    /**
     * 用户状态编码组ID
     */
    private String userStatusGroupId;

    /**
     * 用户状态编码ID
     */
    private String userStatusCodeId;

    /**
     * 用户状态名
     */
    private String userStatusName;

    /**
     * 是否删除flg
     */
    private String isDelete;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新用户
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 角色Id
     */
    private long roleId;

    /**
     * 角色Id的取得
     *
     * @return roleId 角色Id
     */
    public long getRoleId() {
        return roleId;
    }

    /**
     * 角色Id的设定
     *
     * @param roleId 角色Id
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    /**
     * 用户性质名的取得
     *
     * @return userPropertyName 用户性质名
     */
    public String getUserPropertyName() {
        return userPropertyName;
    }

    /**
     * 用户性质名的设定
     *
     * @param userPropertyName 用户性质名
     */
    public void setUserPropertyName(String userPropertyName) {
        this.userPropertyName = userPropertyName;
    }

    /**
     * 用户状态名的取得
     *
     * @return 用户状态名
     */
    public String getUserStatusName() {
        return userStatusName;
    }

    /**
     * 用户状态名的设定
     *
     * @param userStatusName 用户状态名
     */
    public void setUserStatusName(String userStatusName) {
        this.userStatusName = userStatusName;
    }

    /**
     * 用户ID的取得
     *
     * @return 用户ID
     */
    public long getUserId() {
        return this.userId;
    }

    /**
     * 用户ID的设定
     *
     * @param userId 用户ID
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * 用户名的取得
     *
     * @return 用户名
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 用户名的设定
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 密码的取得
     *
     * @return 密码
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 密码的设定
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 邮箱的取得
     *
     * @return 邮箱
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 邮箱的设定
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 身份证号的取得
     *
     * @return 身份证号
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * 身份证号的设定
     *
     * @param idCardNo 身份证号
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    /**
     * 手机号的取得
     *
     * @return 手机号
     */
    public String getCellphoneNo() {
        return this.cellphoneNo;
    }

    /**
     * 手机号的设定
     *
     * @param cellphoneNo 手机号
     */
    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }

    /**
     * 座机号的取得
     *
     * @return 座机号
     */
    public String getTelephoneNo() {
        return this.telephoneNo;
    }

    /**
     * 座机号的设定
     *
     * @param telephoneNo 座机号
     */
    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    /**
     * QQ号的取得
     *
     * @return QQ号
     */
    public String getQq() {
        return this.qq;
    }

    /**
     * QQ号的设定
     *
     * @param qq QQ号
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 微信号的取得
     *
     * @return 微信号
     */
    public String getWechat() {
        return this.wechat;
    }

    /**
     * 微信号的设定
     *
     * @param wechat 微信号
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * 工号的取得
     *
     * @return 工号
     */
    public String getEmployeeNo() {
        return this.employeeNo;
    }

    /**
     * 工号的设定
     *
     * @param employeeNo 工号
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * 所在部门的取得
     *
     * @return 所在部门
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * 所在部门的设定
     *
     * @param department 所在部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 用户描述的取得
     *
     * @return 用户描述
     */
    public String getUserDescription() {
        return this.userDescription;
    }

    /**
     * 用户描述的设定
     *
     * @param userDescription 用户描述
     */
    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    /**
     * 性别编码组ID的取得
     *
     * @return 性别编码组ID
     */
    public String getSexGroupId() {
        return sexGroupId;
    }

    /**
     * 性别编码组ID的设定
     *
     * @param sexGroupId 性别编码组ID
     */
    public void setSexGroupId(String sexGroupId) {
        this.sexGroupId = sexGroupId;
    }

    /**
     * 性别编码ID的取得
     *
     * @return 性别编码ID
     */
    public String getSexCodeId() {
        return sexCodeId;
    }

    /**
     * 性别编码ID的设定
     *
     * @param sexCodeId 性别编码ID
     */
    public void setSexCodeId(String sexCodeId) {
        this.sexCodeId = sexCodeId;
    }

    /**
     * 用户性质编码组ID的取得
     *
     * @return 用户性质编码组ID
     */
    public String getUserPropertyGroupId() {
        return this.userPropertyGroupId;
    }

    /**
     * 用户性质编码组ID的设定
     *
     * @param userPropertyGroupId 用户性质编码组ID
     */
    public void setUserPropertyGroupId(String userPropertyGroupId) {
        this.userPropertyGroupId = userPropertyGroupId;
    }

    /**
     * 用户性质编码ID的取得
     *
     * @return 用户性质编码ID
     */
    public String getUserPropertyCodeId() {
        return this.userPropertyCodeId;
    }

    /**
     * 用户性质编码ID的设定
     *
     * @param userPropertyCodeId 用户性质编码ID
     */
    public void setUserPropertyCodeId(String userPropertyCodeId) {
        this.userPropertyCodeId = userPropertyCodeId;
    }

    /**
     * 用户状态编码组ID的取得
     *
     * @return 用户状态编码组ID
     */
    public String getUserStatusGroupId() {
        return this.userStatusGroupId;
    }

    /**
     * 用户状态编码组ID的设定
     *
     * @param userStatusGroupId 用户状态编码组ID
     */
    public void setUserStatusGroupId(String userStatusGroupId) {
        this.userStatusGroupId = userStatusGroupId;
    }

    /**
     * 用户状态编码ID的取得
     *
     * @return 用户状态编码ID
     */
    public String getUserStatusCodeId() {
        return this.userStatusCodeId;
    }

    /**
     * 用户状态编码ID的设定
     *
     * @param userStatusCodeId 用户状态编码ID
     */
    public void setUserStatusCodeId(String userStatusCodeId) {
        this.userStatusCodeId = userStatusCodeId;
    }

    /**
     * 是否删除flg的取得
     *
     * @return 是否删除flg
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除flg的设定
     *
     * @param isDelete 是否删除flg
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 备注的取得
     *
     * @return 备注
     */
    public String getRemarks() {
        return this.remarks;
    }

    /**
     * 备注的设定
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 创建用户的取得
     *
     * @return 创建用户
     */
    public String getCreateUser() {
        return this.createUser;
    }

    /**
     * 创建用户的设定
     *
     * @param createUser 创建用户
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 创建时间的取得
     *
     * @return 创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 创建时间的设定
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新用户的取得
     *
     * @return 更新用户
     */
    public String getUpdateUser() {
        return this.updateUser;
    }

    /**
     * 更新用户的设定
     *
     * @param updateUser 更新用户
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 更新时间的取得
     *
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 更新时间的设定
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 重写toString方法
     *
     * @return 返回对象的内容
     */
    @Override
    public String toString() {

        // bean内容
        StringBuilder sbBeanContent = new StringBuilder();
        sbBeanContent.append("[");

        // 用户ID
        sbBeanContent.append("userId=");
        sbBeanContent.append(userId);
        sbBeanContent.append(",");

        // 用户名
        sbBeanContent.append("userName=");
        sbBeanContent.append(userName);
        sbBeanContent.append(",");

        // 密码
        sbBeanContent.append("password=");
        sbBeanContent.append(password);
        sbBeanContent.append(",");

        // 邮箱
        sbBeanContent.append("email=");
        sbBeanContent.append(email);
        sbBeanContent.append(",");

        // 身份证号
        sbBeanContent.append("idCardNo=");
        sbBeanContent.append(idCardNo);
        sbBeanContent.append(",");

        // 手机号
        sbBeanContent.append("cellphoneNo=");
        sbBeanContent.append(cellphoneNo);
        sbBeanContent.append(",");

        // 座机号
        sbBeanContent.append("telephoneNo=");
        sbBeanContent.append(telephoneNo);
        sbBeanContent.append(",");

        // QQ号
        sbBeanContent.append("qq=");
        sbBeanContent.append(qq);
        sbBeanContent.append(",");

        // 微信号
        sbBeanContent.append("wechat=");
        sbBeanContent.append(wechat);
        sbBeanContent.append(",");

        // 工号
        sbBeanContent.append("employeeNo=");
        sbBeanContent.append(employeeNo);
        sbBeanContent.append(",");

        // 所在部门
        sbBeanContent.append("department=");
        sbBeanContent.append(department);
        sbBeanContent.append(",");

        // 用户描述
        sbBeanContent.append("userDescription=");
        sbBeanContent.append(userDescription);
        sbBeanContent.append(",");

        // 性别编码组ID
        sbBeanContent.append("sexGroupId=");
        sbBeanContent.append(sexGroupId);
        sbBeanContent.append(",");

        // 性别编码ID
        sbBeanContent.append("sexCodeId=");
        sbBeanContent.append(sexCodeId);
        sbBeanContent.append(",");

        // 用户性质编码组ID
        sbBeanContent.append("userPropertyGroupId=");
        sbBeanContent.append(userPropertyGroupId);
        sbBeanContent.append(",");

        // 用户性质编码ID
        sbBeanContent.append("userPropertyCodeId=");
        sbBeanContent.append(userPropertyCodeId);
        sbBeanContent.append(",");

        // 用户状态编码组ID
        sbBeanContent.append("userStatusGroupId=");
        sbBeanContent.append(userStatusGroupId);
        sbBeanContent.append(",");

        // 用户状态编码ID
        sbBeanContent.append("userStatusCodeId=");
        sbBeanContent.append(userStatusCodeId);
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
