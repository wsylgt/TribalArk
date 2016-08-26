/**
 * 后台用户管理Dao接口实现类文件
 * <p>后台用户管理Dao接口实现类,遵循jpa的规范<p>
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
import com.cn.dao.entity.UmUserEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


public class UmUserRepositoryImpl {

    /** 日志处理导入 */
    private static final Log logger = LogFactory.getLog(UmUserRepositoryImpl.class);

    /** JPA实体管理对象*/
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 根据条件搜索后台客户信息并分页
     * @param employeeNo: 员工号
     * @param userName: 用户名
     * @param userIdList: 用户ID集合
     * @param isDetele: 是否删除,0: 否   1: 是
     * @param pageable: Pageable对象
     * @return Page
     */
    public Page<UmUserEntity> searchByEmployeeNoAndUserNameAndUserId(String employeeNo, String userName,
                                                                     List<Long> userIdList, String isDetele, Pageable pageable) {
        
        logger.debug("searchByEmployeeNoAndUserNameAndUserId: 搜索用户信息");
        // 获取总条数
        long totalCount = this.getTotalCount(employeeNo, userName, userIdList, isDetele);
        
        // 件数是0的时候
        if (totalCount == 0) {
            return new PageImpl<UmUserEntity>(new ArrayList<UmUserEntity>(), pageable, totalCount);
        }
        
        //参数map
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        
        String hql = this.editHql(false, employeeNo, userName, userIdList, isDetele, paramMap);
        
        //检索对象
        Query query = entityManager.createQuery(hql);
        
        //设置参数
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        
        //设置翻页信息
        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        
        //取得用户信息
        @SuppressWarnings("unchecked")
        List<UmUserEntity> umUserRoleEntityList = (List<UmUserEntity>)query.getResultList();
        
        Page<UmUserEntity> page = new PageImpl<UmUserEntity>(umUserRoleEntityList, pageable, totalCount);
        
        return page;
    }
    
    /**
     * 获取总条数
     * @param employeeNo: 员工号
     * @param userName: 用户名
     * @param userIdList: 用户ID集合
     * @param isDetele: 是否删除,0: 否   1: 是
     * @return long
     */
    public long getTotalCount(String employeeNo, String userName, List<Long> userIdList, String isDetele) {
        logger.debug("getTotalCount: 获取总条数");
        
        //参数map
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        
        String hql = this.editHql(true, employeeNo, userName, userIdList, isDetele, paramMap);
        
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
     * @param employeeNo: 员工号
     * @param userName: 用户名
     * @param userIdList: 用户ID集合
     * @param isDetele: 是否删除,0: 否   1: 是
     * @param paramMap： 参数Map集合
     * @return String
     */
    public String editHql(boolean countFlg, String employeeNo, String userName,
            List<Long> userIdList, String isDetele, HashMap<String, Object> paramMap) {
        
        StringBuffer stringHql = new StringBuffer();
        
        // 如果是取得总条数
        if (countFlg) {
            stringHql.append("select count(user.userId) ");
        } else {
            stringHql.append("select user ");
        }
        stringHql.append("from UmUserEntity user ");
        stringHql.append("where 1 = 1 ");
        
        // 如果employeeNo不是null,追加 where条件
        if (!Constant.STRING_EMPTY.equals(employeeNo) && employeeNo != null) {
            
            stringHql.append("and user.employeeNo like :employeeNo ");
            paramMap.put("employeeNo", employeeNo.trim()+"%");
        }

        // 如果userName不是空,追加where条件
        if (!Constant.STRING_EMPTY.equals(userName) && userName != null) {
            
            stringHql.append("and user.userName like :userName ");
            paramMap.put("userName", userName.trim()+"%");
        }
        
        // 如果roleId不是空,追加where条件
        if (!Constant.STRING_EMPTY.equals(userIdList) && userIdList.size() > 0) {
            
            stringHql.append("and user.userId in (:userIdList) ");
            paramMap.put("userIdList", userIdList);
        }
        
        // 如果isDetele不是null,追加where条件
        if (!Constant.STRING_EMPTY.equals(isDetele) && isDetele != null) {
            
            stringHql.append("and user.isDelete = :isDetele ");
            paramMap.put("isDetele", isDetele);
        } else {
            
            stringHql.append("and user.isDelete = " + Constant.DELETE_FLAG_NORMAL_CODE + " ");
        }
        
        // 如果不是取得总条数 ,倒序排序
        if (!countFlg) {
            
            stringHql.append("order by user.userId desc");
        }
        
        logger.debug("editHql: 编辑hql"+ stringHql);
        return stringHql.toString();
    }
}
