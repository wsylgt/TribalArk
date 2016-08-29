/**
 * 菜单组表的Dao接口
 * <p>菜单表的Dao接口</p> 
 * Copyright 2016-2016 .
 */
package com.cn.dao.repositorys;

import com.cn.dao.entity.MmMenuGroupManageEntity;
import org.springframework.stereotype.Repository;


/**
 * 菜单组Dao接口
 * <p>获得菜单组list</p>
 *
 * @author 王成龙
 * @version 1.0 2016/4/26
 */
@Repository
public interface MenuGroupManageRepository extends IBaseRepository<MmMenuGroupManageEntity, Long> {

    /**
     * 根据menuGroupId取得菜单组
     *
     * @param menuGroupId
     * @return
     */
    MmMenuGroupManageEntity findByMenuGroupId(long menuGroupId);

}
