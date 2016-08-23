package com.cn.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 字符串工具类
 * <p>工具类<br>
 * @author 王国栋
 * @version 1.0 2016/4/25
 */
public class StringUtil {

    /** 日志对象 */
    private static Log logger = LogFactory.getLog(ConvertUtils.class);

    /**
     * String[] 是否包含 value
     * @param arr  字符串数组
     * @param value 字符串
     * @return true：包含 value false：不包含 value
     */
    public static boolean contains(String[] arr, String value) {
        logger.debug("contains : String[] 是否包含 value");
        if (ValidateUtil.isValid(arr)) {
            for (String s : arr) {
                if (value.equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * String[] 移除重复的value元素
     * @param qx 字符串数组
     * @param value 字符串
     * @return  移除重复的value元素后的字符串数组
     */
    public static String[] remove(String[] qx, String value) {
        logger.debug("remove : String[] 移除重复的value元素");
        List<String> list = new ArrayList<String>();
        for (String s : qx) {
            if (!value.equals(s))
                list.add(s);
        }
        return list.toArray(new String[list.size()]);

    }

    /**
     * String[] 移除重复的元素
     * @param qx 字符串数组
     * @return  移除重复的元素后的字符串数组
     */
    public static String[] removeSeems(String[] qx) {
        logger.debug("removeSeems : String[] 移除重复的元素");
        Set<String> set = new HashSet<String>();
        for (String s : qx) {
            set.add(s);
        }
        return set.toArray(new String[set.size()]);
    }

    /**
     * 将数组合并为一个字符串，数据以分割字符连接
     * @param aStr 数组
     * @param SplitFlag  分割字符
     * @return 合并数组后的字符串
     */
    public static String joinStr(String[] aStr, String SplitFlag) {
        logger.debug("joinStr : 将数组合并为一个字符串，数据以分割字符连接");
        StringBuffer sBuffer = new StringBuffer();
        if (aStr != null) {
            for (int i = 0; i < aStr.length; i++) {
                sBuffer.append(aStr[i]).append(SplitFlag);
            }
            sBuffer.delete(sBuffer.length() - 1, sBuffer.length()); // 去掉最后的分隔符
                                                                    // SplitFlag
        } else {
            sBuffer = sBuffer.append("");
        }
        return sBuffer.toString();
    }
    /**
     * 传入的字符串数字根据分割点分割返回Integer类型
     * @param qty
     * @param split
     * @return
     */
    public static Integer returnInteger(String qty,String split){
        String cQty = qty.substring(0,qty.indexOf(split));
        return Integer.parseInt(cQty);
    }
    /**
     * 左边填充回固定长度串
     * @param str  字符串
     * @param len  固定长度
     * @param reg  填充物
     * @return 固定长度串
     */
    public static String leftPadding(String str, int len, String reg) {
        logger.debug("leftPadding : "+ str + "左边填充:" + reg);
        StringBuffer sBuf = new StringBuffer();

        if (str.length() > len) {
            return str;
        } else {
            for (int i = 0; i < (len - str.length()); i++) {
                sBuf.append(reg);
            }
            sBuf.append(str);
            return sBuf.toString();
        }

    }

    /**
     * 返回固定长度串,空白地方用reg填充
     * @param number  int类型数据
     * @param len  固定长度
     * @param reg  填充物
     * @return 固定长度串
     */
    public static String leftPadding(int number, int len, String reg) {
        logger.debug("fixSpaceStr : 固定长度串,空白地方用reg填充");
        return leftPadding(String.valueOf(number), len, reg);
    }

    /**
     * 右边填充回固定长度串
     * @param str  字符串
     * @param len  固定长度
     * @param reg  填充物
     * @return 固定长度串
     */
    public static String rightPadding(String str, int len, String reg) {
        logger.debug("fixSpaceStr : 固定长度串,空白地方用reg填充");
        StringBuffer sBuf = new StringBuffer();
        try {
            if (str.length() > len) {
                return str;
            } else {
                sBuf.append(str);
                for (int i = 0; i < (len - str.length()); i++) {
                    sBuf.append(reg);
                }
                return sBuf.toString();
            }
        } catch (Exception e) {
            return str;
        }
    }

    /**
     * 返回固定长度串,空白地方用reg填充
     * @param number  int类型数据
     * @param len  固定长度
     * @param reg  填充物
     * @return 固定长度串
     */
    public static String rightPadding(int number, int len, String reg) {
        logger.debug("fixSpaceStr : 固定长度串,空白地方用reg填充");
        return rightPadding(String.valueOf(number), len, reg);
    }
    
    /**
     * 过滤表情字符或者 其他非文字类型的字符 
     * @param source
     * @return
     */
	public static String filterEmoji(String source) {

		StringBuilder buf = new StringBuilder();
		int len = source.length();
		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);
			if (!isEmojiCharacter(codePoint)) {
				buf.append(codePoint);
			} 
		}
		return buf.toString();
	}

    /**
     * 是否有表情字符
     * @param codePoint 
     * @return
     */
    private static boolean isEmojiCharacter(char codePoint) { 
        return (codePoint == 0x0) || 
               (codePoint == 0x9) || 
               (codePoint == 0xA) || 
               (codePoint == 0xD) || 
               ((codePoint >= 0x20) && (codePoint <=  0xD7FF)) || 
               ((codePoint >= 0xE000) && (codePoint <=  0xFFFD)) || 
               ((codePoint >= 0x10000) && (codePoint <=  0x10FFFF)); 
    } 
}
