package com.cn.sys.usermanage.model;

import java.io.Serializable;

public class RegisterTestModel implements Serializable {
    /** 序列化版本号 */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String phone;
    private Long loginId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }
}
