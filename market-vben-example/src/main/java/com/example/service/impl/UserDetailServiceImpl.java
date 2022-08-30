package com.example.service.impl;

import com.example.common.constant.GlobalConstants;
import com.example.common.exception.CustomerException;
import com.example.domain.SysUser;
import com.example.mapper.SysRoleMapper;
import com.example.mapper.SysUserMapper;
import com.example.mapper.SysUserRoleMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * @author clf
 * @time 2022/8/10 11:29
 * @desc: UserDetailsServiceImpl
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);
    private final SysUserMapper userMapper;
    private final SysUserRoleMapper userRoleMapper;
    private final SysRoleMapper roleMapper;

    @Autowired
    public UserDetailServiceImpl(SysUserMapper userMapper, SysUserRoleMapper userRoleMapper, SysRoleMapper roleMapper) {
        this.userMapper = userMapper;
        this.userRoleMapper = userRoleMapper;
        this.roleMapper = roleMapper;
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
        // 生成 jwt
        Map<String, Object> claims = new HashMap<>();
        claims.put(GlobalConstants.LOGIN_USER_KEY, Instant.now().getEpochSecond());
        String jwtToken = null;
        jwtToken = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, GlobalConstants.JWT_KEY.getBytes()).compact();
        // 2. TODO 权限信息
        sysUser.setToken(jwtToken);
        return sysUser;
    }

    @Transactional(rollbackFor = CustomerException.class)
    public void register(SysUser user) {
        userMapper.insertSelective(user);
    }

    public SysUser getUserInfo(SysUser user) {
        SysUser userInfo = userMapper.selectByPrimaryKey(user.getId());
        return userInfo;
    }
}
