package com.example.system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jhlz
 * @since: 2022/12/14 19:43:14
 */
@RestController
public class LoginController {

    @PostMapping("login")
    public void login(String userName, String password) {

    }

    @PostMapping("logout")
    public void logout(String userName, String password) {

    }
}
