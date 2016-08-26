/**
 * 角色表Dao
 * <p>角色表Dao</p>
 * Copyright 2016-2016 .
 */
package com.emall.dao.repositorys;

import com.emall.dao.entity.UmRoleEntity;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 角色表Dao
 * <p>角色表Dao</p>
 * @author 王成龙
 * @version 1.0 2016/5/16
 */
@Repository
public interface IUmRoleRepository extends BaseRepository<UmRoleEntity, Long> {

    /**
     * 根据角色Id组 查询角色信息
     * @param roleIds
     * @return
     */
    List<UmRoleEntity> findByRoleIdIn(Collection<Long> roleIds);

    /**
     * 根据角色Id取得角色 
     * @param roleId
     * @return
     */
    UmRoleEntity findByRoleId(long roleId);

    /**
     * 根据角色名取得角色
     * @param roleName
     * @return
     */
    List<UmRoleEntity> findByRoleName(String roleName);
}
