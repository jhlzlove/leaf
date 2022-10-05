package com.example.service;

import com.example.domain.SysRole;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author jhlz
 * @since 2022-09-08 17:46:58
 */
public interface SysRoleService {

    /**
     * 新增或修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    SysRole saveOrUpdate(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return
     */
    void deleteById(Long id);

    /**
     * 角色分页列表
     *
     * @param page     当前页
     * @param pageSize 页数据
     */
    Page<SysRole> listByPage(int page, int pageSize);

    /**
     * 角色列表
     *
     * @return
     */
    List<SysRole> list();
}
