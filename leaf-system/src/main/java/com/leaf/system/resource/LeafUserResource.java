package com.leaf.system.resource;


import com.leaf.framework.record.PageRecord;
import com.leaf.framework.annotation.Log;
import com.leaf.system.domain.LeafUser;
import com.leaf.system.service.LeafUserService;
import jakarta.ws.rs.*;
import org.babyfish.jimmer.Page;

import java.util.List;

/**
 * 用户登录信息表控制层
 *
 * @author jhlz
 * @version 1.0.0
 */
@Path("/user")
public class LeafUserResource {

    private final LeafUserService leafUserService;

    public LeafUserResource(LeafUserService leafUserService) {
        this.leafUserService = leafUserService;
    }

    @GET
    @Path("/page")
    public Page<LeafUser> page(@BeanParam PageRecord page) {
        return leafUserService.page(page);
    }

    @GET
    @Log(module = "根据用户 id 获取用户详情")
    @Path("{id}")
    public LeafUser info(@PathParam("id") long id) {
        System.out.printf("新的 id" + id);
        return leafUserService.getById(id);
    }

    @POST
    public void add(LeafUser leafUser) {
        leafUserService.add(leafUser);
    }

    @PUT
    public void update(LeafUser leafUser) {
        leafUserService.update(leafUser);
    }

    @DELETE
    @Path("{ids}")
    public void deleteByIds(@PathParam("ids") List<Long> ids) {
        leafUserService.delete(ids);
    }

}

