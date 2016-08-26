/** 
 * 角色资源权限表Dao接口
 * <p>角色资源权限表Dao接口</p>
 * Copyright 2016-2016
 */
package com.cn.dao.repositorys;

import java.util.Collection;
import java.util.List;

import com.cn.dao.entity.AmRoleResourceAuthorityEntity;
import org.springframework.stereotype.Repository;

/**
 * 角色资源权限表Dao接口
 * <p>角色资源权限表Dao接口</p>
 * @author 王成龙
 * @version 1.0 2016/5/4
 */
@Repository
public interface AmRoleResourceAuthorityRepository extends IBaseRepository<AmRoleResourceAuthorityEntity,Long> {

    /**
     * 根据角色Id组查询，并根据资源Id进行升序排列
     * @param roleIds
     * @return
     */
    List<AmRoleResourceAuthorityEntity> findByRoleIdInOrderByResourceIdAsc(Collection<Long> roleIds);

    /**
     * 根据资源Id组查询
     * @param resourceIdIds
     * @return
     */
    List<AmRoleResourceAuthorityEntity> findByResourceIdIn(Collection<Long> resourceIdIds);

    /**
     * 根据角色Id取得已经有权限的资源
     * @param roleId
     * @return
     */
    List<AmRoleResourceAuthorityEntity> findByRoleId(long roleId);
}
