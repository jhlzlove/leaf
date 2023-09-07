package com.leaf.system.controller;


import com.leaf.system.domain.LeafUser;
import com.leaf.system.service.LeafUserService;
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
    @GetMapping
    @Operation(summary = "用户分页列表", description = "默认分页从 0 开始，每页 10 条数据")
    public Page<LeafUser> listPage(@RequestBody LeafUser leafUser,
                                   @PageableDefault(page = 0, size = 10) Pageable page) {
        return leafUserService.listPage(leafUser, page);
    }

    /**
     * 获取用户登录信息表
     */
    @GetMapping("/{id}")
    @Operation(summary = "根据用户id获取指定用户", description = "默认分页从 0 开始，每页 10 条数据")
    public LeafUser queryById(@PathVariable Long id) {
        return leafUserService.findById(id);
    }

    /**
     * 添加用户登录信息表
     */
    @PostMapping
    @Operation(summary = "添加用户", description = "")
    public void add(@RequestBody LeafUser leafUser) {
        leafUserService.save(leafUser);
    }


    /**
     * 修改用户登录信息表
     */
    @PutMapping
    @Operation(summary = "修改用户", description = "")
    public void edit(@RequestBody LeafUser leafUser) {
        log.info("用户更新");
        leafUserService.update(leafUser);
    }

    /**
     * 删除用户登录信息表
     */
    @DeleteMapping("/{ids}")
    @Operation(summary = "删除用户", description = "")
    public void delete(@PathVariable List<Long> ids) {
        leafUserService.remove(ids);
    }
}

