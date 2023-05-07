package com.leaf.system.controller;


import com.leaf.system.domain.LeafRole;
import com.leaf.system.service.LeafRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色表控制层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@RestController
@RequestMapping("/leafRole")
public class LeafRoleController {

    /**
     * 获取角色表列表(分页)
     */
    @GetMapping
    public Page<LeafRole> listPage(@RequestBody LeafRole leafRole,
                                   @PageableDefault(page = 0, size = 10) Pageable page) {
        return null;
    }

    /**
     * 获取角色表
     */
    @GetMapping("/{id}")
    public LeafRole queryById(@PathVariable Long id) {
        return leafRoleService.findById(id);
    }

    /**
     * 添加角色表
     */
    @PostMapping
    public void add(@RequestBody LeafRole leafRole) {
        leafRoleService.save(leafRole);
    }


    /**
     * 修改角色表
     */
    @PutMapping
    public void edit(@RequestBody LeafRole leafRole) {
        leafRoleService.update(leafRole);
    }

    /**
     * 删除角色表
     */
    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Long> ids) {
        leafRoleService.remove(ids);
    }

    private final LeafRoleService leafRoleService;

    public LeafRoleController(LeafRoleService leafRoleService) {
        this.leafRoleService = leafRoleService;
    }
}

