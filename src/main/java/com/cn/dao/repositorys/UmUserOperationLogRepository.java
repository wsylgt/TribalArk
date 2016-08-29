/**
 * 用户操作日志表Dao接口文件
 * <p>用户操作日志表Dao接口</p>
 * Copyright 2016-2016 .
 */
package com.cn.dao.repositorys;

import com.cn.dao.entity.UmUserOperationLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * 用户操作日志表Dao接口
 * <p>用户操作日志表Dao接口,定义搜索日志方法</p>
 * @author 刘广飞
 * @version 1.0 2016/5/24
 */
@Repository
public interface UmUserOperationLogRepository extends IBaseRepository<UmUserOperationLogEntity, Long>{

    /**
     * 根据搜索条件搜索日志信息
     * @param beginDateTime: 开始日期
     * @param endDateTime: 结束日期
     * @param userName: 用户名(操作人)
     * @param pageable: Pageable对象
     * @return Page
     */
    public Page<UmUserOperationLogEntity> searchByBeginDateTimeAndEndDateTimeAndUserName(String beginDateTime,
                                                                                         String endDateTime, String userName, Pageable pageable);
}
