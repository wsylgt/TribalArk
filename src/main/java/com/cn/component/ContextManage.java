/**
 * 系统共通方法
 *
 * Copyright 2016-2016 .
 */
package com.cn.component;

import com.cn.model.StatusModel;
import com.cn.sys.security.model.SecurityUser;
import com.cn.sys.security.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;


/**
 * 系统共通方法
 * <p>系统的Context操作<br>
 * @author 苏振江
 * @version 1.0 2016/04/22
 */
@Component
public class ContextManage {

    /** 日志对象 */
    private static Log logger = LogFactory.getLog(ContextManage.class);


    /**
     * 取得用户信息
     * <p>从Context内取出用户<br>
     * @return 用户信息
     */
    public User getUser(){
        logger.debug("getUserInfo : 取用户信息");
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if(authentication == null){
            return new User("","",null);
        }
        Object principal = context.getAuthentication().getPrincipal();

        if(principal instanceof SecurityUser) {
            SecurityUser securityUser = (SecurityUser)principal;
            return securityUser.getUser();
        }
        return new User("","",null);
    }

    /**
     * 取得处理状态
     * <p>从Context内取出处理状态<br>
     * @param code:页面提示信息对应code    message:页面提示信息
     * @return 处理状态
     */
    public  void setStatus(String code, String message){
        logger.debug("setStatus : 存信息状态");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        StatusModel status = new StatusModel();
        status.setCode(code);
        status.setMessage(message);
        request.setAttribute("status",status);
    }

    /**
     * 取得用户信息
     * <p>从Context内取出用户<br>
     * @return 用户信息
     */
    public  String getStatus(){
        logger.debug("getStatus : 取信息状态");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        StatusModel status = (StatusModel)request.getAttribute("status");

        String code = new String();
        if (status != null) {
            code = status.getCode();
        }
        return code;

    }

}
