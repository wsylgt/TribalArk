package com.emall.dao.repositorys;

import javax.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emall.dao.entity.MSequenceTEntity;

/**
 * 顺序表DAO接口
 * <p>顺序表DAO接口<br>
 * @author 王国栋
 * @version 1.0 2016/4/26
 * @param <T>
 */
@Repository
public interface IMSequenceTRepository  extends BaseRepository<MSequenceTEntity, Long>{

    /**
     * 通过SequenceName查询对象MSequenceTEntity并for update
     * @param sequenceName  顺序名称 
     * @return 对象MSequenceTEntity
     */
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    public MSequenceTEntity getBySequenceName(String sequenceName);

    /**
     * 获取系统时间
     * @return  系统时间字符串数据
     */
    @Transactional
    public String searchSystemTime();
}
