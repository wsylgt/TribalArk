package com.cn.index.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Kris2 on 2016/8/24.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    /** 日志处理的导入 */
    private static final Log logger = LogFactory.getLog(LoginController.class);

    /**
     * 主页请求响应
     * <p>用户访问系统时，进入的第一个页面<br>
     * 响应的标识：主域名、主域名/index、主域名/home
     * @param
     * @return 指定显示页面
     */
    @RequestMapping(value = {"login"})
    public ModelAndView login(@RequestParam(value = "username", required = false) String username,
                              @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView();

        model.setViewName("login");
        model.addObject("username", username);
        model.addObject("password", password);
        // 判断登录返回值是否错误
        if (error != null) {
            logger.info("登录失败，用户名或密码不正确！");
        } else if ("1".equals(error)) {
            logger.info("登录失败，用户名或密码不正确！");
        } else if (error == null) {
            logger.info("请登录！");
        }
        return model;
    }

    /**
     * 注销处理
     * @param
     * @return model
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout() {

        ModelAndView model = new ModelAndView();

        // 处理完跳转页面
        model.setViewName("login");
        return model;
    }
}
