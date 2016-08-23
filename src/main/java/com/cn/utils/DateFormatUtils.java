package com.cn.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 日期格式化工具类
 * <p>工具类<br>
 * @author 王国栋
 * @version 1.0 2016/4/25
 */
public class DateFormatUtils {

    /** 日志  */
    private static final Log logger = LogFactory.getLog(DateFormatUtils.class);

    /** 默认日期格式 */
    private static String yyyyMMdd = "yyyy-MM-dd";
    /** 日期格式*/
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_TIMESTAMP_FORMAT = "HH:mm:ss";
    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String FORMAT_YYMMDD = "yyMMdd";
    public static final String FORMAT_YYYYMM = "yyyyMM";
    public static final String FORMAT_YYYY = "yyyy";
    public static final String FORMAT_YYYYCNMMCNDDCN = "yyyy年MM月dd日";
    public static final String FORMAT_YYYYCNMMCN = "yyyy年MM月";
    public static final String FORMAT_YYYYCN = "yyyy年";
    public static final String FORMAT_HHMMSS = "HHmmss";
    /** 星期英文名*/
    public static final String WEEK_SUNDAY = "SUNDAY";
    public static final String WEEK_MONDAY = "MONDAY";
    public static final String WEEK_TUESDAY = "TUESDAY";
    public static final String WEEK_WEDNESDAY = "WEDNESDAY";
    public static final String WEEK_THURSDAY = "THURSDAY";
    public static final String WEEK_FRIDAY = "FRIDAY";
    public static final String WEEK_SATURDAY = "SATURDAY";

    /**
     * 格式化指定的日期
     * @param date 日期
     * @param format 日期格式
     * @return 格式化日期
     */
    public static String formatDate(Date date, String format) {
        logger.debug("formatDate : 格式化指定的日期");
        // 日期是null的时候
        if (date == null) {
            return "";
        }
        // 日期格式化对象
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        // 格式化指定的日期
        return dateFormat.format(date);
    }

    public static String formatDateToString(String dateStr, String format) {
        Date date = parseDate(dateStr, FORMAT_YYYYMMDD);
        return formatDate(date, format);
    }

