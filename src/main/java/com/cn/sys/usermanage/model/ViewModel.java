package com.cn.sys.usermanage.model;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by Kris2 on 2016/8/29.
 */
public class ViewModel implements Serializable {

    /**
     * 序列化串号ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 性别Map
     */
    private LinkedHashMap<String, String> sexMap;

    /**
     * 用户状态Map
     */
    private LinkedHashMap<String, String> userStatusMap;

    /**
     * 角色ID集合
     */
    private LinkedHashMap<String, String> roleMap;

    /**
     * @return sexMap 返回
     */
    public LinkedHashMap<String, String> getSexMap() {
        return sexMap;
    }

    /**
     * @param sexMap 设定
     */
    public void setSexMap(LinkedHashMap<String, String> sexMap) {
        this.sexMap = sexMap;
    }

    /**
     * @return userStatusMap 返回
     */
    public LinkedHashMap<String, String> getUserStatusMap() {
        return userStatusMap;
    }

    /**
     * @param userStatusMap 设定
     */
    public void setUserStatusMap(LinkedHashMap<String, String> userStatusMap) {
        this.userStatusMap = userStatusMap;
    }

    public LinkedHashMap<String, String> getRoleMap() {
        return roleMap;
    }

    public void setRoleMap(LinkedHashMap<String, String> roleMap) {
        this.roleMap = roleMap;
    }
}
