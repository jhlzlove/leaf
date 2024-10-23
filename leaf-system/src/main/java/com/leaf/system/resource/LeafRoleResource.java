package com.leaf.system.resource;

import com.leaf.system.domain.LeafRole;
import com.leaf.common.record.PageRecord;
import com.leaf.system.service.LeafRoleService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.babyfish.jimmer.Page;
import org.jboss.resteasy.reactive.RestPath;

/**
 * 角色信息管理
 * @author jhlz
 * @version 1.0.0
 */
@Path("/role")
public class LeafRoleResource {
    private final LeafRoleService leafRoleService;

    public LeafRoleResource(LeafRoleService leafRoleService) {
        this.leafRoleService = leafRoleService;
    }

    @GET
    @Path("page")
    public Page<LeafRole> page( PageRecord page) {
        return leafRoleService.findAll(page);
    }

    @GET
    @Path("{id}")
    public Response info(@RestPath long id) {
        LeafRole role = leafRoleService.findById(id);
        return Response.ok(role).build();
    }

    @POST
    public Response add(LeafRole role) {
        return Response.ok(leafRoleService.save(role)).build();
    }

    @PUT
    public Response update(LeafRole role) {
        return Response.ok(leafRoleService.save(role)).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@RestPath long id) {
        LeafRole role = leafRoleService.findById(id);
        return Response.ok(role).build();
    }
}
