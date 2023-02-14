package com.leaf.system.controller;

import com.leaf.common.annotation.OperationLog;
import com.leaf.common.log.BusinessEnum;
import com.leaf.system.domain.User;
import com.leaf.system.service.LoginService;
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
