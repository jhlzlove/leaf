package com.leaf.controller;


import com.leaf.domain.LeafUser;
import com.leaf.response.Response;
import com.leaf.service.LeafUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户登录信息表控制层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Tag(name = "用户信息", description = "用户信息")
@RestController
@RequestMapping("/user")
public class LeafUserController {
    private static final Logger log = LoggerFactory.getLogger(LeafUserController.class);
    private final LeafUserService leafUserService;

    public LeafUserController(LeafUserService leafUserService) {
        this.leafUserService = leafUserService;
    }

    /**
     * 获取用户登录信息表列表(分页)
     */
    @GetMapping("/list")
    @Operation(summary = "用户分页列表", description = "默认分页从 0 开始，每页 10 条数据")
    public Response listPage(@RequestBody(required = false) LeafUser leafUser,
                             @PageableDefault(page = 0, size = 10) Pageable page) {
        Page<LeafUser> result = leafUserService.listPage(leafUser, page);
        return Response.ok(result);
    }

    /**
     * 获取用户登录信息表
     */
    @GetMapping("/{id}")
    @Operation(summary = "根据用户id获取指定用户")
    public LeafUser queryById(@PathVariable Long id) {
        return leafUserService.findById(id);
    }

    /**
     * 添加用户登录信息表
     */
    @PostMapping
    @Operation(summary = "添加用户", description = "相当于注册用户")
    public void add(@RequestBody LeafUser request) {
        leafUserService.save(request);
    }


    /**
     * 修改用户登录信息表
     */
    @PutMapping
    @Operation(summary = "修改用户", description = "")
    public Response edit(@RequestBody LeafUser leafUser) {
        return leafUserService.update(leafUser);
    }

    /**
     * 删除用户登录信息表
     */
    @DeleteMapping("/{ids}")
    @Operation(summary = "删除用户", description = "非逻辑删除")
    public Response delete(@PathVariable List<Long> ids) {
        leafUserService.remove(ids);
        return Response.ok();
    }
}

