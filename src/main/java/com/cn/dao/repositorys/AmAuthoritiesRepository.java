/** 
 * 权限表Dao接口
 * <p>权限表Dao接口</p>
 * Copyright 2016-2016
 */
package com.cn.dao.repositorys;

import java.util.Collection;
import java.util.List;

import com.cn.dao.entity.AmAuthoritiesEntity;
import org.springframework.stereotype.Repository;

/**
 * 权限表Dao接口
 * <p>权限表Dao接口</p>
 * @author 王成龙
 * @version 1.0 2016/5/4
 */
@Repository
public interface AmAuthoritiesRepository extends IBaseRepository<AmAuthoritiesEntity, Long> {

    /**
     * 根据权限Id组 查询
     * @param authorityIds
     * @return
     */
    List<AmAuthoritiesEntity> findByAuthorityIdIn(Collection<Long> authorityIds);

    /**
     * 根据权限状态编码组ID取得权限
     * @param authorityStatusGroupId
     * @return
     */
    List<AmAuthoritiesEntity> findByAuthorityStatusGroupId(String authorityStatusGroupId);
}
