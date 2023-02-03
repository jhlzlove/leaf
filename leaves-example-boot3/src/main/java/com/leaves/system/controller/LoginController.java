package com.leaves.system.controller;

import com.leaves.common.annotation.OperationLog;
import com.leaves.common.log.BusinessEnum;
import com.leaves.system.domain.User;
import com.leaves.system.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jhlz
 * @since: 2022/12/14 19:43:14
 */
@RestController
public class LoginController {

    @PostMapping("login")
    @OperationLog(operation = BusinessEnum.LOGIN)
    public String login(@RequestBody User user) {
        return loginService.login(user);
    }

    @PostMapping("logout")
    @OperationLog(operation = BusinessEnum.LOGOUT)
    public void logout() {
        loginService.logout();
    }

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

}
