package com.cn.api.usermanage.controller;

import com.cn.api.usermanage.model.JsonModel;
import com.cn.api.usermanage.model.UserModel;
import com.cn.sys.usermanage.service.user.IUserManageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import javax.annotation.Resource;

/**
 * Created by kris on 2016/8/23.
 */
@Controller
@Scope("prototype")
@RequestMapping("/api/usermanage")
public class UserManageController {
    /**
     * 日志处理导入
     */
    private static final Log logger = LogFactory.getLog(UserManageController.class);

    @Autowired
    private IUserManageService userManageService;

    /**
     * 会员中心首页, 客户成长值
     *
     * @param uuid: 密钥
     * @return ModelAndView
     */
    @RequestMapping(value = "/usercreate")
    @ResponseBody
    public JsonModel userCreate(String uuid) {
        JsonModel date = new JsonModel();

        date.setStatus("0");
        date.setData("成功了！");

        return date;
    }

    /**
     * 会员中心首页, 客户成长值
     *
     * @param username: 用户名
     * @param password: 密码
     * @return ModelAndView
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public JsonModel userLogin(@RequestParam(value = "username", required = true) String username,
                               @RequestParam(value = "password", required = true) String password) {
        JsonModel date = new JsonModel();

        UserModel user = userManageService.findByUserName(username);
        date.setStatus("0");
        date.setData(user);

        return date;
    }
}
