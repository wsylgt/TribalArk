package com.cn.utils;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * spring securityMD5加密工具类
 * <p>加密Bean工具类<br>
 *
 * @author 王国栋
 * @version 1.0 2016/5/7
 */
public class Md5EncryptUtils {

    /**
     * 日志对象
     */
    private static Log logger = LogFactory.getLog(Md5EncryptUtils.class);

    /**
     * 给用户密码加密
     *
     * @param password JSP页面得到的密码
     * @param encoder 盐
     * @return 加密后的密码
     */
    public static String getMd5Encrypt(String password,String encoder) {

        logger.debug("getMd5Encrypt : 给用户密码加密");

        Md5PasswordEncoder md5 = new Md5PasswordEncoder();

        String md5Password = md5.encodePassword(password, encoder);

        return md5Password;
    }

    /**
     * 判断用户的密码是否正确
     *
     * @param password   JSP页面得到的密码
     * @param dbPassword 数据库中得到的密码
     * @param encoder 盐
     * @return true:密码正确    false:密码错误
     */
    public static boolean isPasswordValid(String password, String dbPassword, String encoder) {

        logger.debug("isPasswordValid : 判断用户的密码是否正确");

        Md5PasswordEncoder md5 = new Md5PasswordEncoder();

        boolean valid = md5.isPasswordValid(dbPassword, password, encoder);

        return valid;

    }

    /**
     * 生成唯一的ID并MD5加密
     *
     * @return
     */
    public static String getUUID() {
        logger.debug("getUUID : 生成唯一的ID并MD5加密");

        //JAVA UUID 生成
        UUID uuid = UUID.randomUUID();

        return Md5EncryptUtils.getMd5Encrypt(uuid.toString(),"");
    }
}
