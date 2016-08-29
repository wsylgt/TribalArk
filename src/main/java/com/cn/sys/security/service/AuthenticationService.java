package com.cn.sys.security.service;

import com.cn.content.Constant;
import com.cn.dao.entity.UmRoleEntity;
import com.cn.dao.entity.UmUserEntity;
import com.cn.dao.entity.UmUserRoleEntity;
import com.cn.dao.repositorys.UmRoleRepository;
import com.cn.dao.repositorys.UmUserRepository;
import com.cn.dao.repositorys.UmUserRoleRepository;
import com.cn.sys.security.model.SecurityUser;
import com.cn.sys.security.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kris2 on 2016/8/24.
 */
@Service
@Transactional
public class AuthenticationService implements UserDetailsService {
    /** 日志处理导入 */
    private static final Log logger = LogFactory.getLog(AuthenticationService.class);

    /** 用户管理表DAO */
    @Resource
    private UmUserRepository userRepository;
    /** 角色管理表DAO */
    @Resource
    private UmRoleRepository roleRepository;
    /** 用户角色管理表DAO */
    @Resource
    private UmUserRoleRepository userRoleRepository;

    /**
     * 用户名密码取得DB验证
     *
     * @param userName
     * @return securityUser
     * @throws UsernameNotFoundException
     * @throws DataAccessException
     */
    public SecurityUser loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
        logger.debug("login userName is " + userName);

        // 读取用户
        UmUserEntity dbUser = userRepository.findByUserName(userName);

        // 用户是否可用
        boolean userEnabled = false;
        if(Constant.USER_STATUS_CODE_ID_NORMAL.equals(dbUser.getUserStatusCodeId())){
            userEnabled = true;
        }

        /**
         * String username 用户名
         * String password 密码
         * boolean enabled 是否被禁用,禁用的用户不能身份验证
         * boolean accountNonExpired 账户是否过期,过期无法验证
         * boolean credentialsNonExpired 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
         * boolean accountNonLocked 指定用户是否被锁定或者解锁,锁定的用户无法进行身份验证
         * Collection<? extends GrantedAuthority> authorities 用户拥有的权限（角色）
         */
        // 权限
        Set<GrantedAuthority> auths = loadUserAuthorities(dbUser.getUserId());
        User sUser = new User(dbUser.getUserName(), dbUser.getPassword(), userEnabled, true, true, true, auths);

        SecurityUser securityUser = new SecurityUser(sUser);
        securityUser.setUser(sUser);

        return securityUser;
    }

    /**
     * 根据用户名获取到用户的权限并封装成GrantedAuthority集合
     *
     * @param userid
     * @return auths 权限
     */
    public Set<GrantedAuthority> loadUserAuthorities(long userid) {
        // 读取权限
        Set<GrantedAuthority> auths = new HashSet<>();

        // 用户角色
        List<UmUserRoleEntity> userRolesEntity = userRoleRepository.findByUserId(userid);

        // 角色
        List<UmRoleEntity> roles = roleRepository.findAll();

        for (UmUserRoleEntity userRole : userRolesEntity) {
            for (UmRoleEntity role : roles) {
                if (role.getRoleId() == userRole.getRoleId()) {
                    auths.add(new SimpleGrantedAuthority(role.getRoleMark()));
                }
            }
        }

        return auths;
    }

}
