/** 
 * 编码信息表Dao实体类
 * <p>对编码信息表进行数据操作的实体类<br>
 * Copyright 2016-2016
 */
package com.cn.dao.repositorys.impl;

import com.cn.dao.entity.MCodeMasterEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * 编码信息表Dao实体类
 * <p>对编码信息表进行数据操作的实体类<br>
 * @author 孙亮
 * @version 1.0 2016/5/4
 */
public class MCodeMasterRepositoryImpl {

    /** JPA实体管理对象*/
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * 根据编码组IDlist取得编码信息
     * @param codeGroupIdList 编码组IDlist
     * @param showFlag 表示标识
     * @return 编码信息list
     */
    @SuppressWarnings("unchecked")
    public List<MCodeMasterEntity> searchByCodeGroupIdList(
        List<String> codeGroupIdList, String showFlag) {
    
        // 编码组IDList是空的时候
        if (codeGroupIdList == null || codeGroupIdList.isEmpty()) {
            return new ArrayList<MCodeMasterEntity>();
        }

        // 参数map
        HashMap<String, String> paramMap = new HashMap<String, String>();
        
        // 检索sql文
        StringBuilder sbSql = new StringBuilder();
        sbSql.append("select cm from MCodeMasterEntity cm ");
        sbSql.append("where (");
        
        for (int i = 0; i < codeGroupIdList.size(); i++) {
            
            sbSql.append("cm.codeGroupId = ");
            sbSql.append(":codeGroupId");
            sbSql.append(i);
            sbSql.append(" or ");
            paramMap.put("codeGroupId" + i, codeGroupIdList.get(i));
        }
        sbSql.delete(sbSql.length() -4, sbSql.length());
        sbSql.append(") ");
        
        // 表示标识不是空的时候
        if (showFlag != null && !"".equals(showFlag)) {
            sbSql.append("and cm.showFlag = :showFlag ");
            paramMap.put("showFlag", showFlag);
        }
        
        // 排序条件
        sbSql.append("order by cm.codeGroupId asc, cm.sortOrder asc");
        
        // 检索对象
        Query query = entityManager.createQuery(sbSql.toString());
        
        // 设置参数
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        // 取得编码信息
        List<MCodeMasterEntity> entityList = 
            (List<MCodeMasterEntity>)query.getResultList();
        
        return entityList;
    }
}
