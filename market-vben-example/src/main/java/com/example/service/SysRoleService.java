package com.example.service;

import com.example.domain.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author jhlz
 * @since 2022-09-08 17:46:58
 */
public interface SysRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public abstract SysRole findById(Long id);

    /**
     * 分页查询
     *
     * @param sysRole     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    public abstract Page<SysRole> findByPage(SysRole sysRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    public abstract SysRole save(SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    public abstract SysRole update(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return
     */
    public abstract void deleteById(Long id);

    /**
     * 角色列表
     *
     * @return
     */
    public abstract List<SysRole> list();

    /**
     * 角色分页列表
     *
     * @param page     当前页
     * @param pageSize 页数据
     */
    public abstract void getRoleListByPage(int page, int pageSize);
}
