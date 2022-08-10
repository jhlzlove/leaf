package com.market.example.service.impl;

import com.market.example.domain.SysUser;
import com.market.example.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author clf
 * @time 2022/8/10 11:29
 * @desc: UserDetailsServiceImpl
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final SysUserMapper userMapper;

    @Autowired
    public UserDetailServiceImpl(SysUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    public void register(SysUser user) {
        userMapper.insertSelective(user);
    }
}
