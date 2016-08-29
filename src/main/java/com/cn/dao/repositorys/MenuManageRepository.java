/** 
 * 菜单表Dao接口
 * <p>菜单表Dao接口</p>
 * Copyright 2016-2016
 */
package com.cn.dao.repositorys;

import com.cn.dao.entity.MmMenuManageEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单Dao接口
 * <p>获得菜单list</p>
 *
 * @author 王成龙
 * @version 1.0 2016/4/26
 */
@Repository
public interface MenuManageRepository extends IBaseRepository<MmMenuManageEntity, Long> {

    /**
     * 根据menuGroupId取得菜单
     *
     * @param menuGroupId
     * @return
     */
    List<MmMenuManageEntity> findByMenuGroupId(long menuGroupId);

    /**
     * 根据menuId取得菜单
     *
     * @param menuId
     * @return
     */
    MmMenuManageEntity findByMenuId(long menuId);

}
