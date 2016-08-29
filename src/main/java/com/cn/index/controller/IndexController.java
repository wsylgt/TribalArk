package com.cn.index.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Kris2 on 2016/8/24.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    /** 日志处理的导入 */
    private static final Log logger = LogFactory.getLog(IndexController.class);

    /**
     * 主页请求响应
     * <p>用户访问系统时，进入的第一个页面<br>
     * 响应的标识：主域名、主域名/index、主域名/home
     * @param
     * @return 指定显示页面
     */
    @RequestMapping(value = {"index", "home"})
    public ModelAndView init() {
        ModelAndView model = new ModelAndView();
        // 日志处理
        logger.info("欢迎页初始化！");

        // 指定显示页面
        model.setViewName("index");
        return model;
    }
}
