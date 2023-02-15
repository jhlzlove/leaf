package com.leaf.system.controller;


import com.leaf.system.entity.LeafRole;
import com.leaf.system.service.LeafRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 角色信息表控制层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:31
 */
@RestController
@RequestMapping("/leafRole")
public class LeafRoleController {

    /**
     * 获取角色信息表列表(分页)
     */
    @GetMapping
    public Page<LeafRole> listPage(Pageable page) {
        return null;
    }

    /**
     * 获取角色信息表
     */
    @GetMapping("/{id}")
    public LeafRole queryById(@PathVariable Long id) {
        return leafRoleService.findById(id);
    }

    /**
     * 添加角色信息表
     */
    @PostMapping
    public void add(@RequestBody LeafRole leafRole) {
        leafRoleService.save(leafRole);
    }


    /**
     * 修改角色信息表
     */
    @PutMapping
    public void edit(@RequestBody LeafRole leafRole) {
        leafRoleService.update(leafRole);
    }

    /**
     * 删除角色信息表
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

