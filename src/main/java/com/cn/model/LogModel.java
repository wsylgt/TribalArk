package com.emall.base.model;

import java.io.Serializable;

/**
 * 日志信息
 * <p>日志信息<br>
 * @author 王国栋
 * @version 1.0 2016/5/27
 */
public class LogModel implements Serializable {

    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 方法名 */
    private String methodName;

    /** 方法内容 */
    private String methodOperation;

    /** 自定义信息 */
    private String customMessage;

    /** 方法参数 */
    private String methodParams;

    /**
     * 方法名的取得
     * @return 方法名
     */
    public String getMethodName() {
        return this.methodName;
    }

    /**
     * 方法名的设定
     * @param methodName 方法名
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * 方法内容的取得
     * @return 方法内容
     */
    public String getMethodOperation() {
        return this.methodOperation;
    }

    /**
     * 方法内容的设定
     * @param methodOperation 方法内容
     */
    public void setMethodOperation(String methodOperation) {
        this.methodOperation = methodOperation;
    }

    /**
     * 自定义信息的取得
     * @return 自定义信息
     */
    public String getCustomMessage() {
        return this.customMessage;
    }

    /**
     * 自定义信息的设定
     * @param customMessage 自定义信息
     */
    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    /**
     * 方法参数的取得
     * @return 方法参数
     */
    public String getMethodParams() {
        return this.methodParams;
    }

    /**
     * 方法参数的设定
     * @param methodParams 方法参数
     */
    public void setMethodParams(String methodParams) {
        this.methodParams = methodParams;
    }

    /**
     * 无参构造方法
     */
    public LogModel() {

    }

    /**
     * 有参构造方法
     */
    public LogModel(String methodName, String methodOperation, String customMessage, String methodParams) {
        super();
        this.methodName = methodName;
        this.methodOperation = methodOperation;
        this.customMessage = customMessage;
        this.methodParams = methodParams;
    }
}
