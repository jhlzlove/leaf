package com.leaf.system.controller;


import com.leaf.system.entity.LeafDept;
import com.leaf.system.service.LeafDeptService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 部门信息表控制层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:30
 */
@RestController
@RequestMapping("/dept")
public class LeafDeptController {

    /**
     * 获取部门信息表列表(分页)
     */
    @GetMapping
    public Page<LeafDept> listPage(Pageable page) {

        return null;
    }

    /**
     * 获取部门信息表
     */
    @GetMapping("/{id}")
    public LeafDept queryById(@PathVariable Long id) {
        return leafDeptService.findById(id);
    }

    /**
     * 添加部门信息表
     */
    @PostMapping
    public void add(@RequestBody LeafDept leafDept) {
        leafDeptService.save(leafDept);
    }


    /**
     * 修改部门信息表
     */
    @PutMapping
    public void edit(@RequestBody LeafDept leafDept) {
        leafDeptService.update(leafDept);
    }

    /**
     * 删除部门信息表
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

