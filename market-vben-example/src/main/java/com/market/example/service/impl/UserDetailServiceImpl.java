package com.market.example.service.impl;

import com.market.example.domain.CustomerUserDetails;
import com.market.example.domain.SysUser;
import com.market.example.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * @author clf
 * @time 2022/8/10 11:29
 * @desc: UserDetailsServiceImpl
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService, UserDetailsPasswordService {

    private final SysUserMapper userMapper;

    @Autowired
    public UserDetailServiceImpl(SysUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 查询用户
        SysUser sysUser = userMapper.loadByUserName(username);
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new UsernameNotFoundException("用户名不存在哦，请检查输入是否正确");
        }
        // 2. TODO 权限信息

        return new CustomerUserDetails(sysUser);
    }

    @Transactional(rollbackFor = Exception.class)
    public void register(SysUser user) {
        userMapper.insertSelective(user);
    }

    /**
     * 默认使用相对安全的密码加密 DelegatingPasswordEncoder
     *
     * @param user        the user to modify the password for
     * @param newPassword the password to change to, encoded by the configured
     *                    {@code PasswordEncoder}
     * @return
     */
    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        Integer result = userMapper.updatePassword(user.getUsername(), newPassword);
        if (result == 1) {
            ((SysUser) user).setPassword(newPassword);
        }
        return user;
    }
}
