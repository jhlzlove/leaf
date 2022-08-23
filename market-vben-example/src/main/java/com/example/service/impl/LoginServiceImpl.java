package com.example.service.impl;

import com.example.common.constant.GlobalConstants;
import com.example.domain.LoginUser;
import com.example.domain.SysUser;
import com.example.service.LoginService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author clf
 * @time 2022/8/13 18:01
 * @desc: LoginServiceImpl
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager manager;

    @Override
    public LoginUser login(SysUser user) {
        // Authentication#authenticate 认证
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = manager.authenticate(token);
        // 认证未通过给出提示
        if (ObjectUtils.isEmpty(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        LoginUser userInfo = (LoginUser) authenticate.getPrincipal();
        // 生成 jwt
        Map<String, Object> claims = new HashMap<>();
        claims.put(GlobalConstants.LOGIN_USER_KEY, Instant.now().getEpochSecond());
        String jwtToken = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.RS512, GlobalConstants.JWT_SALT).compact();

        LoginUser loginUser = new LoginUser();
        loginUser.setUser(user);
        loginUser.setToken(jwtToken);
        loginUser.setRoles(Arrays.asList("admin", "super"));
        return loginUser;
    }

    @Autowired
    public LoginServiceImpl(AuthenticationManager manager) {
        this.manager = manager;
    }
}
