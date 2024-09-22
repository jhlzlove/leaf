package com.leaf.resource;


import com.leaf.domain.LeafUser;
import com.leaf.record.PageRecord;
import com.leaf.service.LeafUserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;

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
    public Response page(PageRecord page) {
        return Response.ok(leafUserService.page(page)).build();
    }

    @GET
    @Path("{id}")
    public Response info(@RestPath long id) {
        return Response.ok(leafUserService.getById(id)).build();
    }

    @POST
    public void add(LeafUser leafUser) {
        leafUserService.save(leafUser);
    }

    @PUT
    public void edit(LeafUser leafUser) {
        leafUserService.save(leafUser);
    }

    @DELETE
    public void delete(LeafUser leafUser) {
        leafUserService.save(leafUser);
    }

}

