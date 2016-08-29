/**
 * 角色管理Controller
 * <p>角色管理Controller</p>
 * Copyright 2016-2016 .
 */
package com.cn.sys.rolemanage.controller;

import com.cn.component.SystemLog;
import com.cn.content.Constant;
import com.cn.model.JsonModel;
import com.cn.sys.rolemanage.model.AddUserModel;
import com.cn.sys.rolemanage.model.RoleModel;
import com.cn.sys.rolemanage.model.UserModel;
import com.cn.sys.rolemanage.service.IRoleManageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 角色管理Controller
 * <p>角色管理Controller</p>
 *
 * @author 王成龙
 * @version 1.0 2016/05/16
 */
@Controller
@RequestMapping("/um/rolemanage")
public class RoleManageController {
    /**
     * 日志处理导入
     */
    private static final Log logger = LogFactory.getLog(RoleManageController.class);

    /**
     * 角色管理Service接口
     */
    @Resource
    private IRoleManageService iRoleManageService;

    /**
     * 角色列表
     *
     * @return model 角色列表
     */
    @RequestMapping(value = {"", "index"})
    public ModelAndView roleList() {
        logger.info("roleList:取得角色List Controller！----开始----");
        ModelAndView model = new ModelAndView();
        // 角色取得
        List<RoleModel> roleModelList = iRoleManageService.getRoleList();
        // 将角色List提交前台
        model.addObject("roleModelList", roleModelList);
        model.setViewName("um/rolemanage/rolemanage.base");

        return model;
    }

    /**
     * 根据角色Id查看属于该角色的用户
     *
     * @param roleId
     * @return model 用户列表
     */
    @RequestMapping(value = "viewuser", method = RequestMethod.GET)
    public ModelAndView viewUser(@RequestParam(value = "roleId") long roleId) {
        logger.info("viewUser:取得用户List Controller！----开始----");
        ModelAndView model = new ModelAndView();
        // 角色取得
        RoleModel roleInfo = iRoleManageService.getRoleInfo(roleId);

        // 根据角色ID，取得属于该角色的用户
        List<UserModel> userList = iRoleManageService.getUserList(roleId);
        // 将角色信息提交前台
        model.addObject("roleInfo", roleInfo);
        // 将用户信息提交前台
        model.addObject("userList", userList);
        model.setViewName("um/rolemanage/viewuser.base");

        return model;
    }

