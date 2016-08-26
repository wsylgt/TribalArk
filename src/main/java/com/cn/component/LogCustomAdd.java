package com.emall.base.component;

import com.emall.base.model.LogModel;
import com.emall.dao.entity.UmUserOperationLogEntity;
import com.emall.dao.repositorys.IUmUserOperationLogRepository;
import com.emall.security.model.SecurityUserModel;
import com.emall.util.ValidateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
/**
 * 自定义数据库LOG添加
 * <p>LOG添加<br>
 * @author 王国栋
 * @version 1.0 2016/05/27
 */
@Component
public class LogCustomAdd {

    /** 日志对象 */
    private static Log logger = LogFactory.getLog(ContextManage.class);

    /** 注入Service用于把日志保存数据库 */
    @Resource
    private IUmUserOperationLogRepository iUmUserOperationLogRepository;

    /** 系统的Context */
    @Autowired
    private ContextManage context;

    /**
     * 自定义数据库LOG添加(methodName必须非空)
     * @param logModel  日志对象
     */
    public void addLog(LogModel logModel) {
        logger.debug("addLog : 数据库LOG添加不含方法参数");
        //系统时间
        Date date = context.getSystemTime();
        // request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        // 获得用户账号
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession()
                .getAttribute("SPRING_SECURITY_CONTEXT");
        UsernamePasswordAuthenticationToken userNameAndPass = (UsernamePasswordAuthenticationToken) securityContextImpl
                .getAuthentication();
        //数据库表um_user_t的实体类
        SecurityUserModel model = (SecurityUserModel) userNameAndPass.getPrincipal();
        //登陆者
        String name = model.getUserDetail().getUserName();
        //用户ID
        long userId = model.getUserDetail().getUserId();
        // 获取请求ip
        String ip = request.getRemoteAddr();
        //用户操作日志表Entity
        UmUserOperationLogEntity log = new UmUserOperationLogEntity();
        //自定义信息
        if(!ValidateUtil.isValid(logModel.getCustomMessage())){
            log.setRemarks(logModel.getCustomMessage());
        }
        //方法描述
        if(!ValidateUtil.isValid(logModel.getMethodOperation())){
            log.setOperationContent(logModel.getMethodOperation());
        }
        //请求方法
        if(!ValidateUtil.isValid(logModel.getMethodName())){
            log.setMethod(logModel.getMethodName());
        }
        //请求参数
        if(!ValidateUtil.isValid(logModel.getMethodParams())){
            log.setParams(logModel.getMethodParams());
        }
        //请求IP
        log.setLoginIP(ip);
        //请求人
        log.setUserName(name);
        //用户ID
        log.setUserId(userId);
        //操作时间
        log.setOperationDate(date);
        //创建时间
        log.setCreateTime(date);
        //创建者
        log.setCreateUser(name);
        //修改时间
        log.setUpdateTime(date);
        //修改人
        log.setUpdateUser(name);
        // 保存数据库
        iUmUserOperationLogRepository.save(log);
    }
}
