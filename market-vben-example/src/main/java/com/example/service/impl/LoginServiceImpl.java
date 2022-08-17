package com.market.example.service.impl;

import com.market.example.domain.LoginUser;
import com.market.example.domain.SysUser;
import com.market.example.service.LoginService;
import com.market.example.utils.ResResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author clf
 * @time 2022/8/13 18:01
 * @desc: LoginServiceImpl
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager manager;

    @Autowired
    public LoginServiceImpl(AuthenticationManager manager) {
        this.manager = manager;
    }

    @Override
    public ResResult login(SysUser user) {
        // Authentication#authenticate 认证
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = manager.authenticate(token);
        // 认证未通过给出提示
        if (ObjectUtils.isEmpty(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        // 认证通过根据 userId 生成 jwt
        LoginUser userInfo = (LoginUser) authenticate.getPrincipal();
        String userId = userInfo.getUser().getId().toString();
        // TODO 生成 jwt
        // 完整的用户信息存入 redis
        return ResResult.success(userInfo.getUser());
    }
}
