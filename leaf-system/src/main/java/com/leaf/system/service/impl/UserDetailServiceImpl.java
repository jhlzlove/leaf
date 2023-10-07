package com.leaf.system.service.impl;

import com.leaf.system.domain.LeafUser;
import com.leaf.system.domain.LoginUser;
import com.leaf.system.repository.LeafUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Spring Security UserDetailService、UserDetailsPasswordService 的实现类
 * 两个接口分别负责登录认证、密码加密方式的自动更新
 *
 * @author jhlz
 * @version 1.0.0
 * @since 2023/10/3 17:18
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService, UserDetailsPasswordService {

    private final LeafUserRepository leafUserRepository;

    public UserDetailServiceImpl(LeafUserRepository leafUserRepository) {
        this.leafUserRepository = leafUserRepository;
    }

    /**
     * 自动更新 PasswordEncoder 加密方式
     *
     * @param user        the user to modify the password for
     * @param newPassword the password to change to, encoded by the configured
     *                    {@code PasswordEncoder}
     * @return UserDetails 实现
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        int b = leafUserRepository.updatePasswordByUsername(user.getUsername(), newPassword);
        if (b > 0) ((LeafUser) user).setPassword(newPassword);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LeafUser user = leafUserRepository.findByUsername(username);
        return new LoginUser(user, List.of("admin"));
    }
}
