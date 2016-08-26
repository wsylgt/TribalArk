/**
 * 后台用户操作日志Dao接口实现类文件
 * <p>后台用户操作日志Dao接口实现类,遵循jpa的规范<p>
 * Copyright 2016-2016
 */
package com.cn.dao.repositorys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cn.content.Constant;
import com.cn.dao.entity.UmUserOperationLogEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


/**
 * 后台用户操作日志Dao接口实现类
 * <p>根据搜索条件搜索操作日志信息 </p>
 * @author 刘广飞
 * @version 1.0 2016/05/24
 */
public class UmUserOperationLogRepositoryImpl {

    /** 日志处理导入 */
    private static final Log logger = LogFactory.getLog(UmUserOperationLogRepositoryImpl.class);

    /** JPA实体管理对象*/
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * 根据搜索条件搜索日志信息
     * @param beginDateTime: 开始日期
     * @param endDateTime: 结束日期
     * @param userName: 用户名(操作人)
     * @param pageable: Pageable对象
     * @return Page
     */
    public Page<UmUserOperationLogEntity> searchByBeginDateTimeAndEndDateTimeAndUserName(String beginDateTime,
                                                                                         String endDateTime, String userName, Pageable pageable) {
        
        logger.debug("searchByBeginDateTimeAndEndDateTimeAndUserName: 根据搜索条件搜索日志信息");
        
        //获取总条数
        long totalCount = this.getTotalCount(beginDateTime, endDateTime, userName);
        
        //件数是0的时候
        if (totalCount == 0) {
            return new PageImpl<UmUserOperationLogEntity>(new ArrayList<UmUserOperationLogEntity>(), pageable, totalCount);
        }
        
        //参数map
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        
        String hql = this.editHql(false, beginDateTime, endDateTime, userName, paramMap);
        
        //检索对象
        Query query = entityManager.createQuery(hql);
        
        //设置参数
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        
        //设置翻页信息
        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        
        //取得入库明细信息
        @SuppressWarnings("unchecked")
        List<UmUserOperationLogEntity> umUserOperationLogEntityList = (List<UmUserOperationLogEntity>)query.getResultList();
        
        Page<UmUserOperationLogEntity> page = new PageImpl<UmUserOperationLogEntity>(umUserOperationLogEntityList, pageable, totalCount);
        
        return page;
    }
    
    /**
     * 获取总条数
     * @param beginDateTime: 开始日期
     * @param endDateTime: 结束日期
     * @param userName: 用户名(操作人)
     * @return long
     */
    public long getTotalCount(String beginDateTime, String endDateTime, String userName) {
        logger.debug("getTotalCount: 获取总条数");
        
        //参数map
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        
        String hql = this.editHql(true, beginDateTime, endDateTime, userName, paramMap);
        
        //检索对象
        Query query = entityManager.createQuery(hql);
        
        //设置参数
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        
        // 取得记录件数
        long totalCount = Long.parseLong(query.getSingleResult().toString());
        
        return totalCount;
    }
    
    /**
     * 编辑hql
     * @param beginDateTime: 开始日期
     * @param endDateTime: 结束日期
     * @param userName: 用户名(操作人)
     * @param paramMap： 参数Map集合
     * @return String
     */
    public String editHql(boolean countFlg, String beginDateTime, String endDateTime, String userName,
            HashMap<String, Object> paramMap) {
        
        StringBuffer stringHql = new StringBuffer();
        
        // 如果是取得总条数
        if (countFlg) {
            stringHql.append("select count(log.logId) ");
        } else {
            stringHql.append("select log ");
        }
        stringHql.append("from UmUserOperationLogEntity log ");
        stringHql.append("where 1 = 1 ");
        
        // 如果beginDateTime不是null,追加 where条件
        if (!Constant.STRING_EMPTY.equals(beginDateTime) && beginDateTime != null) {
            stringHql.append("and cast(log.operationDate as string) >= :beginDateTime ");
            paramMap.put("beginDateTime", beginDateTime + " 00:00:00");
        }

        // 如果endDateTime不是空,追加where条件
        if (!Constant.STRING_EMPTY.equals(endDateTime) && endDateTime != null) {
            stringHql.append("and cast(log.operationDate as string) <= :endDateTime ");
            paramMap.put("endDateTime", endDateTime + " 23:59:59");
        }

        // 如果userName不是空，追加where条件
        if (!Constant.STRING_EMPTY.equals(userName) && userName != null) {
            stringHql.append("and log.userName like :userName ");
            paramMap.put("userName", userName.trim() + "%");
        }

        // 如果不是取得总条数 ,倒序排序
        if (!countFlg) {
            stringHql.append("order by log.logId desc");
        }
        
        logger.debug("editHql: 编辑hql"+ stringHql);
        return stringHql.toString();
    }
    
}
