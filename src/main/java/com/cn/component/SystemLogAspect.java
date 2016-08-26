package com.emall.base.component;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONArray;
import com.emall.dao.entity.UmUserOperationLogEntity;
import com.emall.dao.repositorys.IUmUserOperationLogRepository;
import com.emall.security.model.SecurityUserModel;

/**
 * spring AOP切面类
 * <p>切面类<br>
 * @author 王国栋
 * @version 1.0 2016/05/23
 */
@Aspect
@Component
public class SystemLogAspect {

    /** 日志对象 */
    private static Log logger = LogFactory.getLog(SystemLogAspect.class);

    /** 注入Service用于把日志保存数据库 */
    @Resource
    private IUmUserOperationLogRepository iUmUserOperationLogRepository;

    /** 系统的Context */
    @Autowired
    private ContextManage context;

    /** 切点 */
    @Pointcut("@annotation(com.emall.base.component.SystemLog)")
    public void pointcut() {
    }

    /**
     * 后置通知 用于记录日志
     * @param joinPoint 切点 
     */
     @Before("pointcut()")
     public  void doAfter(JoinPoint joinPoint) {
        /*DBContextHolder.setDBType(Constant.DATA_SOURCE_MASTER);*/
        //系统时间
        Date date = context.getSystemTime();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
        // 获得用户账号
        SecurityContextImpl securityContextImpl = (SecurityContextImpl)request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        UsernamePasswordAuthenticationToken userNameAndPass = (UsernamePasswordAuthenticationToken)securityContextImpl.getAuthentication();
        SecurityUserModel model = (SecurityUserModel)userNameAndPass.getPrincipal();
        String name = model.getUserDetail().getUserName();
        //获取请求IP
        String ip = request.getRemoteAddr();
        //用户ID
        long userId = model.getUserDetail().getUserId();
        //方法参数
        String params = "";
        if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
            for ( int i = 0; i < joinPoint.getArgs().length; i++) {
               if(joinPoint.getArgs()[i] instanceof BeanPropertyBindingResult){
                    continue;
               }
               params += JSONArray.toJSON(joinPoint.getArgs()[i]) + ";";
               if(!"".equals(params) && params.length() >= 255){
                   params = params.substring(0, 254);
                   break;
               }
           }
       }
         try {
             // *========数据库日志=========*//
             UmUserOperationLogEntity log = new UmUserOperationLogEntity();
/*             //方法描述
             log.setOperationContent(getMthodDescription(joinPoint));*/

             SystemLog systemLog = giveController(joinPoint);
             //方法描述
             log.setOperationContent(systemLog.methodDescription());
             //请求方法
             log.setMethod(
                     (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
             //请求参数
             log.setParams(params);
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
        }  catch (Exception ex) {    
            //记录本地异常日志    
            logger.error("==异常通知异常==");
            logger.error("异常信息:{}", ex);
        }
         /*==========记录本地异常日志==========*/
        logger.error( joinPoint.getTarget().getClass().getName()+","+joinPoint.getSignature().getName()+","+params);    
    
    }

    /**
     * 获取注解中对方法的描述信息 用于注解
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static String getMthodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemLog.class).methodDescription();
                    break;
                }
            }
        }
        return description;
    }
    /**
     * 是否存在注解，如果存在就记录日志
     * @param joinPoint
     * @param controllerLog
     * @return
     * @throws Exception
     */
    private static SystemLog giveController(JoinPoint joinPoint) throws Exception
    {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if(method != null)
        {
            return method.getAnnotation(SystemLog.class);
        }
        return null;
    }

}
