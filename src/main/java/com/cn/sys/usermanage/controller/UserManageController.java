package com.cn.sys.usermanage.controller;


import com.cn.component.SystemLog;
import com.cn.content.Constant;
import com.cn.model.JsonModel;
import com.cn.sys.usermanage.model.*;
import com.cn.sys.usermanage.service.IUserManageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by kris on 2016/8/23.
 */
@Controller
@RequestMapping("/sys/usermanage")
public class UserManageController {
    /**
     * 日志处理导入
     */
    private static final Log logger = LogFactory.getLog(UserManageController.class);

    @Autowired
    private IUserManageService userManageService;

    /**
     * 添加用户界面
     *
     * @return ModelAndView
     */
    @RequestMapping(value = "/create")
    public ModelAndView create() {

        logger.info("create: 添加用户界面");

        ModelAndView model = new ModelAndView();

        ViewModel view = userManageService.getViewInfo();

        model.addObject("view", view);
        model.addObject("user", new UserModel());
        model.setViewName("/sys/usermanage/create.base");
        return model;
    }

    /**
     * 添加一个用户
     *
     * @param user: UserModel对象
     * @return JsonModel
     */
    @SystemLog(methodDescription = "添加后台用户")
    @RequestMapping(value = "/create/save")
    public ModelAndView createCreate(@ModelAttribute("user") @Valid UserModel user, BindingResult result) {
        logger.info("createCreate: 添加一个用户");
        ModelAndView model = new ModelAndView();

        model.setViewName("/sys/usermanage/create.base");

        // 判断对象是否满足验证
        if (result.hasErrors()) {
            // 设置状态为1: 输入信息有误
//            jsonModel.setStatus(Constant.JSON_STATUS_INPUT_ERROR);
//
//            for (FieldError fieldError : result.getFieldErrors()) {
//                jsonModel.putErrorMessage(fieldError.getField(), fieldError.getDefaultMessage());
//            }
        } else {
            // 获取处理状态信息
            String status = userManageService.saveUser(user);

            // 如果是DB处理错误的时候
            if (Constant.STATUS_DB_ERROR.equals(status)) {

                //设置状态为2: DB处理错误
//                jsonModel.setStatus(
//                        Constant.JSON_STATUS_DB_ERROR);
            } else {

                //设置状态为0: 正常
//                jsonModel.setStatus(
//                        Constant.JSON_STATUS_OK);
            }
        }

        model.addObject("user", user);
        return model;
    }

    /**
     * 默认的用户管理列表
     *
     * @param pageNumber: 页号
     * @param pageSize:   每页显示的条数
     * @param employeeNo: 员工号
     * @param userName:   用户名
     * @param roleId:     角色ID
     * @param isDelete:   是否删除,0: 否   1: 是
     * @return ModelAndView
     */
    @RequestMapping(value = {"", "index", "list"})
    public ModelAndView allUser(@ModelAttribute("userModel") @Valid UserModel userModel,
                                @RequestParam(value = "pageNumber", defaultValue = Constant.DIGIT_ZERO + "", required = false) int pageNumber,
                                @RequestParam(value = "pageSize", defaultValue = Constant.DIGIT_TEN + "", required = false) int pageSize,
                                @RequestParam(value = "employeeNo", required = false) String employeeNo,
                                @RequestParam(value = "userName", required = false) String userName,
                                @RequestParam(value = "roleId", required = false) Long roleId,
                                @RequestParam(value = "isDelete", required = false) String isDelete) {

        logger.info("allUser: 用户管理列表");

        // 获取用户列表信息
        Page<UserModel> pageModel = userManageService.allUser(pageNumber, pageSize, employeeNo, userName, roleId, isDelete);

        // 获取用户角色列表信息
        List<RoleModel> roleModelList = userManageService.allRole();

        ModelAndView model = new ModelAndView();
        model.addObject("userModel", userModel);
        model.addObject("roleModelList", roleModelList);
        model.addObject("employeeNo", employeeNo);
        model.addObject("userName", userName);
        model.addObject("roleId", roleId);
        model.addObject("isDelete", isDelete);
        model.setViewName("sys/usermanage/list.base");
        return model;
    }

