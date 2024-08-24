package com.leaf.controller;

import com.leaf.common.response.Response;
import com.leaf.domain.LeafDept;
import com.leaf.service.LeafDeptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/add")
    public Response add(@RequestBody LeafDept dept) {
        int result = leafDeptService.add(dept);
        return Response.ok(result);
    }

    @DeleteMapping("/｛ids｝")
    public Response delete(@PathVariable List<Long> ids) {
        leafDeptService.delete(ids);
        return Response.ok();
    }
}
