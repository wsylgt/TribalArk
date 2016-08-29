package com.cn.api.usermanage.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by kris on 2016/8/23.
 */
public class JsonModel implements Serializable {


    /** 序列化串号ID */
    private static final long serialVersionUID = 1L;

    /** 身份密匙 */
    private String uuid;

    /** 处理状态 */
    private String status;

    /** 验证错误信息 */
    private HashMap<String, String> errors;

    /** 内容 */
    private Object data;

    /**
     * 构造函数
     * @return 无
     */
    public JsonModel() {
        this.errors = new HashMap<>();
    }

    /**
     * 身份密匙取得
     * @return 身份密匙
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 身份密匙设置
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 处理状态取得
     * @return 处理状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 处理状态设置
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 验证错误信息取得
     * @return 验证错误信息
     */
    public HashMap<String, String> getErrors() {
        return errors;
    }

    /**
     * 验证错误信息设置
     * @param errors
     */
    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    /**
     * 验证错误信息设置
     * @param errors
     */
    public void putAllErrors(HashMap<String, String> errors) {
        this.errors.putAll(errors);
    }

    /**
     * 内容取得
     * @return
     */
    public Object getData() {
        return data;
    }

    /**
     * 内容设置
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 验证字段错误信息的设定
     *
     * @param errorFieldName
     * @param errorFieldMessage
     */
    public void putErrorMessage(String errorFieldName, String errorFieldMessage) {
        this.errors.put(errorFieldName, errorFieldMessage);
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

        // 返回状态
        sbBeanContent.append("status=");
        sbBeanContent.append(status);
        sbBeanContent.append(",");

        // 验证错误信息map
        sbBeanContent.append("errors=");
        sbBeanContent.append(errors);
        sbBeanContent.append(",");

        // 正常内容
        sbBeanContent.append("data=");
        sbBeanContent.append(data);
        sbBeanContent.append("]");
        return sbBeanContent.toString();
    }
}
