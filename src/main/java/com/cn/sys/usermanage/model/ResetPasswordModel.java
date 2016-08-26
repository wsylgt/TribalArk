package com.emall.um.usermanage.model;

import java.io.Serializable;

/**
 * 重置用户密码Model
 * <p>重置用户密码Model<p>
 * @author 刘广飞
 * @version 1.0 2016/05/21
 */
public class ResetPasswordModel implements Serializable{

    /** 序列化版本号 */
    private static final long serialVersionUID = 1L;
    
    /** 后台用户ID */
    private Long userId;
    
    /** 后台用户登录密码 */
    private String confirmPassword;

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

}
