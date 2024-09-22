package com.leaf.resource;

import com.leaf.domain.LeafUser;
import com.leaf.service.LeafUserService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 * 登录、注册模块
 *
 * @author jhlz
 * @version 1.0.0
 */
@Path("/")
public class LoginResource {
    private final LeafUserService leafUserService;

    public LoginResource(LeafUserService leafUserService) {
        this.leafUserService = leafUserService;
    }

    @POST
    @Path("/login")
    public Response login(LeafUser leafUser) {
        leafUserService.login(leafUser);
        return Response.ok().build();
    }

    @POST
    @Path("/register")
    public Response register(LeafUser leafUser) {
        leafUserService.login(leafUser);
        return Response.ok().build();
    }

    @POST
    @Path("/logout")
    public Response logout() {
        System.out.println("user logged out");
        return Response.ok().build();
    }
}
