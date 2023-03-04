package com.leaf.system.controller;

import com.leaf.common.annotation.OperationLog;
import com.leaf.common.business.BusinessEnum;
import com.leaf.common.response.ResultResponse;
import com.leaf.common.util.JwtUtil;
import com.leaf.system.entity.LeafUser;
import com.leaf.system.service.LoginService;
import org.eclipse.collections.api.factory.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jhlz
 * @since 2022/12/14 19:43:14
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    @OperationLog(operation = BusinessEnum.LOGIN)
    public ResultResponse login(@RequestBody LeafUser user) {
        String token = loginService.login(user);
        log.info("login success! username: {}", JwtUtil.getPayloadClaims(token, "name"));
        return ResultResponse.success(Maps.immutable.of("token", token, "expiredTime",
                JwtUtil.getExpiresAtAsInstant(token)).toImmutable());
    }

    @PostMapping("/register")
    @OperationLog(operation = BusinessEnum.ADD_USER)
    public ResultResponse register(@RequestBody LeafUser user) {
        return ResultResponse.success(loginService.register(user));
    }

    @PostMapping("/logout")
    @OperationLog(operation = BusinessEnum.LOGOUT)
    public ResultResponse logout() {
        loginService.logout();
        return ResultResponse.success();
    }

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

}
