package com.example.service.impl;

import com.example.common.constant.GlobalConstants;
import com.example.domain.SysUser;
import com.example.service.LoginService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author jhlz
 * @time 2022/9/1 12:57
 * @desc: LoginServiceImpl
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public SysUser login(SysUser user) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), null);
        // 认证
        Authentication authenticate = authenticationManager.authenticate(token);
        // 获取用户
        SysUser loginUser = null;
        if (Objects.nonNull(authenticate)) {
            loginUser = (SysUser) authenticate.getPrincipal();
        }
        // 生成 jwt
        Map<String, Object> claims = new HashMap<>();
        claims.put(GlobalConstants.LOGIN_USER_KEY, Instant.now().getEpochSecond());
        String jwtToken = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, GlobalConstants.JWT_KEY.getBytes()).compact();
        // 设置 token
        loginUser.setToken(jwtToken);
        return loginUser;
    }

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    private final AuthenticationManager authenticationManager;

    public LoginServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
}
