package com.leaf.system.service.impl;


import com.leaf.system.entity.LeafRole;
import com.leaf.system.repository.LeafRoleRepository;
import com.leaf.system.service.LeafRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 角色信息表业务层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:31
 */
@Service
public class LeafRoleServiceImpl implements LeafRoleService {
    @Override
    public LeafRole findById(Long id) {
        return leafRoleRepository.findById(id).orElseThrow();
    }

    @Override
    public Page<LeafRole> listPage(Pageable page) {
        return leafRoleRepository.findAll(page);
    }

    @Override
    public void save(LeafRole leafRole) {
        leafRoleRepository.save(leafRole);
    }

    @Override
    public void update(LeafRole leafRole) {
        leafRoleRepository.save(leafRole);
    }

    @Override
    public void remove(List<Long> ids) {
        leafRoleRepository.deleteAllById(ids);
    }

    @Override
    public List<LeafRole> findByUserId(Long userId) {
        // return leafRoleRepository.findByUserId(userId);
        return null;
    }

    private final LeafRoleRepository leafRoleRepository;

    public LeafRoleServiceImpl(LeafRoleRepository leafRoleRepository) {
        this.leafRoleRepository = leafRoleRepository;
    }
}

