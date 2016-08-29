package com.cn.sys.security.service;

import com.cn.dao.entity.AmRoleResourceAuthorityEntity;
import com.cn.dao.entity.MmResourcesEntity;
import com.cn.dao.entity.UmRoleEntity;
import com.cn.dao.repositorys.AmRoleResourceAuthorityRepository;
import com.cn.dao.repositorys.MmResourcesRepository;
import com.cn.dao.repositorys.UmRoleRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.annotation.Resource;
import java.util.*;

/**
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。
 * 注意，我例子中使用的是AntUrlPathMatcher这个path matcher来检查URL是否与资源定义匹配，
 * 事实上你还要用正则的方式来匹配，或者自己实现一个matcher。
 *
 * 此类在初始化时，应该取到所有资源及其对应角色的定义
 *
 * 说明：对于方法的spring注入，只能在方法和成员变量里注入，
 * 如果一个类要进行实例化的时候，不能注入对象和操作对象，
 * 所以在构造函数里不能进行操作注入的数据。
 *
 */
@Service
public class MetadataSourceService implements FilterInvocationSecurityMetadataSource {
    /** 日志处理导入 */
    protected final Log logger = LogFactory.getLog(getClass());

    /** 角色表DAO */
    @Resource
    private UmRoleRepository roleRepository;
    /** 角色资源权限表DAO */
    @Resource
    private AmRoleResourceAuthorityRepository roleResourceAuthorityRepository;
    /** 资源表DAO */
    @Resource
    private MmResourcesRepository resourcesRepository;

    /**
     * 构造方法
     *
     * @param
     */
    public MetadataSourceService() {
    }

    /**
     * 提供某个资源对应的权限定义
     *
     * @return attributes
     */
    public List<ConfigAttribute> getAttributes(Object object) {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        List<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();

        attributes = loadResourceDefine(url);

        return attributes;
    }

    /**
     * 取得所有的资源
     * @return allAttributes 所有资源
     */
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

        // 读取所有资源
        List<MmResourcesEntity> resourcesEntitys = resourcesRepository.findAll();
        List<Long> resourceId = new ArrayList<>();
        for (MmResourcesEntity resource:resourcesEntitys) {
            resourceId.add(resource.getResourceId());
        }
        // 读取所有的资源,和资源相关联的的权限
        List<AmRoleResourceAuthorityEntity> roleResourceAuthorityList=
                roleResourceAuthorityRepository.findByRoleIdInOrderByResourceIdAsc(resourceId);
        List<Long> roleId = new ArrayList<>();
        for (AmRoleResourceAuthorityEntity roleResourceAuthority : roleResourceAuthorityList) {
            roleId.add(roleResourceAuthority.getRoleId());
        }

        List<UmRoleEntity> roles = roleRepository.findByRoleIdIn(roleId);
        for (UmRoleEntity role : roles) {
            String authString = role.getRoleMark();
            SecurityConfig attrConfig = new SecurityConfig(authString);
            allAttributes.add(attrConfig);
        }

        return allAttributes;
    }

    /**
     * 决定AccessDecisionManager是否可以执行传递ConfigAttribute
     *
     * @return true
     */
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    /**
     * 请求URL与数据库中的URL是否匹配
     * @param url
     * @return attributes
     */
    private List<ConfigAttribute> loadResourceDefine(String url) {
        logger.debug("init SecurityMetadataSource load all resources");

        List<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();

        // url匹配算法
        PathMatcher urlMatcher = new AntPathMatcher();

        // 读取所有资源
        List<MmResourcesEntity> resourcesEntitys = resourcesRepository.findAll();
        List<Long> resourceId = new ArrayList<>();
        for (MmResourcesEntity resource:resourcesEntitys) {
            // 请求URL与数据库中的URL进行匹配
            boolean result = urlMatcher.match(resource.getResourceString(), url);
            if(result){
                resourceId.add(resource.getResourceId());
            }
        }
        // 读取所有的资源,和资源相关联的的权限
        List<AmRoleResourceAuthorityEntity> roleResourceAuthorityList= roleResourceAuthorityRepository.findByResourceIdIn(resourceId);
        List<Long> roleId = new ArrayList<>();
        for (AmRoleResourceAuthorityEntity roleResourceAuthority : roleResourceAuthorityList) {
            roleId.add(roleResourceAuthority.getRoleId());
        }

        List<UmRoleEntity> roles = roleRepository.findByRoleIdIn(roleId);
        for (UmRoleEntity role : roles) {
            String authString = role.getRoleMark();
            SecurityConfig attrConfig = new SecurityConfig(authString);
            attributes.add(attrConfig);
        }

        if (attributes.size() < 1) {
            String authString = "ROLE_XXXX";
            SecurityConfig attrConfig = new SecurityConfig(authString);
            attributes.add(attrConfig);
        }

        return attributes;

    }

}
