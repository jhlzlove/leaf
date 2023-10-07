package com.leaf.system.controller;

import com.leaf.common.annotation.LeafLog;
import com.leaf.common.business.BusinessEnum;
import com.leaf.common.response.Response;
import com.leaf.system.domain.record.LoginUserRecord;
import com.leaf.system.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jhlz
 * @since 2022/12/14 19:43:14
 */
@Tag(name = "账户登录注册模块", description = "包括用户注册、登录、获取用户信息")
@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @Operation(summary = "登录", description = "用户登录，获取 Token")
    @PostMapping("/login")
    @LeafLog(operation = BusinessEnum.LOGIN)
    public Response login(@RequestBody LoginUserRecord user) {
        return loginService.login(user);
    }

    @Operation(summary = "注册")
    @PostMapping("/register")
    @LeafLog(operation = BusinessEnum.ADD_USER)
    public Response register(@RequestBody LoginUserRecord user) {
        return loginService.register(user);
    }

}
