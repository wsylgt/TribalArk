/** 
 * 编码信息表Dao接口
 * <p>对编码信息表进行数据操作的Dao接口<br>
 * Copyright 2016-2016
 */
package com.cn.dao.repositorys;

import java.util.List;

import com.cn.dao.entity.MCodeMasterEntity;
import com.cn.dao.entity.id.MCodeMasterPk;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

/**
 * 编码信息表Dao接口
 * <p>对编码信息表进行数据操作的Dao接口<br>
 * @author 孙亮
 * @version 1.0 2016/5/4
 */
@Repository
public interface MCodeMasterRepository extends IBaseRepository<MCodeMasterEntity, MCodeMasterPk>{
    
    /**
     * 取得该编码组ID的编码信息
     * @param codeGroupId 编码组ID
     * @param showFlag 表示标识
     * @param sort 排序条件
     * @return 该编码组ID的编码信息
     */
    public List<MCodeMasterEntity> findByCodeGroupIdAndShowFlag(
            String codeGroupId, String showFlag, Sort sort);

    
    /**
     * 取得该编码组ID的编码信息
     * @param codeGroupId:编码组ID
     * @return 该编码组ID的编码信息
     */
    public List<MCodeMasterEntity> findByCodeGroupId(String codeGroupId);
    
    /**
     * 取得编码组和编码ID对应的编码信息
     * @param codeGroupId 编码组ID
     * @param codeId 编码ID
     * @return 该编码组和编码ID的编码信息
     */
    public MCodeMasterEntity findByCodeGroupIdAndCodeId(String codeGroupId, String codeId);

    
    /**
     * 根据编码组IDlist取得编码信息
     * @param codeGroupIdList 编码组IDlist
     * @param showFlag 表示标识
     * @return 编码信息list
     */
    public List<MCodeMasterEntity> searchByCodeGroupIdList(
            List<String> codeGroupIdList, String showFlag);
}
