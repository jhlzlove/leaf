package com.leaf.system.service.impl;


import com.leaf.system.domain.LeafMenuRole;
import com.leaf.system.repository.LeafMenuRoleRepository;
import com.leaf.system.service.LeafMenuRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 菜单-角色关联表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Service
public class LeafMenuRoleServiceImpl implements LeafMenuRoleService {
    @Override
    public Page<LeafMenuRole> listPage(LeafMenuRole leafMenuRole, Pageable page) {
        return leafMenuRoleRepository.findAll(page);
    }

    @Override
    public LeafMenuRole findById(Long id) {
        return leafMenuRoleRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeafMenuRole save(LeafMenuRole leafMenuRole) {
        return leafMenuRoleRepository.save(leafMenuRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LeafMenuRole leafMenuRole) {
        leafMenuRoleRepository.save(leafMenuRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        leafMenuRoleRepository.deleteAllById(ids);
    }

    private final LeafMenuRoleRepository leafMenuRoleRepository;

    public LeafMenuRoleServiceImpl(LeafMenuRoleRepository leafMenuRoleRepository) {
        this.leafMenuRoleRepository = leafMenuRoleRepository;
    }
}

