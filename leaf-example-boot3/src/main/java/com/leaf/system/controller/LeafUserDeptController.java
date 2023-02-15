package com.leaf.system.controller;


import com.leaf.system.entity.LeafUserDept;
import com.leaf.system.service.LeafUserDeptService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 用户部门关联表控制层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:32
 */
@RestController
@RequestMapping("/leafUserDept")
public class LeafUserDeptController {

    /**
     * 获取用户部门关联表列表(分页)
     */
    @GetMapping
    public Page<LeafUserDept> listPage(Pageable page) {
        return null;
    }

    /**
     * 获取用户部门关联表
     */
    @GetMapping("/{id}")
    public LeafUserDept queryById(@PathVariable Long id) {
        return leafUserDeptService.findById(id);
    }

    /**
     * 添加用户部门关联表
     */
    @PostMapping
    public void add(@RequestBody LeafUserDept leafUserDept) {
        leafUserDeptService.save(leafUserDept);
    }


    /**
     * 修改用户部门关联表
     */
    @PutMapping
    public void edit(@RequestBody LeafUserDept leafUserDept) {
        leafUserDeptService.update(leafUserDept);
    }

    /**
     * 删除用户部门关联表
     */
    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Long> ids) {
        leafUserDeptService.remove(ids);
    }

    private final LeafUserDeptService leafUserDeptService;

    public LeafUserDeptController(LeafUserDeptService leafUserDeptService) {
        this.leafUserDeptService = leafUserDeptService;
    }
}

