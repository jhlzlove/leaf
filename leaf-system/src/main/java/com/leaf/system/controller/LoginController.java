package com.leaf.system.controller;

import com.leaf.common.annotation.LeafLog;
import com.leaf.common.business.BusinessEnum;
import com.leaf.common.constant.LeafConstants;
import com.leaf.common.response.Response;
import com.leaf.common.util.JwtUtil;
import com.leaf.system.domain.LeafUser;
import com.leaf.system.domain.record.LoginUserRecord;
import com.leaf.system.service.LeafUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jhlz
 * @since 2022/12/14 19:43:14
 */
@Tag(name = "账户登录注册模块", description = "包括用户注册、登录、获取用户信息")
@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private final LeafUserService userService;

    public LoginController(LeafUserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "登录", description = "用户登录，获取 Token")
    @PostMapping("/login")
    @LeafLog(operation = BusinessEnum.LOGIN)
    public Response login(@RequestBody LoginUserRecord user) {
        String token = userService.login(user);
        log.info("username: {} login success! ", JwtUtil.getPayloadClaims(token, LeafConstants.LOGIN_JWT_NAME_KEY));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", token);
        map.put("expiredTime", JwtUtil.getExpiresAtAsInstant(token));
        return Response.success(map);
    }

    @Operation(summary = "注册")
    @PostMapping("/register")
    @LeafLog(operation = BusinessEnum.ADD_USER)
    public Response register(@RequestBody LeafUser user) {
        log.info("注册信息");
        return Response.success(userService.save(user));
    }

}
