package com.leaf.system.controller;


import com.leaf.common.response.Response;
import com.leaf.system.entity.LeafUser;
import com.leaf.system.service.LeafUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 用户信息表控制层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:31
 */
@RestController
@RequestMapping("/user")
public class LeafUserController {

    /**
     * 获取用户信息表列表(分页)
     */
    @GetMapping
    public Response listPage(@RequestBody(required = false) LeafUser user,
                             @PageableDefault(page = 0, size = 20) Pageable page) {
        return Response.success(leafUserService.listPage(user, page));
    }

    /**
     * 获取用户信息表
     */
    @GetMapping("/{id}")
    public LeafUser queryById(@PathVariable Long id) {
        log.info("id {}", id);
        LeafUser byId = leafUserService.findById(id);
        System.out.println(byId);
        return byId;

    }

    /**
     * 添加用户信息表
     */
    @PostMapping
    public void add(@RequestBody LeafUser leafUser) {
        leafUserService.save(leafUser);
    }


    /**
     * 修改用户信息表
     */
    @PutMapping
    public void edit(@RequestBody LeafUser leafUser) {
        leafUserService.update(leafUser);
    }

    /**
     * 删除用户信息表
     */
    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Long> ids) {
        leafUserService.remove(ids);
    }

    private static final Logger log = LoggerFactory.getLogger(LeafUserController.class);
    private final LeafUserService leafUserService;

    public LeafUserController(LeafUserService leafUserService) {
        this.leafUserService = leafUserService;
    }
}

