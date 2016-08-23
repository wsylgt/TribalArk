package com.cn.utils;

import java.text.DecimalFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 数字格式化工具类
 * <p>工具类<br>
 * @author 王国栋
 * @version 1.0 2016/4/25
 */
public class NumberFormatUtil {

    /** 日志对象 */
    private static Log logger = LogFactory.getLog(ConvertUtils.class);

    /**
     * 数字转化为小数 reg格式 : #,##0.00(2位小数)
     * @param str 字符串数字
     * @param reg 正则格式 : #,##0.00(2位小数)
     * @return 带小数位数据格式化
     */
    public static String getDecimal(String str, String reg) {
        logger.debug("getDecimal : 数字转化为小数 reg格式 : #,##0.00(2位小数)");
        double dou = Double.valueOf(str);
        String result = "";// 接受小数的值
        DecimalFormat df1 = new DecimalFormat(reg); // reg 小数格式，后面不足的用0补齐
        result = df1.format(dou);
        return result;
    }

    /**
     * long类型数字格式化 reg格式如 : #,##0
     * @param lo  long类型数字
     * @param reg 正则格式如 : #,##0
     * @return 整数格式化
     */
    public static String getNumFormat(long lo, String reg) {
        logger.debug("getNumFormat : long类型数字格式化 reg格式如 : #,##0");
        String result = "";
        DecimalFormat df1 = new DecimalFormat(reg); // reg 小数格式，后面不足的用0补齐
        result = df1.format(lo);
        return result;
    }

    /**
     * 数字转化为百分比 reg格式 : 0.00%(2位小数百分比)
     * @param str double类型字符串
     * @param reg 正则格式 : 0.00%(2位小数百分比)
     * @return 百分比 字符串
     */
    public static String getPercent(String str, String reg) {
        logger.debug("getPercent : 数字转化为百分比 reg格式 : 0.00%(2位小数百分比)");
        double dou = Double.valueOf(str);
        String result = "";// 接受百分比的值
        double newDou = dou * 1.0;
        double tempresult = newDou / 100;
        DecimalFormat df1 = new DecimalFormat(reg); // ##.00%
                                                    // 百分比格式，后面不足2位的用0补齐
        result = df1.format(tempresult);
        return result;
    }
}
