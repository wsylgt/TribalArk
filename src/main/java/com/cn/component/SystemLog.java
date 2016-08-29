package com.cn.component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解  
 * <p>自定义注解<br>
 * @author 王国栋
 * @version 1.0 2016/05/23
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)    
@Documented
public @interface SystemLog {

    String methodDescription()  default "";
}
