package com.example.service.impl;

import com.example.common.constant.GlobalConstants;
import com.example.common.exception.CustomerException;
import com.example.domain.SysUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 查询用户
        // SysUser sysUser = userMapper.loadByUserName(username);
        // if (ObjectUtils.isEmpty(sysUser)) {
        //     throw new UsernameNotFoundException("用户名不存在哦，请检查输入是否正确");
        // }
        // 生成 jwt
        Map<String, Object> claims = new HashMap<>();
        claims.put(GlobalConstants.LOGIN_USER_KEY, Instant.now().getEpochSecond());
        String jwtToken = null;
        jwtToken = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, GlobalConstants.JWT_KEY.getBytes()).compact();
        // 2. TODO 权限信息
        // sysUser.setToken(jwtToken);
        return null;
    }

    @Transactional(rollbackFor = CustomerException.class)
    public void register(SysUser user) {
    }

    public SysUser getUserInfo(SysUser user) {
        return null;
    }
}
