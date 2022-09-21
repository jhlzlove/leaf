package com.example.service;

import com.example.domain.SysDept;

import java.util.List;

/**
 * @author jhlz
 * @since 2022-09-08 17:46:57
 */
public interface SysDeptService {

    /**
     * 根据 id 查找部门
     *
     * @param deptId id
     * @return 对象
     */
    SysDept findById(Long deptId);

    /**
     * 新增数据
     *
     * @param sysDept 实例对象
     * @return 实例对象
     */
    SysDept save(SysDept sysDept);

    /**
     * 修改数据
     *
     * @param sysDept 实例对象
     * @return 实例对象
     */
    SysDept update(SysDept sysDept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(Long id);

    /**
     * 部门列表
     *
     * @return
     */
    List<SysDept> listDept(String deptName, Boolean status);
}
