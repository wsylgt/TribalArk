/** 
 * 用户表Dao接口
 * <p>用户表Dao接口</p>
 * Copyright 2016-2016
 */
package com.cn.dao.repositorys;

import com.cn.dao.entity.UmUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * 用户表Dao接口
 * <p>用户表Dao接口</p>
 * @author 王成龙
 * @version 1.0 2016/4/23
 */
@Repository
public interface UmUserRepository extends IBaseRepository<UmUserEntity, Long> {

    /**
     * 根据账号查询对象UmUserEntity
     * @param userName 账号
     * @return 对象UmUserEntity
     */
    public UmUserEntity findByUserName(String userName);

}
