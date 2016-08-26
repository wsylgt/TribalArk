/** 
 * 资源表Dao接口
 * <p>资源表Dao接口</p>
 * Copyright 2016-2016
 */
package com.cn.dao.repositorys;

import com.cn.dao.entity.MmResourcesEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * 资源表Dao接口
 * <p>资源表Dao接口</p>
 * @author 王成龙
 * @version 1.0 2016/5/4
 */
@Repository
public interface MmResourcesRepository extends IBaseRepository<MmResourcesEntity,Long> {

    /**
     * 根据资源Id组  查询 
     * @param resourceIds
     * @return
     */
    List<MmResourcesEntity> findByResourceIdIn(Collection<Long> resourceIds);
    
    /**
     * 根据资源请求URL查询
     * @param resourceString
     * @return
     */
    List<MmResourcesEntity> findByResourceString(String resourceString);

    /**
     * 根据资源所属ID取得资源
     * @param attributionId
     * @return
     */
    List<MmResourcesEntity> findByAttributionId(long attributionId);


    /**
     * 根据资源所属ID组取得资源
     * @param attributionIds
     * @return
     */
    List<MmResourcesEntity> findByAttributionIdIn(Collection<Long> attributionIds);

}
