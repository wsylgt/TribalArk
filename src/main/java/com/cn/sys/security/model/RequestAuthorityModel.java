/**
 * 请求权限Model
 * <p>请求权限Model</p>
 * Copyright 2016-2016 .
 */
package com.cn.sys.security.model;

import java.io.Serializable;

/**
 * 请求权限
 * <p>请求权限</p>
 *
 * @author 王成龙
 * @version 1.0 2016/5/19
 */
public class RequestAuthorityModel implements Serializable {

    /**
     * 序列化串号ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 资源标识
     */
    private String resourceUrl;

    /**
     * 权限
     */
    private String authority;

    /**
     * 权限的取得
     * @return 权限
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * 权限的设定
     * @param authority 权限
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * 资源标识的取得
     * @return 资源标识
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * 资源标识的设定
     * @param resourceUrl 资源标识
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

}
