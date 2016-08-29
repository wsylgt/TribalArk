package com.cn.sys.security.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kris2 on 2016/8/24.
 */
public class LoginSuccessHandler  implements AuthenticationSuccessHandler, InitializingBean {
    /**
     * 日志处理导入
     */
    private static final Log logger = LogFactory.getLog(LoginSuccessHandler.class);
    /**
     * 登陆成功后的默认访问url
     */
    private String defaultTargetUrl;
    /**
     * 是否去指定的地址
     */
    private boolean forwardToDestination = false;
    /**
     * 重定向策略
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 初始化bean的时候执行，执行顺序是afterPropertiesSet 先执行，
     * init-method 后执行,afterPropertiesSet 必须实现 InitializingBean接口
     *
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isEmpty(defaultTargetUrl)) {
            throw new Exception("You must configure defaultTargetUrl");
        }
    }

    /**
     * 登陆成功后要执行的内容
     *
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        // 保存登陆成功后的登陆信息
        this.saveLoginInfo(request, authentication);

        if (this.forwardToDestination) {
            logger.info("Login success,Forwarding to " + this.defaultTargetUrl);

            request.getRequestDispatcher(this.defaultTargetUrl).forward(request, response);
        } else {
            logger.info("Login success,Redirecting to " + this.defaultTargetUrl);

            this.redirectStrategy.sendRedirect(request, response, this.defaultTargetUrl);
        }

    }

    /**
     * 登陆成功后，保存用户信息
     *
     * @param request
     * @param authentication
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void saveLoginInfo(HttpServletRequest request, Authentication authentication) {
        logger.debug("requestAuthority:根据用户Id取得该用户所拥有的资源权限---开始--- userId："
                + "");

//        /** 菜单List做成 --------------------- 开始 --------------------- */
//        // 取得菜单组
//        List<MmMenuGroupManageEntity> menuGroupEntityList = menuGroupRepository.findAll();
//        List<MmMenuGroupManageModel> menuGroupList = new ArrayList<MmMenuGroupManageModel>();
//        // 将Entity复制到Model中
//        for(MmMenuGroupManageEntity menuGroupEntity : menuGroupEntityList){
//            // 将菜单组entity转换成model
//            MmMenuGroupManageModel menuGroup = (MmMenuGroupManageModel) ConvertUtils.entityToModel(
//                    menuGroupEntity, MmMenuGroupManageModel.class);
//            // 根据菜单组ID取得包含的菜单
//            List<MmMenuManageEntity> menuEntityList = menuRepository.findByMenuGroupId(menuGroup.getMenuGroupId());
//
//            // 菜单组对应的菜单list
//            List<MmMenuManageModel> menuList = new ArrayList<MmMenuManageModel>();
//
//            // 将entity转换为model
//            for(MmMenuManageEntity menuEntity : menuEntityList){
//                // 将菜单entity转换成model
//                MmMenuManageModel menuModel = (MmMenuManageModel)ConvertUtils.entityToModel(
//                        menuEntity, MmMenuManageModel.class);
//
//                // 根据菜单ID取得对应的资源
//                List<MmResourcesEntity> resourceEntityList = resourcesRepository.findByAttributionId(menuModel.getMenuId());
//
//                for(MmResourcesEntity resourcesEntity : resourceEntityList){
//                    // 如果资源类型为“1”菜单类型，则取得该条数据
//                    if(Constant.STRING_1.equals(resourcesEntity.getResourceType())){
//                        MmResourcesModel resourcesModel = (MmResourcesModel)ConvertUtils.entityToModel(
//                                resourcesEntity, MmResourcesModel.class);
//                        // 将该菜单对应的资源，放到菜单信息里
//                        menuModel.setResourcesModel(resourcesModel);
//                    }
//                }
//                menuList.add(menuModel);
//            }
//            // 将菜单组对应的菜单项放到菜单组信息中
//            menuGroup.setMenuList(menuList);
//
//            // 将菜单组信息放到菜单组list中
//            menuGroupList.add(menuGroup);
//        }
//        // 将菜单组放到session中
//        request.getSession().setAttribute("menuGroupList", menuGroupList);
//        /** 菜单List做成 --------------------- 结束 --------------------- */
//
//        /** 资源权限List做成 --------------------- 开始 --------------------- */
//
//        // 用户Id取得
//        long userId = contextManage.getUserInfo().getUserDetail().getUserId();
//
//        /** 根据用户Id，取得该用户所拥有的角色 */
//        List<UmUserRoleEntity> roleList =
//                iUmUserRoleRepository.findByUserId(userId);
//        // 取得角色List
//        List<Long> roles = new ArrayList<Long>();
//        for (UmUserRoleEntity userRoleEntity : roleList) {
//            roles.add(userRoleEntity.getRoleId());
//        }
//
//        /** 根据角色Id，查询该用户拥有权限的资源 */
//        List<AmRoleResourceAuthorityEntity> roleResAuthList =
//                iAmRoleResAuthRepository.findByRoleIdInOrderByResourceIdAsc(roles);
//        // 取得已经拥有权限的资源Id
//        List<Long> resources = new ArrayList<Long>();
//        for (AmRoleResourceAuthorityEntity roleResAuth : roleResAuthList) {
//            resources.add(roleResAuth.getResourceId());
//        }
//        // 根据资源Id取得已经拥有权限的资源信息
//        List<MmResourcesEntity> resEntityList =
//                iMmResourcesRepository.findByResourceIdIn(resources);
//
//        /** 取得系统的所有请求资源 */
//        List<MmResourcesEntity> allResList = iMmResourcesRepository.findAll();
//
//        /**
//         * 将已经拥有权限的资源和所有的资源进行整合，
//         * 已经拥有权限的资源设置为enable，
//         * 尚未拥有权限的资源设置为disable
//         */
//        List<ResourceAuthorityModel> resAuthModelList = new ArrayList<ResourceAuthorityModel>();
//
//        // 根据角色Id取得角色为【超级管理员】的用户
//        List<UmRoleEntity> roleEntityList = iUmRoleRepository.findByRoleIdIn(roles);
//        String roleMark = Constant.STRING_EMPTY;
//        // 判断该用户是否为超级管理员
//        for (UmRoleEntity roleEntity : roleEntityList) {
//            if (Constant.ROLE_MANAGER.equals(roleEntity.getRoleMark())) {
//                roleMark = Constant.ROLE_MANAGER;
//            }
//        }
//
//        // 如果该用户为【超级管理员】，则全部资源可用
//        if (Constant.ROLE_MANAGER.equals(roleMark)) {
//            for (MmResourcesEntity allResEntity : allResList) {
//                // 资源权限Model
//                ResourceAuthorityModel resAuthModel = new ResourceAuthorityModel();
//                // 资源Id
//                resAuthModel.setResourceId(allResEntity.getResourceId());
//                // 资源标识
//                resAuthModel.setResourceMark(allResEntity.getResourceMark());
//                // 资源名称
//                resAuthModel.setResourceName(allResEntity.getResourceName());
//                // 请求URL
//                resAuthModel.setResourceUrl(allResEntity.getResourceString());
//                // 权限
//                resAuthModel.setAuthority(Constant.RESOURCE_ENABLE);
//                // 放到要提交的List内
//                resAuthModelList.add(resAuthModel);
//            }
//        } else {
//            // 将所有的资源设定为无权限
//            for (MmResourcesEntity allResEntity : allResList) {
//                // 资源权限Model
//                ResourceAuthorityModel resAuthModel = new ResourceAuthorityModel();
//                // 资源Id
//                resAuthModel.setResourceId(allResEntity.getResourceId());
//                // 资源标识
//                resAuthModel.setResourceMark(allResEntity.getResourceMark());
//                // 资源名称
//                resAuthModel.setResourceName(allResEntity.getResourceName());
//                // 请求URL
//                resAuthModel.setResourceUrl(allResEntity.getResourceString());
//                // 权限
//                resAuthModel.setAuthority(Constant.RESOURCE_DISABLE);
//                // 放到要提交的List内
//                resAuthModelList.add(resAuthModel);
//            }
//
//            // 将已经拥有权限的资源的权限设定为enable
//            for (ResourceAuthorityModel resAuth : resAuthModelList) {
//                // 已经拥有权限的资源循环
//                for (MmResourcesEntity resEntity : resEntityList) {
//                    if (resEntity.getResourceId() == resAuth.getResourceId()) {
//                        // 设定有权限
//                        resAuth.setAuthority(Constant.RESOURCE_ENABLE);
//                    }
//                }
//            }
//        }
//
//        /** 请求权限做成 */
//        List<RequestAuthorityModel> requestAuthorityList = new ArrayList<RequestAuthorityModel>();
//
//        for (ResourceAuthorityModel resAuthModel : resAuthModelList) {
//            RequestAuthorityModel reqAuthModel = new RequestAuthorityModel();
//            // 请求标识
//            reqAuthModel.setResourceUrl(resAuthModel.getResourceMark());
//            // 权限
//            reqAuthModel.setAuthority(resAuthModel.getAuthority());
//
//            requestAuthorityList.add(reqAuthModel);
//        }
//
//        // 将资源是否可用做成Map
//        HashMap<String, String> authorityMap = new HashMap<String, String>();
//
//        // 存到map内
//        for (RequestAuthorityModel requestAuthorityModel : requestAuthorityList) {
//            authorityMap.put(requestAuthorityModel.getResourceUrl(), requestAuthorityModel.getAuthority());
//        }

        // 将请求权限放到session中
        request.getSession().setAttribute("authorityMap", "");
        // 将用户信息放到session中
        request.getSession().setAttribute("userDetail", "");
        /** 资源权限List做成 --------------------- 结束 --------------------- */

    }

    /**
     * 默认请求url的设定
     *
     * @param defaultTargetUrl
     */
    public void setDefaultTargetUrl(String defaultTargetUrl) {
        this.defaultTargetUrl = defaultTargetUrl;
    }

    /**
     * 重定向策略的设定
     *
     * @param forwardToDestination
     */
    public void setForwardToDestination(boolean forwardToDestination) {
        this.forwardToDestination = forwardToDestination;
    }

}
