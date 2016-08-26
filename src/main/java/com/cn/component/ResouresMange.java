package com.emall.base.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 资源服务共通方法类
 * @author 苏振江
 * @version 1.0 2016/6/4
 */
@Component
public class ResouresMange {

    /** 资源服务器 **/
    @Value("${resources.server.url}")
    private String serverUrl;


    /** 图片资源URL **/
    @Value("${resources.server.imagesUrl}")
    private String imagesUrl;

    /** 媒体资源URL **/
    @Value("${resources.server.mediaUrl}")
    private String mediaUrl;

    /** HTML资源URL **/
    @Value("${resources.server.htmlUrl}")
    private String htmlUrl;
    
    /** temp资源URL **/
    @Value("${resources.server.tempUrl}")
    private String tempUrl;
    
    /** redis客户端失效时间 **/
    @Value("${redis.maxInactiveIntervalInSeconds}")
    private int maxInactiveIntervalInSeconds;
    
    
    public String getServerUrl() {
        return serverUrl;
    }

    public String getImagesUrl() {
        return serverUrl + imagesUrl;
    }

    public String getMediaUrl() {
        return serverUrl + mediaUrl;
    }

    public String getHtmlUrl() {
        return serverUrl + htmlUrl;
    }
    
    public String getTempUrl() {
        return serverUrl + tempUrl;
    }
    public int getMaxInactiveIntervalInSeconds() {
        return maxInactiveIntervalInSeconds;
    }
}
