package com.cn.model;

/**
 * 状态model
 * <p>状态model<br>
 * @author 苏振江
 * @version 1.0 2016/4/22
 */
public class StatusModel {

    /** 状态code */
    private String code;

    /** 状态信息 */
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
