package com.cn.dao.repositorys.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

/**
 * Created by Kris2 on 2016/8/25.
 */
public class MSystemDateRepositoryImpl {

    /** JPA实体管理对象*/
    @PersistenceContext
    private EntityManager entityManager;

    public String searchSystemTime(){

        String hql = "select now()";
        //检索对象
        Query query = entityManager.createNativeQuery(hql);
        String sysDate = query.getSingleResult().toString();

        return sysDate;
    }
}
