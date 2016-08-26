/** 
 * 编码表信息取得共通方法类
 * <p>编码表信息取得共通方法<br>
 * Copyright 2016-2016
 */
package com.emall.base.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.emall.content.Constant;
import com.emall.dao.entity.MCodeMasterEntity;
import com.emall.dao.entity.id.MCodeMasterPk;
import com.emall.dao.repositorys.IMCodeMasterRepository;

/**
 * 编码表信息取得共通方法类
 * <p>编码表信息取得共通方法<br>
 * @author 孙亮
 * @version 1.0 2016/5/4
 */
@Component
public class CodeMasterManage {

    /** 日志对象 */
    private static Log logger = LogFactory.getLog(CodeMasterManage.class);
    
    /** 编码信息表Dao */
    @Resource
    private IMCodeMasterRepository iMCodeMasterRepository;
    
    /**
     * 取得该编码组ID对应的下拉框选择信息
     * @param codeGroupId 编码组ID
     * @param appendOptionValue 追加的选择项（null或空的时候，不追加）
     * @return 该编码组ID对应的下拉框选择信息
     */
    public LinkedHashMap<String, String> getInfoForDropDown(
        String codeGroupId, String appendOptionValue) {
        
        // 开始日志
        logger.debug("getInfoForDropDown：取得该编码组ID对应的下拉框选择信息-----开始-----");
        
        // 排序条件
        Sort sort = new Sort(Sort.Direction.ASC, 
            Constant.CODE_MASTER_COLUMN_SORT_ORDER);
        
        // 取得该编码组ID的编码信息
        List<MCodeMasterEntity> codeMasterInfoList = 
            iMCodeMasterRepository.findByCodeGroupIdAndShowFlag(
                codeGroupId, Constant.CODE_MASTER_SHOW_FLAG_SHOW, sort);
        
        // 返回值map
        LinkedHashMap<String, String> returnMap = 
            new LinkedHashMap<String, String>();
        
        // 追加的选择项不是空的时候
        if (appendOptionValue != null && !appendOptionValue.isEmpty()) {
            
            // 结束日志
            logger.debug("getInfoForDropDown：取得该编码组ID对应的下拉框选择信息-----结束-----");
            returnMap.put(Constant.STRING_EMPTY, appendOptionValue);
        }
        
        for (MCodeMasterEntity codeMasterEntity : codeMasterInfoList) {
            
            // 编码别名不是空的时候
            if (codeMasterEntity.getCodeAliases() != null 
                && !codeMasterEntity.getCodeAliases().isEmpty()) {
                returnMap.put(codeMasterEntity.getCodeId(), 
                    codeMasterEntity.getCodeAliases());
            } else {
                  returnMap.put(codeMasterEntity.getCodeId(), 
                      codeMasterEntity.getCodeName());
            }
        }
        
        // 结束日志
        logger.debug("getInfoForDropDown：取得该编码组ID对应的下拉框选择信息-----结束-----");
        return returnMap;
    }
    
    /**
     * 取得编码名称
     * @param codeGroupId 编码组ID
     * @param codeId 编码ID
     * @return 编码名称
     */
    public String getCodeName(String codeGroupId, String codeId) {
        
        // 开始日志
        logger.debug("getCodeName：取得编码名称-----开始-----");
        
        // 编码组ID或编码ID是空的时候
        if (codeGroupId == null || codeGroupId.isEmpty() 
            || codeId == null || codeId.isEmpty()) {
            
            // 结束日志
            logger.debug("getCodeName：取得编码名称-----结束-----");
            return Constant.STRING_EMPTY;
        }
        
        // 主键
        MCodeMasterPk codeMasterPk = new MCodeMasterPk(codeGroupId, codeId);
        
        // 取得编码信息
        MCodeMasterEntity codeMasterEntity = 
            iMCodeMasterRepository.findOne(codeMasterPk);
        
        // 编码信息不存在的时候
        if (codeMasterEntity == null) {
            
            // 结束日志
            logger.debug("getCodeName：取得编码名称-----结束-----");
            return Constant.STRING_EMPTY;
        }
        // 编码别名不是空的时候
        if (codeMasterEntity.getCodeAliases() != null 
            && !codeMasterEntity.getCodeAliases().isEmpty()) {
            
            // 结束日志
            logger.debug("getCodeName：取得编码名称-----结束-----");
            return codeMasterEntity.getCodeAliases();
        } else {
            
            // 结束日志
            logger.debug("getCodeName：取得编码名称-----结束-----");
            return codeMasterEntity.getCodeName();
        }
    }
    
    /**
     * 取得编码信息
     * @param codeGroupIdList 编码组IDList
     * @param showFlag 表示标识
     * @return 编码信息list
     */
    public List<MCodeMasterEntity> getCodeMasterInfoList(
        List<String> codeGroupIdList, String showFlag) {
        
        // 开始日志
        logger.debug("getCodeMasterInfoList：取得编码组信息-----开始-----");
        
        // 编码组IDList是空的时候
        if (codeGroupIdList == null || codeGroupIdList.isEmpty()) {
            
            // 结束日志
            logger.debug("getCodeMasterInfoList：取得编码组信息-----结束-----");
            return new ArrayList<MCodeMasterEntity>();
        }
        
        // 取得编码信息
        List<MCodeMasterEntity> codeMasterInfoList = 
            iMCodeMasterRepository.searchByCodeGroupIdList(codeGroupIdList, showFlag);
        
        // 结束日志
        logger.debug("getCodeMasterInfoList：取得编码组信息-----结束-----");
        return codeMasterInfoList;
    }
    /**
     * 取得编码信息
     * @param codeGroupId 编码组ID
     * @param showFlag 表示标识
     * @return 编码信息list
     */
    public List<MCodeMasterEntity> getCodeMasterInfoList(String codeGroupId, String showFlag)
    {
    	List<String> codeGroupIdList = new ArrayList<String>();
    	if(codeGroupId != null && !codeGroupId.equals("")){
    		codeGroupIdList.add(codeGroupId);
    	}
    	return this.getCodeMasterInfoList(codeGroupIdList, showFlag);
    }
    /**
     * 取得编码信息
     * @param codeGroupIdList 编码组IDList
     * @param showFlag 表示标识
     * @return 编码信息Map
     */
    public HashMap<String, String> getCodeMasterInfoMap(
        List<String> codeGroupIdList, String showFlag) {
        
        // 开始日志
        logger.debug("getCodeMasterInfoMap：取得编码组信息map-----开始-----");
        
        // 取得编码信息
        List<MCodeMasterEntity> codeMasterInfoList = 
            this.getCodeMasterInfoList(codeGroupIdList, showFlag);
        
        // 编码信息Map
        HashMap<String, String> returnMap = new HashMap<String, String>();
        
        for (MCodeMasterEntity codeMasterEntity : codeMasterInfoList) {
            
            // 编码别名不是空的时候
            if (codeMasterEntity.getCodeAliases() != null 
                && !codeMasterEntity.getCodeAliases().isEmpty()) {
                returnMap.put(codeMasterEntity.getCodeGroupId() + codeMasterEntity.getCodeId(), 
                    codeMasterEntity.getCodeAliases());
            } else {
                  returnMap.put(codeMasterEntity.getCodeGroupId() + codeMasterEntity.getCodeId(), 
                      codeMasterEntity.getCodeName());
            }
        }
        
        // 结束日志
        logger.debug("getCodeMasterInfoMap：取得编码组信息map-----结束-----");
        return returnMap;
    }
}
