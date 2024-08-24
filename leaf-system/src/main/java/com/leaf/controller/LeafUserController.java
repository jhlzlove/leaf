package com.leaf.controller;


import com.leaf.common.response.Response;
import com.leaf.domain.LeafUser;
import com.leaf.service.LeafUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户登录信息表控制层
 *
 * @author jhlz
 * @version 1.0.0
 */
@RestController
@RequestMapping("/user")
public class LeafUserController {
    private static final Logger log = LoggerFactory.getLogger(LeafUserController.class);
    private final LeafUserService leafUserService;

    public LeafUserController(LeafUserService leafUserService) {
        this.leafUserService = leafUserService;
    }

    /**
     * 用户分页列表，默认分页从 0 开始，每页 10 条数据
     *
     * @param leafUser
     * @param page
     * @return
     */
    @GetMapping("/list")
    public Response page(@RequestBody(required = false) LeafUser leafUser,
                         @PageableDefault(page = 0, size = 10) Pageable page) {
        return Response.ok(leafUserService.page(leafUser, page));
    }

    /**
     * 获取用户登录信息表
     */
    @GetMapping("/{id}")
    public LeafUser queryById(@PathVariable("id") Long id) {
        return leafUserService.getUserById(id);
    }

    /**
     * 添加用户登录信息表
     */
    @PostMapping
    public void add(@RequestBody LeafUser request) {
        leafUserService.add(request);
    }

    /**
     * 修改用户登录信息表
     */
    @PutMapping
    public Response update(@RequestBody LeafUser leafUser) {
        return leafUserService.update(leafUser);
    }

    /**
     * 删除用户登录信息表
     */
    @DeleteMapping("/{ids}")
    public Response delete(@PathVariable List<Long> ids) {
        leafUserService.delete(ids);
        return Response.ok();
    }
}

