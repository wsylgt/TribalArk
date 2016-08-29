/** 
 * 用户角色表Dao接口
 * <p>用户角色表Dao接口</p>
 * Copyright 2016-2016
 */
package com.cn.dao.repositorys;

import com.cn.dao.entity.UmUserRoleEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * 用户角色表Dao接口
 * <p>用户角色表Dao接口</p>
 * @author 王成龙
 * @version 1.0 2016/4/23
 */
@Repository
public interface UmUserRoleRepository extends IBaseRepository<UmUserRoleEntity, Long> {

    /**
     * 根据用户Id查询用户信息
     * @param userId 用户Id
     * @return
     */
    List<UmUserRoleEntity> findByUserId(long userId);

    /**
     * 根据角色Id取得用户
     * @param roleId 角色Id
     * @return
     */
    List<UmUserRoleEntity> findByRoleId(long roleId);
    
    /**
     * 根据用户的ID查询用户角色
     * @param userId: 后台用户ID
     * @return List
     */
    public List<UmUserRoleEntity> findByUserIdIn(Collection<Long> userId);
    
}
