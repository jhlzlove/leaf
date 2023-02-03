package com.leaves.system.service.impl;

import com.leaves.system.domain.Role;
import com.leaves.system.repository.RoleRepository;
import com.leaves.system.service.RoleService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * 角色表(Role)表服务实现类
 *
 * @author jhlz
 * @since 2022-12-26 17:56:03
 */
@Service
public class RoleServiceImpl implements RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("没有该角色信息！"));
    }

    /**
     * 分页查询
     *
     * @param role        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Role> queryByPage(Role role, PageRequest pageRequest) {
        // long total = roleRepository.count();
        return roleRepository.findAll(Example.of(role), pageRequest);
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insertOrUpdate(Role role) {
        roleRepository.save(role);
        return role;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return roleRepository.deleteRoleById(id);
    }

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
