package com.leaf.system.controller;


import java.lang.Long;

import com.leaf.system.entity.LeafDept;
import com.leaf.system.service.LeafDeptService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门表控制层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:02
 */
@RestController
@RequestMapping("/leafDept")
public class LeafDeptController {

    /**
     * 获取部门表列表(分页)
     */
    @GetMapping
    public Page<LeafDept> listPage(@RequestBody LeafDept leafDept,
                                   @PageableDefault(page = 0, size = 10) Pageable page) {
        return null;
    }

    /**
     * 获取部门表
     */
    @GetMapping("/{id}")
    public LeafDept queryById(@PathVariable Long id) {
        return leafDeptService.findById(id);
    }

    /**
     * 添加部门表
     */
    @PostMapping
    public void add(@RequestBody LeafDept leafDept) {
        leafDeptService.save(leafDept);
    }


    /**
     * 修改部门表
     */
    @PutMapping
    public void edit(@RequestBody LeafDept leafDept) {
        leafDeptService.update(leafDept);
    }

    /**
     * 删除部门表
     */
    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Long> ids) {
        leafDeptService.remove(ids);
    }

    private final LeafDeptService leafDeptService;

    public LeafDeptController(LeafDeptService leafDeptService) {
        this.leafDeptService = leafDeptService;
    }
}