    /**
     * 用户详细信息界面
     *
     * @param userId: 用户ID
     * @return ModelAndView
     */
    @RequestMapping(value = "/view")
    public ModelAndView userDetailView(@RequestParam("userId") long userId) {
        logger.info("userDetailView: 用户详细信息界面");

        // 获取用户详细信息
        UserModel userModel = userManageService.findByUserId(userId);

        // 获取用户角色列表信息
        List<RoleModel> roleModelList = userManageService.allRole();

        ModelAndView model = new ModelAndView();
        model.addObject("userModel", userModel);
        model.addObject("roleModelList", roleModelList);
        model.setViewName("sys/usermanage/view.base");
        return model;
    }


    /**
     * 编辑用户信息
     *
     * @param
     * @return
     */
    @SystemLog(methodDescription = "编辑用户信息")
    @RequestMapping(value = "/modify")
    @ResponseBody
    public JsonModel modify(@ModelAttribute("userEditModel") @Valid UserEditModel model, BindingResult result) {
        logger.info("editUser: 编辑用户信息");

        // 返回值
        JsonModel jsonModel = new JsonModel();

        // 判断对象是否满足验证
        if (result.hasErrors()) {
            // 设置状态为1: 输入信息有误
            jsonModel.setStatus(
                    Constant.JSON_STATUS_INPUT_ERROR);

            for (FieldError fieldError : result.getFieldErrors()) {
                jsonModel.putErrorMessage(fieldError.getField(), fieldError.getDefaultMessage());
            }
        } else {
            // 获取处理状态信息
            String status = userManageService.editUser(model);

            // 如果是DB处理错误的时候
            if (Constant.STATUS_DB_ERROR.equals(status)) {

                //设置状态为2: DB处理错误
                jsonModel.setStatus(
                        Constant.JSON_STATUS_DB_ERROR);
            } else {

                //设置状态为0: 正常
                jsonModel.setStatus(
                        Constant.JSON_STATUS_OK);
            }
        }
        return jsonModel;
    }

    /**
     * 根据用户ID冻结用户账户
     *
     * @param userId: 用户ID
     * @return JsonModel
     */
    @SystemLog(methodDescription = "冻结后台用户账户")
    @RequestMapping(value = "/freezeaccount")
    @ResponseBody
    public JsonModel freezeAccount(@RequestParam("userId") Long userId) {
        logger.info("freezeAccount: 根据用户ID冻结用户账户");

        // 返回值
        JsonModel returnJsonModel = new JsonModel();

        String status = userManageService.freezeAccount(userId);

        // 如果是DB处理错误的时候
        if (Constant.STATUS_DB_ERROR.equals(status)) {

            // 设置状态为2：DB处理错误
            returnJsonModel.setStatus(
                    Constant.JSON_STATUS_DB_ERROR);
        } else {

            // 设置状态为0：设置状态为正常
            returnJsonModel.setStatus(
                    Constant.JSON_STATUS_OK);
        }
        return returnJsonModel;
    }

    /**
     * 根据用户ID恢复用户账户
     *
     * @param userId: 用户ID
     * @return JsonModel
     */
    @SystemLog(methodDescription = "恢复后台用户账户")
    @RequestMapping(value = "/recoveryaccount")
    @ResponseBody
    public JsonModel recoveryAccount(@RequestParam("userId") Long userId) {
        logger.info("recoveryAccount: 根据用户ID删除一个用户");

        // 返回值
        JsonModel returnJsonModel = new JsonModel();

        String status = userManageService.recoveryAccount(userId);

        // 如果是DB处理错误的时候
        if (Constant.STATUS_DB_ERROR.equals(status)) {

            // 设置状态为2：DB处理错误
            returnJsonModel.setStatus(
                    Constant.JSON_STATUS_DB_ERROR);
        } else {

            // 设置状态为0：设置状态为正常
            returnJsonModel.setStatus(
                    Constant.JSON_STATUS_OK);
        }
        return returnJsonModel;
    }

