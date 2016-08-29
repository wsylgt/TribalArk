package com.cn.dao.repositorys;

import com.cn.dao.entity.SystemDateEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 顺序表DAO接口
 * <p>顺序表DAO接口<br>
 * @author 王国栋
 * @version 1.0 2016/4/26
 */
@Repository
public interface MSystemDateRepository  extends IBaseRepository<SystemDateEntity, Date>{

    /**
     * 获取系统时间
     * @return  系统时间字符串数据
     */
    public String searchSystemTime();
}
