package com.leaf.system.service.impl;

import com.leaf.common.util.JwtUtil;
import com.leaf.common.util.SecurityUtil;
import com.leaf.system.entity.LeafUser;
import com.leaf.system.entity.LoginUser;
import com.leaf.system.service.LeafUserService;
import com.leaf.system.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 登录接口实现
 *
 * @author jhlz
 * @since 2022/12/20 21:32
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public String login(LeafUser user) {
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        // 调用认证方法
        Authentication authenticate = authenticationManager.authenticate(authentication);
        if (Objects.isNull(authenticate)) {
            throw new UsernameNotFoundException("Not found user");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Map<String, Object> payload = new HashMap<String, Object>(3);
        payload.put("name", loginUser.getUsername());
        // 生成 token
        String token = JwtUtil.createToken(payload);
        log.info("token is {}", token);
        return token;
    }

    @Override
    public void logout() {
        SecurityUtil.clear();
    }

    @Override
    public LeafUser register(LeafUser user) {
        Assert.notNull(user, "LeafUser must be not null!");
        Assert.notNull(user.getPassword(), "password must be not null!");
        Assert.isTrue(StringUtils.containsWhitespace(user.getUsername()), "username must be not contains whitespace!");

        return userService.save(user);
    }

    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    private final AuthenticationManager authenticationManager;
    private final LeafUserService userService;

    public LoginServiceImpl(AuthenticationManager authenticationManager, LeafUserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

}
