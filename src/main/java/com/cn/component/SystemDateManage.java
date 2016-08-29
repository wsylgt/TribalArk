package com.cn.component;

import com.cn.dao.repositorys.MCodeMasterRepository;
import com.cn.dao.repositorys.MSystemDateRepository;
import com.cn.utils.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Kris2 on 2016/8/25.
 */
@Component
public class SystemDateManage {

    /** 日志对象 */
    private static Log logger = LogFactory.getLog(CodeMasterManage.class);

    /** 编码信息表Dao */
    @Resource
    private MSystemDateRepository systemDateRepository;

    /**
     * 获取系统时间
     * @return  java.util.Date数据
     */
    public Date getSystemTime(){
        logger.debug("getSystemTime : 获取系统时间");
        return DateFormatUtils.parseDate(systemDateRepository.searchSystemTime(), DateFormatUtils.DEFAULT_DATETIME_FORMAT);
    }
}
