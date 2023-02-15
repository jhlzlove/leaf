package com.leaf.system.controller;


import com.leaf.system.entity.LeafUserRole;
import com.leaf.system.service.LeafUserRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 控制层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:32
 */
@RestController
@RequestMapping("/leafUserRole")
public class LeafUserRoleController {

    /**
     * 获取列表(分页)
     */
    @GetMapping
    public Page<LeafUserRole> listPage(Pageable page) {
        return null;
    }

    /**
     * 获取
     */
    @GetMapping("/{id}")
    public LeafUserRole queryById(@PathVariable Long id) {
        return leafUserRoleService.findById(id);
    }

    /**
     * 添加
     */
    @PostMapping
    public void add(@RequestBody LeafUserRole leafUserRole) {
        leafUserRoleService.save(leafUserRole);
    }


    /**
     * 修改
     */
    @PutMapping
    public void edit(@RequestBody LeafUserRole leafUserRole) {
        leafUserRoleService.update(leafUserRole);
    }

    /**
     * 删除
     */
    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Long> ids) {
        leafUserRoleService.remove(ids);
    }

    private final LeafUserRoleService leafUserRoleService;

    public LeafUserRoleController(LeafUserRoleService leafUserRoleService) {
        this.leafUserRoleService = leafUserRoleService;
    }
}

