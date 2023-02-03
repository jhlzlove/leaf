package com.leaves.system.service.impl;

import com.leaves.system.domain.LoginUser;
import com.leaves.system.domain.Role;
import com.leaves.system.domain.User;
import com.leaves.system.domain.UserRole;
import com.leaves.system.repository.UserRepository;
import com.leaves.system.service.RoleService;
import com.leaves.system.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 认证数据源读取
 *
 * @author jhlz
 * @since 2022/12/23 17:06
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    /**
     * 从数据库获取用户
     *
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        // TODO 用户权限信息
        List<UserRole> userRoles =
                userRoleService.listByUserId(user.getId());
        List<Long> roleIds =
                userRoles.stream().map(UserRole::getRoleId).toList();
        List<Role> roleList = new ArrayList<>();
        roleIds.forEach(r -> roleList.add(roleService.queryById(r)));
        List<String> permissionList =
                roleList.stream().map(Role::getRoleCode).toList();

        LoginUser loginUser = new LoginUser();
        loginUser.setUser(user).setPermissions(permissionList);
        return loginUser;
    }

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final RoleService roleService;

    public UserDetailsServiceImpl(UserRepository userRepository, UserRoleService userRoleService, RoleService roleService) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.roleService = roleService;
    }
}
