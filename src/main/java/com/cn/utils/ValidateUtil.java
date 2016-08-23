package com.cn.utils;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 集合、对象、数组验证工具类
 * <p>工具类<br>
 * @author 王国栋
 * @version 1.0 2016/4/25
 */
public class ValidateUtil {

    /** 日志对象 */
    private static Log logger = LogFactory.getLog(ConvertUtils.class);

    /**
     * 检查对象是否为空
     * @param  obj Object         
     * @return boolean true:为空 false:不为空
     */
    public static boolean isValid(Object obj) {
        logger.debug("isValid : 检查对象是否为空");
        return (obj == null || obj.toString().trim().length() == 0 ? true : false);
    }

    /**
     * 检验集合Collection
     * @param  col 集合
     * @return true:为空  false:不为空
     */
    @SuppressWarnings("rawtypes")
    public static boolean isValid(Collection col) {
        logger.debug("isValid : 检验集合是否为空");
        if (col == null || col.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 检验Object[]
     * @return true:为空 false:不为空
     */
    public static boolean isValid(Object[] arr) {
        logger.debug("isValid : 检验数组是否为空");
        if (arr == null || arr.length == 0) {
            return true;
        }
        return false;
    }

    /**
     * 是否为奇数
     * @return true:为奇数  false:偶数
     */
    public static boolean isOdd(int i) {
        logger.debug("isOdd : 是否为奇数");
        if (i % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断是否为数字或者字母
     * @return true:为真  false:为假
     */
    public static boolean isNumOrLiter(String str) {
        logger.debug("isNumOrLiter : 判断是否为数字或者字母");
        String req = "[a-zA-Z0-9]*";
        return str.matches(req);
    }
    
    /**
     * 判断是否为数字
     * @return true:为真  false:为假
     */
    public static boolean isNumber(String str) {
        String req = "[0-9]*";
        return str.matches(req);
    }
}