    /**
     * 格式化指定格式的日期
     * @param dateStr 日期字符串
     * @param pattern 日期格式
     * @return
     */
    public static Date parseDate(String dateStr, String pattern) {
        logger.debug("parseDate : 格式化指定格式的日期");
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return dateFormat.parse(dateStr);
        } catch (Exception e) {
            logger.error("parseDate : 日期格式化失败", e);
            return null;
        }
    }

    /**
     * 功能描述：时间相减得到天数
     * @param beginDateStr
     * @param endDateStr
     * @return 天数
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        logger.debug("getDaySub : 时间相减得到天数");
        long day = 0;
        SimpleDateFormat format = new SimpleDateFormat(yyyyMMdd);
        Date beginDate;
        Date endDate;
        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
            day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            logger.error("getDaySub : 时间相减得到天数错误", e);
        }
        return day;
    }

    /**
     * 日期后几天的日期
     * @param strdate 字符串日期
     * @param days 几天
     * @return 日期后几天的日期
     */
    public static String getDayAdd(String strdate, int days) {
        logger.debug("getDayAdd : 日期后几天的日期");
        SimpleDateFormat format = new SimpleDateFormat(yyyyMMdd);
        Calendar date = Calendar.getInstance();
        try {
            date.setTime(format.parse(strdate));
        } catch (ParseException e) {
            logger.error("getDayAdd : 日期后几天的日期格式化错误", e);
        }
        date.set(Calendar.DATE, date.get(Calendar.DATE) + days);
        String result = format.format(date.getTime());
        return result;
    }

    /**
     * 日期前几天的日期
     * @param strdate 字符串日期
     * @param days 几天
     * @param format 日期格式
     * @return 日期前几天的日期
     */
    public static String getDayBefore(String strdate, int days, String format) {
        logger.debug("getDayBefore : 日期前几天的日期");
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar date = Calendar.getInstance();
        try {
            date.setTime(sdf.parse(strdate));
        } catch (ParseException e) {
            logger.error("getDayBefore : 日期前几天的日期格式化错误", e);
        }
        date.set(Calendar.DATE, date.get(Calendar.DATE) - days);
        String result = sdf.format(date.getTime());
        return result;
    }

    /**
     * 日期前几月的日期
     * @param strdate 字符串日期
     * @param months 几月
     * @param format 日期格式
     * @return 日期前几月的日期
     */
    public static String getMonthBefore(String strdate, int months, String format) {
        logger.debug("getMonthBefore : 日期前几月的日期");
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar date = Calendar.getInstance();
        try {
            date.setTime(sdf.parse(strdate));
        } catch (ParseException e) {
            logger.error("getMonthBefore : 日期前几月的日期格式化错误", e);
        }
        date.set(Calendar.MONTH, date.get(Calendar.MONTH) - months);
        String result = sdf.format(date.getTime());
        return result;
    }

    /**
     * 日期前几年的日期
     * @param strdate 字符串日期
     * @param years 几年
     * @param format 日期格式
     * @return 日期前几年的日期
     */
    public static String getYearBefore(String strdate, int years, String format) {
        logger.debug("getYearBefore : 前几年的日期");
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar date = Calendar.getInstance();
        try {
            date.setTime(sdf.parse(strdate));
        } catch (ParseException e) {
            logger.error("getYearBefore : 前几年的日期格式化错误", e);
        }
        date.set(Calendar.YEAR, date.get(Calendar.YEAR) - years);
        String result = sdf.format(date.getTime());
        return result;
    }

    /**
     * 字符串日期的汉语星期几
     * @param pTime格式:yyyy-MM-dd
     * @return 该日期周几
     */
    public static String dayForWeek(String pTime) {
        logger.debug("dayForWeek : 字符串日期的汉语星期几");
        SimpleDateFormat format = new SimpleDateFormat(yyyyMMdd);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            logger.error("dayForWeek : 字符串日期的汉语星期几格式化错误", e);
        }
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        String strweek = "";
        switch (dayForWeek) {
        case 1:
            strweek = "星期一";
            break;
        case 2:
            strweek = "星期二";
            break;
        case 3:
            strweek = "星期三";
            break;
        case 4:
            strweek = "星期四";
            break;
        case 5:
            strweek = "星期五";
            break;
        case 6:
            strweek = "星期六";
            break;
        case 7:
            strweek = "星期天";
            break;
        }
        return strweek;
    }

    /**
     * 得到当前日期 yyyy-MM-dd格式
     * @return yyyy-MM-dd格式字符串
     */
    public static String yMdDate() {
        logger.debug("yMdDate : 当前日期 yyyy-MM-dd格式");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dateStr = simpleDateFormat.format(date);
        System.out.println(dateStr);
        return dateStr;
    }

    /**
     * @method 得到当前星期几
     */
    public static int getWeek() {
        logger.debug("getWeek : 得到当前星期几");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        // System.out.println(week);//老外的星期
        // System.out.println(convertWeekToLocal(week));//咱的星期
        return convertWeekToLocal(week);
    }

    /**
     * 将老外的星期转为中国的星期 外国人真奇怪，人家的星期7是我们的星期6 人家的星期1是我们的星期7 人家的星期2是我们的星期1
     * 
     * @param input
     *            老外的星期几
     * @return 中国的星期几
     */
    private static int convertWeekToLocal(int input) {
        logger.debug("convertWeekToLocal : 中国的星期几");
        switch (input) {
        case 1:
            return 7;
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
            return input - 1;
        default:
            return 0;
        }
    }

    /**
     * 得到当前星期几(汉字)
     * 
     * @param str
     * @return
     */
    public static String getWeekByDateInChinese(String str) {
        logger.debug("getWeekByDateInChinese : 当前星期几(汉字)");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            // calendar.add(Calendar.DAY_OF_YEAR, count);
            // date = calendar.getTime();
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            return getWeekInChinese(week);
        } catch (Exception e) {
            logger.error("getWeekByDateInChinese : 当前星期几(汉字)格式化错误", e);
        }
        return null;
    }

    /**
     * 得到汉字星期
     * 
     * @param week
     *            数字星期几
     * @return 得到汉字星期
     */
    private static String getWeekInChinese(int week) {
        logger.debug("getWeekInChinese : 汉字星期");
        String weekStr[] = new String[] { "七", "一", "二", "三", "四", "五", "六" };
        return weekStr[week - 1];
    }

    /***
     * 当前系统时间的yyyy-MM-dd HH:mm:ss SSS格式字符串
     * @method 获得当前系统时间的yyyy-MM-dd HH:mm:ss SSS格式字符串
     * @return 返回当前系统时间的yyyy-MM-dd HH:mm:ss SSS格式字符串
     */
    public static String yMdHmsS() {
        logger.debug("yMdHmsS : 当前系统时间的yyyy-MM-dd HH:mm:ss SSS格式字符串");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String dateString = formatter.format(date);

        return dateString;
    }

    /***
     * @method 获得当前系统时间的用户自定义格式字符串
     * @param format用户自定义时间格式
     * @return 返回当前系统时间的用户自定义格式字符串
     */
    public static String getDate(String format) {
        logger.debug("getDate : 当前系统时间的用户自定义格式字符串");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateString = formatter.format(date);

        return dateString;
    }

    /***
     * @method 获得给定时间的用户自定义格式字符串
     * @param date
     *            传入的给定时间
     * @param format
     *            用户自定义时间格式
     * @return 返回给定时间的用户自定义格式字符串
     */
    public static String getDateCustom(Date date, String format) {
        logger.debug("getDateCustom : 给定时间的用户自定义格式字符串");
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateString = formatter.format(date);

        return dateString;
    }

    /***
     * @method 获得给定时间的用户自定义格式字符串
     * @param String
     *            传入的给定时间
     * @param format
     *            用户自定义时间格式
     * @return 返回给定时间的用户自定义格式字符串
     */
    public static String getDateCustomStr(String date, String format) {
        logger.debug("getDateCustomStr : 给定时间的用户自定义格式字符串");
        String returnDate = date + format;
        return returnDate;
    }

    /***
     * @method 把字符串时间 转成 Date格式时间
     * @param dateStr
     *            传入的时间字符串
     * @param format
     *            用户自定义时间格式
     * @return 返回时间字符串转化成的Date格式时间 。（自定义时间格式出错 则返回当前时间）
     */
    public static Date toDateCustom(String dateStr, String format) {
        logger.debug("toDateCustom : 时间字符串转化成的Date格式时间");
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            logger.error("toDateCustom : 时间字符串转化成的Date格式时间格式化错误", e);
        }
        return date;
    }

    /**
     * 日期后几天的日期
     * @param strdate 字符串日期
     * @param days 几天
     * @return 日期后几天的日期(Date类型)
     */
    public static Date getDateDayAdd(String strdate, int days) {
        logger.debug("getDateDayAdd : 日期后几天的日期");
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);
        Calendar date = Calendar.getInstance();
        try {
            date.setTime(format.parse(strdate));
        } catch (ParseException e) {
            logger.error("getDateDayAdd : 添加日期天数错误", e);
        }
        date.set(Calendar.DATE, date.get(Calendar.DATE) + days);
        Date result = date.getTime();
        return result;
    }

    /**
     * 日期后几天的日期
     * @param strdate 字符串日期
     * @param days 几天
     * @return 日期后几天的日期(Date类型)
     */
    public static Date getDateDayAdd(Date inDate, int days) {
        logger.debug("getDateDayAdd : 日期后几天的日期");
        Calendar date = Calendar.getInstance();
        date.setTime(inDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + days);
        Date result = date.getTime();
        return result;
    }

    /**
     * 日期后几小时的日期
     * @param strdate 字符串日期
     * @param hours 小时
     * @return 日期后几小时的日期(Date类型)
     */
    public static Date getDateHourAdd(String strdate, int hours) {
        logger.debug("getDateDayAdd : 日期后几小时的日期");
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);
        Calendar date = Calendar.getInstance();
        try {
            date.setTime(format.parse(strdate));
        } catch (ParseException e) {
            logger.error("getDateDayAdd : 添加日期小时错误", e);
        }
        date.set(Calendar.HOUR, date.get(Calendar.HOUR) + hours);
        Date result = date.getTime();
        return result;
    }

    /**
     * 日期后几小时的日期
     * @param inDate 日期
     * @param hours 小时
     * @return 日期后几小时的日期(Date类型)
     */
    public static Date getDateHourAdd(Date inDate, int hours) {
        logger.debug("getDateDayAdd : 日期后几小时的日期");
        Calendar date = Calendar.getInstance();
        date.setTime(inDate);
        date.set(Calendar.HOUR, date.get(Calendar.HOUR) + hours);
        Date result = date.getTime();
        return result;
    }

    /**
     * 比较字符串日期大小
     * @param dateStr1 日期1
     * @param dateStr2 日期2
     * @param pattern 日期格式
     * @return
     */
    public static boolean compareDate(String dateStr1, String dateStr2, String pattern) {
        if (dateStr1 != null && dateStr2 != null) {
            Date date1 = parseDate(dateStr1, pattern);
            Date date2 = parseDate(dateStr2, pattern);
            return date1.compareTo(date2) > 0 ? true : false;
        } else {
            return true;
        }
    }

    /**
     * 比较日期大小
     * @param inDate1 日期1
     * @param inDate2 日期2
     * @return
     */
    public static boolean compareDate(Date inDate1, Date inDate2) {
        if (inDate1 != null && inDate2 != null) {
            return inDate1.compareTo(inDate2) > 0 ? true : false;
        }
        return false;
    }

    /**
     * 日期后几分钟的日期
     * @param strdate 字符串日期
     * @param minutes 分钟
     * @return 日期后几分钟的日期(Date类型)
     */
    public static Date getDateMinuteAdd(String strdate, int minutes) {
        logger.debug("getDateDayAdd : 日期后几分钟的日期");
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);
        Calendar date = Calendar.getInstance();
        try {
            date.setTime(format.parse(strdate));
        } catch (ParseException e) {
            logger.error("getDateDayAdd : 添加日期分钟错误", e);
        }
        date.set(Calendar.MINUTE, date.get(Calendar.MINUTE) + minutes);
        Date result = date.getTime();
        return result;
    }

    /**
     * 日期后几分钟的日期
     * @param strdate 字符串日期
     * @param minutes 分钟
     * @return 日期后几分钟的日期(Date类型)
     */
    public static Date getDateMinuteAdd(Date inDate, int minutes) {
        logger.debug("getDateDayAdd : 日期后几分钟的日期");
        Calendar date = Calendar.getInstance();
        date.setTime(inDate);
        date.set(Calendar.MINUTE, date.get(Calendar.MINUTE) + minutes);
        Date result = date.getTime();
        return result;
    }

    /**
     * 比较两个日期字符串大小(格式：yyyy-MM-dd HH:mm:ss)
     * @param beforeDate  前字符串日期
     * @param afterDate   后字符串日期
     * @return            返回: 1:前字符串日期大;-1:后字符串日期大;0:相等
     */
    public static int compare_date(String beforeDate, String afterDate) {
        logger.debug("compare_date : 比较两个日期字符串大小");
        DateFormat df = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);
        try {
            Date dt1 = df.parse(beforeDate);
            Date dt2 = df.parse(afterDate);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            logger.error("compare_date : 比较两个日期字符串大小错误", e);
        }
        return 0;
    }
}
