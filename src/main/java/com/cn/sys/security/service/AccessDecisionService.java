package com.cn.sys.security.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

/**
 * 该过滤器的主要作用就是通过spring著名的IoC生成securityMetadataSource。
 * securityMetadataSource相当于本包中自定义的MyInvocationSecurityMetadataSourceService。
 * 该MyInvocationSecurityMetadataSourceService的作用提从数据库提取权限和资源，装配到HashMap中，
 * 供Spring Security使用，用于权限校验。 Created by kris on 2016/4/25.
 */
@Service
public class AccessDecisionService implements AccessDecisionManager {

    /**
     * 日志处理的导入
     */
    private static final Log logger = LogFactory.getLog(AccessDecisionService.class);

    /**
     * Resolves an access control decision for the passed parameters.
     * 解析通过参数的访问控制决策
     * 匹配用户拥有权限和请求权限
     *
     * @param authentication
     *            the caller invoking the method (not null)
     * @param object
     *            the secured object being called
     * @param configAttributes
     *            the configuration attributes associated with the secured
     *            object being invoked
     * @throws AccessDeniedException
     *             if access is denied as the authentication does not hold a
     *             required authority or ACL privilege
     * @throws InsufficientAuthenticationException
     *             if access is denied as the authentication does not provide a
     *             sufficient level of trust
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        logger.info("匹配用户拥有权限和请求权限-----开始-----");
        if (null == configAttributes) {
            return;
        }
        Iterator<ConfigAttribute> cons = configAttributes.iterator();
        while (cons.hasNext()) {
            ConfigAttribute ca = cons.next();
            String needRole = ((SecurityConfig) ca).getAttribute();
            // gra 为用户所被赋予的权限，needRole为访问相应的资源应具有的权限
            for (GrantedAuthority gra : authentication.getAuthorities()) {
                if (needRole.trim().equals(gra.getAuthority().trim())) {
                    return;
                }
            }
        }

        throw new AccessDeniedException("对不起，你没有访问此页面的权限！");
    }

    /**
     * 决定AccessDecisionManager是否可以执行传递ConfigAttribute
     *
     * @return true
     */
    @Override
    public boolean supports(ConfigAttribute attribute) {
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * 被安全拦截器实现调用
     *
     * @return true
     */
    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return true;
    }
}
