package com.cn.sys.usermanage.service;

import com.cn.sys.usermanage.model.ResetPasswordModel;
import com.cn.sys.usermanage.model.RoleModel;
import com.cn.sys.usermanage.model.UserEditModel;
import com.cn.sys.usermanage.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

/**
 * Created by kris on 2016/8/23.
 */
@Transactional
public interface IUserManageService {

    /**
     * 获取所有用户信息列表, 包含搜索,并且分页
     * @param pageNumber: 页号
     * @param pageSize: 每页显示的条数
     * @param employeeNo: 员工号
     * @param userName: 用户名
     * @param roleId: 角色ID
     * @param isDelete: 是否删除,0: 否   1: 是
     * @return Page
     */
    public Page<UserModel> allUser(int pageNumber, int pageSize, String employeeNo,
                                   String userName, Long roleId, String isDelete);

    /**
     * 获取所有角色
     * @return List
     */
    public List<RoleModel> allRole();

    /**
     * 添加一个用户
     * @param userModel: UserModel对象
     * @return String
     */
    public String saveUser(UserModel userModel);

    /**
     * 编辑用户信息
     * @param model: UserEditModel对象
     * @return String
     */
    public String editUser(UserEditModel model);

    /**
     * 根据用户ID查询用的详细信息
     * @param userId: 用户ID
     * @return UserModel
     */
    public UserModel findByUserId(Long userId);

    /**
     * 根据用户ID冻结用户账户
     * @param userId: 用户ID
     * @return String
     */
    public String freezeAccount(Long userId);

    /**
     * 根据用户ID恢复用户账户
     * @param userId: 用户ID
     * @return String
     */
    public String recoveryAccount(Long userId);

    /**
     * 根据用户ID删除一个用户,逻辑删除,更改状态
     * @param userId: 用户ID
     * @return String
     */
    public String deleteUser(Long userId);

    /**
     * 根据用户ID恢复删除的用户
     * @param userId: 用户ID
     * @return String
     */
    public String recoveryUser(Long userId);

    /**
     * 重置后台用户密码
     * @param model: ResetPasswordModel对象
     * @return String
     */
    public String resetPassword(ResetPasswordModel model);

    /**
     * 查询用户名、工号，手机号，是否已经存在
     * @param userName: 用户名
     * @param employeeNo: 工号
     * @param cellphoneNo: 手机号
     * @return String
     */
    public String isExist(String userName, String employeeNo, String cellphoneNo);

}
