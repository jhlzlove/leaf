package com.leaf.system.service.impl;

import com.leaf.system.entity.LeafUser;
import com.leaf.system.entity.LoginUser;
import com.leaf.system.repository.LeafUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 认证数据源读取
 *
 * @author jhlz
 * @since 2022/12/23 17:06
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserDetailsPasswordService {
    /**
     * 从数据库获取用户
     *
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LeafUser user = userRepository.findByUsername(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        return new LoginUser(user.getUsername(), user.getPassword());
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        String username = user.getUsername();
        Integer b = userRepository.updatePasswordByUsername(username, newPassword);
        if (b >= 1) {
            LoginUser loginUser = (LoginUser) user;
            loginUser.setPassword(newPassword);
            return loginUser;
        }
        return null;
    }

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final LeafUserRepository userRepository;

    public UserDetailsServiceImpl(LeafUserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
