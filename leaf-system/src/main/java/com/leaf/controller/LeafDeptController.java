package com.leaf.controller;

import com.leaf.common.response.Response;
import com.leaf.domain.LeafDept;
import com.leaf.service.LeafDeptService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jhlz
 * @version x.x.x
 */
@RestController
@RequestMapping("/dept")
public class LeafDeptController {

    private final LeafDeptService leafDeptService;

    public LeafDeptController(LeafDeptService leafDeptService) {
        this.leafDeptService = leafDeptService;
    }

    @PostMapping
    public Response addDept(@RequestBody LeafDept dept) {
        LeafDept result = leafDeptService.add(dept);
        return Response.ok(result);
    }
}