    /**
     * 根据用户ID删除一个用户,逻辑删除,更改状态
     *
     * @param userId: 用户ID
     * @return String
     */
    @SystemLog(methodDescription = "逻辑删除后台用户")
    @RequestMapping(value = "/deleteuser")
    @ResponseBody
    public JsonModel deleteUser(@RequestParam("userId") Long userId) {
        logger.info("deleteUser: 根据用户ID删除一个用户");

        // 返回值
        JsonModel returnJsonModel = new JsonModel();

        String status = userManageService.deleteUser(userId);

        // 如果是DB处理错误的时候
        if (Constant.STATUS_DB_ERROR.equals(status)) {

            // 设置状态为2：DB处理错误
            returnJsonModel.setStatus(
                    Constant.JSON_STATUS_DB_ERROR);
        } else {

            // 设置状态为0：设置状态为正常
            returnJsonModel.setStatus(
                    Constant.JSON_STATUS_OK);
        }
        return returnJsonModel;
    }

    /**
     * 根据用户ID恢复删除的用户
     *
     * @param userId: 用户ID
     * @return String
     */
    @SystemLog(methodDescription = "恢复删除的后台用户")
    @RequestMapping(value = "/recoveryuser")
    @ResponseBody
    public JsonModel recoveryUser(@RequestParam("userId") Long userId) {
        logger.info("recoveryUser: 根据用户ID恢复删除的用户");

        // 返回值
        JsonModel returnJsonModel = new JsonModel();

        String status = userManageService.recoveryUser(userId);

        // 如果是DB处理错误的时候
        if (Constant.STATUS_DB_ERROR.equals(status)) {

            // 设置状态为2：DB处理错误
            returnJsonModel.setStatus(
                    Constant.JSON_STATUS_DB_ERROR);
        } else {

            // 设置状态为0：设置状态为正常
            returnJsonModel.setStatus(
                    Constant.JSON_STATUS_OK);
        }
        return returnJsonModel;
    }

    /**
     * 重置用户名密码
     *
     * @param
     * @return
     */
    @SystemLog(methodDescription = "重置后台用户密码")
    @RequestMapping(value = "/resetpassword")
    @ResponseBody
    public JsonModel resetPassword(@ModelAttribute("resetPasswordModel") @Valid ResetPasswordModel model, BindingResult result) {
        logger.info("recoveryUser: 重置用户名密码");

        // 返回值
        JsonModel jsonModel = new JsonModel();

        // 判断对象是否满足验证
        if (result.hasErrors()) {
            // 设置状态为1: 输入信息有误
            jsonModel.setStatus(
                    Constant.JSON_STATUS_INPUT_ERROR);

            for (FieldError fieldError : result.getFieldErrors()) {
                jsonModel.putErrorMessage(fieldError.getField(), fieldError.getDefaultMessage());
            }
        } else {
            // 获取处理状态信息
            String status = userManageService.resetPassword(model);

            // 如果是DB处理错误的时候
            if (Constant.STATUS_DB_ERROR.equals(status)) {

                //设置状态为2: DB处理错误
                jsonModel.setStatus(
                        Constant.JSON_STATUS_DB_ERROR);
            } else {

                //设置状态为0: 正常
                jsonModel.setStatus(
                        Constant.JSON_STATUS_OK);
            }
        }
        return jsonModel;
    }

    /**
     * 查询用户名、工号，是否已经存在
     *
     * @param userName:    用户名
     * @param employeeNo:  工号
     * @param cellphoneNo: 手机号码
     * @return String
     */
    @RequestMapping(value = "/isexist")
    @ResponseBody
    public JsonModel isExist(@RequestParam(value = "userName", required = false) String userName,
                             @RequestParam(value = "employeeNo", required = false) String employeeNo,
                             @RequestParam(value = "cellphoneNo", required = false) String cellphoneNo) {
        logger.info("isExist: 查询昵称、手机号码、邮箱是否已经存在");

        // 返回值
        JsonModel returnJsonModel = new JsonModel();
        // 获取查询状态
        String isExist = userManageService.isExist(userName, employeeNo, cellphoneNo);

        // 如果是存在的时候
        if (Constant.DB_EXISTS.equals(isExist)) {
            returnJsonModel.setStatus(Constant.DB_EXISTS);
        } else {
            returnJsonModel.setStatus(Constant.DB_NOT_EXISTS);
        }
        return returnJsonModel;
    }
}
