package com.leaf.system.resource;

import com.leaf.common.record.R;
import com.leaf.framework.annotation.Log;
import com.leaf.system.domain.LeafUser;
import com.leaf.system.domain.LeafUserTable;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;
import org.jboss.resteasy.reactive.RestPath;
import org.jetbrains.annotations.NotNull;

/**
 * 系统测试 controller
 *
 * @author jhlz
 * @version 1.0.0
 */
@Path("/test")
public class TestResource {
    private final JSqlClient sqlClient;

    @Inject
    public TestResource(JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    @GET
    @Log
    @Path("/simple")
    public String simpleTest() {
        // System.out.println(page);
        return "测试是否正常 working！";
    }

    @GET
    @Log
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User test1(@Context SecurityContext securityContext) {
        if (securityContext.getUserPrincipal() == null) {
            return new User("诗酒趁年华", 20);
        }
        System.out.println(securityContext.getUserPrincipal().getName());
        return new User("jhlz", 20);
    }
    record User(String name, int age) {}


    @GET
    @Log
    @Path("/users")
    public Page<LeafUser> getUsers() {
        LeafUserTable userTable = LeafUserTable.$;
        @NotNull Page<LeafUser> list = sqlClient.createQuery(userTable)
                .select(userTable)
                .fetchPage(0, 3);
        System.out.println("啊，我累了111222");
        return list;
    }

    @GET
    @Path("/users/{id}")
    public R getUsers(@RestPath("id") Long id) {
        LeafUser user = sqlClient.findById(LeafUser.class, id);
        return R.ok(user);
    }
}
