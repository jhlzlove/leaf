package com.example.service;

import com.example.domain.SysDept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author jhlz
 * @since 2022-09-08 17:46:57
 */
public interface SysDeptService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public abstract SysDept findById(Long id);

    /**
     * 分页查询
     *
     * @param sysDept     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    public abstract Page<SysDept> findByPage(SysDept sysDept, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysDept 实例对象
     * @return 实例对象
     */
    public abstract SysDept save(SysDept sysDept);

    /**
     * 修改数据
     *
     * @param sysDept 实例对象
     * @return 实例对象
     */
    public abstract SysDept update(SysDept sysDept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public abstract void deleteById(Long id);

    public abstract List<SysDept> list();
}
