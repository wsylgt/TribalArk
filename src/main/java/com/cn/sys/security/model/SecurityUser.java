/**
 * 用户登录验证
 * <p>用户登录验证<br> 
 * Copyright 2016-2016 .
 */
package com.cn.sys.security.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 数据库表um_user_t的实体类
 * <p>用户表<br>
 * @author 王成龙
 * @version 1.0 2016/4/23
 */
public class SecurityUser implements UserDetails {

	/**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /** 后台用户 */
    private User user;

    /** 用戶构造函数 */
    public SecurityUser(User user){
        this.user = user;
    }

    /**
     * 用户的取得
     *
     * @return user 用户
     */
    public User getUser() {
        return user;
    }

    /**
     * 后台用户的设定
     *
     * @param user 用户
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 权限的取得
     *
     * @return user.getAuthorities() 权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return user.getAuthorities();
    }

    /**
     * 密码的取得
     *
     * @return user.getPassword() 密码
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * 用户名的取得
     *
     * @return user.getUsername() 用户名
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * 账户是否过期,过期无法验证
     * 
     * @return true 没过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否被锁定或者解锁,锁定的用户无法进行身份验证
     * 
     * @return true 没锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     * 
     * @return true
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否被禁用,禁用的用户不能身份验证
     * 
     * @return true
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