    /**
     * 用户检索
     *
     * @param userModel
     * @return model
     */
    @RequestMapping(value = "searchuser")
    public ModelAndView searchUser(@ModelAttribute("userModel") @Valid UserModel userModel) {
        logger.info("searchUser:用户检索 Controller！----开始----");
        ModelAndView model = new ModelAndView();

        // 根据角色ID，取得属于该角色的用户
        List<UserModel> userList = iRoleManageService.searchUser(userModel);

        // 角色取得
        RoleModel roleInfo = iRoleManageService.getRoleInfo(userModel.getRoleId());

        // 将用户信息提交前台
        // 员工号
        model.addObject("employeeNo", userModel.getEmployeeNo().replace(
                Constant.STRING_SPACE, Constant.STRING_EMPTY));
        // 用户名
        model.addObject("userName", userModel.getUserName().replace(
                Constant.STRING_SPACE, Constant.STRING_EMPTY));
        // 角色信息
        model.addObject("roleInfo", roleInfo);
        // 用户List
        model.addObject("userList", userList);
        model.setViewName("um/rolemanage/viewuser.base");

        return model;
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return model
     */
    @SystemLog(methodDescription = "删除用户")
    @RequestMapping(value = "deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel deleteUser(@RequestParam(value = "roleId") long roleId,
                                @RequestParam(value = "userId") long userId) {
        logger.info("deleteUser:用户删除 Controller！----开始----");
        // 返回值
        JsonModel returnJsonModel = new JsonModel();
        // 用户Model
        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        userModel.setRoleId(roleId);

        String status = iRoleManageService.deleteUser(userModel);
        // DB处理错误的时候
        if (Constant.STATUS_DB_ERROR.equals(status)) {
            // 设置状态为2：DB处理错误
            returnJsonModel.setStatus(
                    Constant.JSON_STATUS_DB_ERROR);
        } else {
            // 设置状态为正常
            returnJsonModel.setStatus(
                    Constant.JSON_STATUS_OK);
        }

        return returnJsonModel;
    }

    /**
     * 添加角色
     *
     * @param roleModel
     * @return model
     */
    @SystemLog(methodDescription = "添加角色")
    @RequestMapping(value = "addrole", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel addRole(@ModelAttribute("roleModel") @Valid RoleModel roleModel, BindingResult result) {
        logger.info("addRole:添加角色 Controller！----开始----");
        // 返回值
        JsonModel returnJsonModel = new JsonModel();

        // 判断对象是否满足验证
        if (result.hasErrors()) {
            // 设置状态为1：输入验证错误
            returnJsonModel.setStatus(
                    Constant.JSON_STATUS_INPUT_ERROR);

            for (FieldError fieldError : result.getFieldErrors()) {
                returnJsonModel.putErrorMessage(fieldError.getField(), fieldError.getDefaultMessage());
            }
        } else {
            // 调用service实现类，插入表
            String status = iRoleManageService.addRole(roleModel);
            // DB处理错误的时候
            if (Constant.STATUS_DB_ERROR.equals(status)) {
                // 设置状态为2：DB处理错误
                returnJsonModel.setStatus(
                        Constant.JSON_STATUS_DB_ERROR);
            } else {
                // 设置状态为正常
                returnJsonModel.setStatus(
                        Constant.JSON_STATUS_OK);
            }
        }

        return returnJsonModel;
    }

    /**
     * 为某一个角色下添加用户时，先得到用户List
     *
     * @param roleId
     * @return model 用户列表
     */
    @RequestMapping(value = "adduser", method = RequestMethod.GET)
    public ModelAndView addUser(@RequestParam(value = "roleId") long roleId) {
        logger.info("addUser:为某一个角色下添加用户 Controller！----开始----");
        ModelAndView model = new ModelAndView();
        // 角色取得
        RoleModel roleInfo = iRoleManageService.getRoleInfo(roleId);

        // 将角色信息提交前台
        model.addObject("roleInfo", roleInfo);
        model.setViewName("um/rolemanage/adduser.base");

        return model;
    }

    /**
     * 添加用户时的用户检索
     *
     * @param userModel
     * @return model
     */
    @RequestMapping(value = "getusers")
    public ModelAndView getUsers(@ModelAttribute("userModel") @Valid UserModel userModel) {
        logger.info("getUsers:加用户时的用户检索 Controller！----开始----");
        ModelAndView model = new ModelAndView();

        // 根据角色ID，取得属于该角色的用户
        List<UserModel> userList = iRoleManageService.getAddUserList(userModel);

        // 角色取得
        RoleModel roleInfo = iRoleManageService.getRoleInfo(userModel.getRoleId());

        // 将用户信息提交前台
        // 员工号
        model.addObject("employeeNo", userModel.getEmployeeNo().replace(
                Constant.STRING_SPACE, Constant.STRING_EMPTY));
        // 用户名
        model.addObject("userName", userModel.getUserName().replace(
                Constant.STRING_SPACE, Constant.STRING_EMPTY));

        String tipsInfo = null;

        // 角色信息
        model.addObject("roleInfo", roleInfo);
        model.addObject("tipsInfo", tipsInfo);
        // 用户List
        model.addObject("userList", userList);
        model.setViewName("um/rolemanage/adduser.base");

        return model;
    }

    /**
     * 用户角色表中添加用户
     *
     * @param addUserModel
     * @return model
     */
    @SystemLog(methodDescription = "用户角色表中添加用户")
    @RequestMapping(value = "saveuserrole", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel saveUserRole(@ModelAttribute("addUserModel") @Valid AddUserModel addUserModel, BindingResult result) {
        logger.info("saveUserRole:用户角色表中添加用户 Controller！----开始----");
        JsonModel jsonModel = new JsonModel();

        // 判断对象是否满足验证
        if (result.hasErrors()) {
            // 设置状态为1：输入验证错误
            jsonModel.setStatus(
                    Constant.JSON_STATUS_INPUT_ERROR);

            for (FieldError fieldError : result.getFieldErrors()) {
                jsonModel.putErrorMessage(fieldError.getField(), fieldError.getDefaultMessage());
            }
        } else {
            // 调用service实现类，插入表
            String status = iRoleManageService.saveUserRole(addUserModel);
            // DB处理错误的时候
            if (Constant.STATUS_DB_ERROR.equals(status)) {
                // 设置状态为2：DB处理错误
                jsonModel.setStatus(
                        Constant.JSON_STATUS_DB_ERROR);
            } else {
                // 设置状态为正常
                jsonModel.setStatus(
                        Constant.JSON_STATUS_OK);
            }
        }

        return jsonModel;
    }

    /**
     * 编辑角色信息
     *
     * @param roleModel
     * @return model
     */
    @SystemLog(methodDescription = "编辑角色信息")
    @RequestMapping(value = "editrole", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel editRole(@ModelAttribute("roleModel") @Valid RoleModel roleModel, BindingResult result) {
        logger.info("editRole:添加角色 Controller！----开始----");
        // 返回值
        JsonModel returnJsonModel = new JsonModel();

        // 判断对象是否满足验证
        if (result.hasErrors()) {
            // 设置状态为1：输入验证错误
            returnJsonModel.setStatus(
                    Constant.JSON_STATUS_INPUT_ERROR);

            for (FieldError fieldError : result.getFieldErrors()) {
                returnJsonModel.putErrorMessage(fieldError.getField(), fieldError.getDefaultMessage());
            }
        } else {
            // 调用service实现类，插入表
            String status = iRoleManageService.editRole(roleModel);
            // DB处理错误的时候
            if (Constant.STATUS_DB_ERROR.equals(status)) {
                // 设置状态为2：DB处理错误
                returnJsonModel.setStatus(
                        Constant.JSON_STATUS_DB_ERROR);
            } else {
                // 设置状态为正常
                returnJsonModel.setStatus(
                        Constant.JSON_STATUS_OK);
            }
        }

        return returnJsonModel;
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return model
     */
    @SystemLog(methodDescription = "删除角色")
    @RequestMapping(value = "deleterole", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel deleteRole(@RequestParam(value = "roleId") long roleId) {
        logger.info("deleteRole:角色删除 Controller！----开始----");
        // 返回值
        JsonModel jsonModel = new JsonModel();

        // 删除角色和此角色所拥有的资源
        String status = iRoleManageService.deleteRole(roleId);
        // DB处理错误的时候
        if (Constant.STATUS_DB_ERROR.equals(status)) {
            // 设置状态为2：DB处理错误
            jsonModel.setStatus(
                    Constant.JSON_STATUS_DB_ERROR);
        } else {
            // 设置状态为正常
            jsonModel.setStatus(
                    Constant.JSON_STATUS_OK);
        }

        return jsonModel;
    }

    /**
     * 角色名是否唯一check
     *
     * @param roleName
     * @return jsonModel
     */
    @RequestMapping(value = "rolenameuniquecheck", method = RequestMethod.POST)
    @ResponseBody
    public JsonModel roleNameUniqueCheck(@RequestParam(value = "roleId") long roleId,
                                         @RequestParam(value = "roleName") String roleName) {
        logger.info("roleNameUniqueCheck:角色名是否唯一check！----开始----");
        // 返回值
        JsonModel jsonModel = new JsonModel();
        // 查询表处理
        String status = iRoleManageService.roleNameUniqueCheck(roleId, roleName);
        if (Constant.DB_EXISTS.equals(status)) {
            // 设置状态为2：DB处理错误
            jsonModel.setStatus(
                    Constant.JSON_STATUS_DB_ERROR);
        } else {
            // 设置状态为正常
            jsonModel.setStatus(
                    Constant.JSON_STATUS_OK);
        }

        return jsonModel;
    }
}
