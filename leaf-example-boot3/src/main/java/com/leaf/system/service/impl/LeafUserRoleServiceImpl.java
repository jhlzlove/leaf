package com.leaf.system.service.impl;


import com.leaf.system.entity.LeafUserRole;
import com.leaf.system.repository.LeafUserRoleRepository;
import com.leaf.system.service.LeafUserRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 业务层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:32
 */
@Service
public class LeafUserRoleServiceImpl implements LeafUserRoleService {
    @Override
    public LeafUserRole findById(Long id) {
        return leafUserRoleRepository.findById(id).orElseThrow();
    }

    @Override
    public Page<LeafUserRole> listPage(Pageable page) {
        return leafUserRoleRepository.findAll(page);
    }

    @Override
    public void save(LeafUserRole leafUserRole) {
        leafUserRoleRepository.save(leafUserRole);
    }

    @Override
    public void update(LeafUserRole leafUserRole) {
        leafUserRoleRepository.save(leafUserRole);
    }

    @Override
    public void remove(List<Long> ids) {
        leafUserRoleRepository.deleteAllById(ids);
    }

    private final LeafUserRoleRepository leafUserRoleRepository;

    public LeafUserRoleServiceImpl(LeafUserRoleRepository leafUserRoleRepository) {
        this.leafUserRoleRepository = leafUserRoleRepository;
    }
}

