package com.cn.sys.security.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Kris2 on 2016/8/25.
 */
public class User extends org.springframework.security.core.userdetails.User {

    /** 用户ID */
    private Long userId;

    /** 邮箱 */
    private String email;

    /** 手机号 */
    private String cellphoneNo;

    /** 座机号 */
    private String telephoneNo;

    /** QQ号 */
    private String qq;

    /** 微信号 */
    private String wechat;

    /** 工号 */
    private String employeeNo;

    /** 所在部门 */
    private String department;

    /** 用户描述 */
    private String userDescription;

    /** 性别编码组ID */
    private String sexGroupId;

    /** 性别编码ID */
    private String sexCodeId;

    /** 用户状态编码组ID */
    private String userStatusGroupId;

    /** 用户状态编码ID */
    private String userStatusCodeId;

    /** 备注 */
    private String remarks;


    /**
     * 用户ID的取得
     * @return 用户ID
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * 用户ID的设定
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 邮箱的取得
     * @return 邮箱
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 邮箱的设定
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 手机号的取得
     * @return 手机号
     */
    public String getCellphoneNo() {
        return this.cellphoneNo;
    }

    /**
     * 手机号的设定
     * @param cellphoneNo 手机号
     */
    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }

    /**
     * 座机号的取得
     * @return 座机号
     */
    public String getTelephoneNo() {
        return this.telephoneNo;
    }

    /**
     * 座机号的设定
     * @param telephoneNo 座机号
     */
    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    /**
     * QQ号的取得
     * @return QQ号
     */
    public String getQq() {
        return this.qq;
    }

    /**
     * QQ号的设定
     * @param qq QQ号
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 微信号的取得
     * @return 微信号
     */
    public String getWechat() {
        return this.wechat;
    }

    /**
     * 微信号的设定
     * @param wechat 微信号
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * 工号的取得
     * @return 工号
     */
    public String getEmployeeNo() {
        return this.employeeNo;
    }

    /**
     * 工号的设定
     * @param employeeNo 工号
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * 所在部门的取得
     * @return 所在部门
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * 所在部门的设定
     * @param department 所在部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 用户描述的取得
     * @return 用户描述
     */
    public String getUserDescription() {
        return this.userDescription;
    }

    /**
     * 用户描述的设定
     * @param userDescription 用户描述
     */
    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    /**
     * 用户状态编码组ID的取得
     * @return 用户状态编码组ID
     */
    public String getUserStatusGroupId() {
        return this.userStatusGroupId;
    }

    /**
     * 用户状态编码组ID的设定
     * @param userStatusGroupId 用户状态编码组ID
     */
    public void setUserStatusGroupId(String userStatusGroupId) {
        this.userStatusGroupId = userStatusGroupId;
    }

    /**
     * 用户状态编码ID的取得
     * @return 用户状态编码ID
     */
    public String getUserStatusCodeId() {
        return this.userStatusCodeId;
    }

    /**
     * 用户状态编码ID的设定
     * @param userStatusCodeId 用户状态编码ID
     */
    public void setUserStatusCodeId(String userStatusCodeId) {
        this.userStatusCodeId = userStatusCodeId;
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
     * 性别编码组ID取得
     * @return sexGroupId
     */
    public String getSexGroupId() {
        return sexGroupId;
    }

    /**
     * 性别编码组ID设定
     * @param sexGroupId
     */
    public void setSexGroupId(String sexGroupId) {
        this.sexGroupId = sexGroupId;
    }

    /**
     * 性别编码ID取得
     * @return the sexCodeId
     */
    public String getSexCodeId() {
        return sexCodeId;
    }

    /**
     * 性别编码ID设定
     * @param sexCodeId
     */
    public void setSexCodeId(String sexCodeId) {
        this.sexCodeId = sexCodeId;
    }

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public User(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
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

        // 用户ID
        sbBeanContent.append("userId=");
        sbBeanContent.append(userId);
        sbBeanContent.append(",");

        // 用户名
        sbBeanContent.append("userName=");
        sbBeanContent.append(super.getUsername());
        sbBeanContent.append(",");

        // 密码
        sbBeanContent.append("password=");
        sbBeanContent.append(super.getPassword());
        sbBeanContent.append(",");

        // 邮箱
        sbBeanContent.append("email=");
        sbBeanContent.append(email);
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


        sbBeanContent.append("authorities=");
        sbBeanContent.append(super.toString());
        sbBeanContent.append("]");
        return sbBeanContent.toString();
    }
}
