/** 
 * 入翻页信息计算共通类
 * <p>对翻页信息进行计算的共通类<br>
 * Copyright 2016-2016
 */
package com.cn.utils;

/**
 * 翻页信息计算共通类
 * <p>对翻页信息进行计算的共通类<br>
 * @author 孙亮
 * @version 1.0 2016/5/4
 */
public class PageUtils {

    /**
     * 计算总页码
     * @param recordCount 总记录件数
     * @param pageSize 一页表示多少条记录
     * @return 总页码
     */
    public static int getSumPage(long recordCount, int pageSize) {
        
        // 总页码
        int sumPage = (int)(recordCount / pageSize);
        
        // 余数
        int modValue = (int)(recordCount % pageSize);
        
        // 余数不是0的时候
        if (modValue != 0) {
            sumPage++;
        }
        
        return sumPage;
    }
    
    /**
     * 计算开始结束页码
     * @param sumPage 总页码
     * @param currentPage 当前页码
     * @param showPageIndexCount 表示页码索引件数
     * @return 开始结束页码数组 0：开始页码; 1:结束页码
     */
    public static int[] getBeginEndPage(
        int sumPage, int currentPage, int showPageIndexCount) {
        
        // 当前页码大于总页码的时候
        if (currentPage > sumPage) {
            currentPage = sumPage;
        }
        
        // 中间页码
        int midPage = showPageIndexCount / 2;
        
        // 余数
        int midMod = showPageIndexCount % 2;
        
        // 余数不是0的时候
        if (midMod != 0) {
            midPage++;
        }
        
        // 前置页码件数
        int beforePageCount = midPage - 1;
        
        // 后置页码件数
        int afterPageCount = showPageIndexCount - midPage;
        
        // 开始页码
        int beginPage = 1;
        
        // 结束页码
        int endPage = 1;
        
        // 当前页码小于等于中间页码的时候
        if (currentPage <= midPage) {
            
            // 总页码 < 表示页码索引件数的时候
            if (sumPage <= showPageIndexCount) {
                
                // 结束页码
                endPage = sumPage;
            } else {
                
                // 结束页码
                endPage = showPageIndexCount;
            }
        } else {
            
            // 后置实际页数
            int afterRealPage = sumPage - currentPage;
            
            // 后置实际页数 >= 后置页码件数
            if (afterRealPage >= afterPageCount) {
                
                // 开始页码
                beginPage = currentPage - beforePageCount;
                
                // 结束页码
                endPage = currentPage + afterPageCount;
            } else {
                
                // 结束页码
                endPage = sumPage;
                
                // 开始页码
                beginPage = currentPage - beforePageCount - (afterPageCount - afterRealPage);
                
                // 开始页码小于1的时候
                if (beginPage < 1) {
                    beginPage = 1;
                }
            }
        }
        
        // 返回值
        int[] returnArray = new int[2];
        returnArray[0] = beginPage;
        returnArray[1] = endPage;
        return returnArray;
    }
}
