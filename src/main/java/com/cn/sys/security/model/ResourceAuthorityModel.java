/**
 * 资源权限Model
 * <p>资源权限Model</p>
 * Copyright 2016-2016 .
 */
package com.cn.sys.security.model;

import java.io.Serializable;

/**
 * 资源权限
 * <p>资源权限</p>
 *
 * @author 王成龙
 * @version 1.0 2016/5/19
 */
public class ResourceAuthorityModel implements Serializable {

    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 资源Id */
    private long resourceId;

    /** 资源标识 */
    private String resourceMark;

    /** 资源名称 */
    private String resourceName;

    /** 请求URL */
    private String resourceUrl;

    /** 权限 */
    private String authority;

    /**
     * 资源ID的取得
     * @return 资源ID
     */
    public long getResourceId() {
        return resourceId;
    }

    /**
     * 资源ID的设定
     * @param resourceId 资源ID
     */
    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 资源标识的取得
     * @return 资源标识
     */
    public String getResourceMark() {
        return resourceMark;
    }

    /**
     * 资源标识的设定
     * @param resourceMark 资源标识
     */
    public void setResourceMark(String resourceMark) {
        this.resourceMark = resourceMark;
    }

    /**
     * 资源名称的取得
     * @return 资源名称
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 资源名称的设定
     * @param resourceName 资源名称
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * 请求URL的取得
     * @return 请求URL
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * 请求URL的设定
     * @param resourceUrl 请求URL
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

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

}
