package com.leaf.controller;

import com.leaf.common.response.Response;
import com.leaf.domain.LeafUser;
import com.leaf.service.LoginService;
import com.leaf.service.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Tag(name = "login", description = "include user login、register and get user detail")
@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private final LoginService loginService;
    private final RegisterService registerService;

    public LoginController(LoginService loginService, RegisterService registerService) {
        this.loginService = loginService;
        this.registerService = registerService;
    }

    @Operation(summary = "login", description = "用户登录，获取 Token")
    @PostMapping("/login")
    public Response login(@RequestBody LeafUser user) {
        return loginService.login(user);
    }

    @Operation(summary = "register")
    @PostMapping("/register")
    public Response register(@RequestBody LeafUser user) {
        return Response.ok(registerService.register(user));
    }

}
