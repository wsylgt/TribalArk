package com.cn.model;

import java.io.Serializable;

/**
 * 发件人model
 * <p>发件人model<br>
 * @author 王国栋
 * @version 1.0 2016/5/30
 */
public class SenderMailModel implements Serializable {

    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 服务器 */
    private String host;

    /** 端口号 */
    private int port;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /**
     * 服务器的取得
     * @return 服务器
     */
    public String getHost() {
        return this.host;
    }

    /**
     * 服务器的设定
     * @param host 服务器
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 端口号的取得
     * @return 端口号
     */
    public int getPort() {
        return this.port;
    }

    /**
     * 端口号的设定
     * @param port 端口号
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * 用户名的取得
     * @return 用户名
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * 用户名的设定
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码的取得
     * @return 密码
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 密码的设定
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 无参构造方法
     */
    public SenderMailModel() {

    }

    /**
     * 有参构造方法
     */
    public SenderMailModel(String host, int port, String username, String password) {
        super();
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }
}
