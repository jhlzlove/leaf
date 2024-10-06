package com.leaf.resource;

import com.leaf.domain.LeafUser;
import com.leaf.service.LoginService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

/**
 * 登录、注册模块
 *
 * @author jhlz
 * @version 1.0.0
 */
@Path("/")
public class LoginResource {
    private final LoginService loginService;

    public LoginResource(LoginService loginService) {
        this.loginService = loginService;
    }

    @GET
    @Path("/login")
    public String login(LeafUser leafUser) {
       return loginService.login(leafUser);
    }

    @GET
    @Path("/userInfo")
    public LeafUser userInfo() {
        return loginService.userInfo();
    }

    @POST
    @Path("/register")
    public void register(LeafUser leafUser) {
        loginService.register(leafUser);
    }

    @POST
    @Path("/logout")
    public String logout() {
        return "logout";
    }
}
