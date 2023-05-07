package service.impl;


import java.lang.Long;

import .entity.LeafUserRole;
import .service.LeafUserRoleService;
import .repository.LeafUserRoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


/**
 * 用户-角色关联表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Service
public class LeafUserRoleServiceImpl implements LeafUserRoleService {
    @Override
    public Page<LeafUserRole> listPage(LeafUserRole leafUserRole, Pageable page) {
        return leafUserRoleRepository.findAll(page);
    }

    @Override
    public LeafUserRole findById(Long id) {
        return leafUserRoleRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeafUserRole save(LeafUserRole leafUserRole) {
        leafUserRoleRepository.save(leafUserRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LeafUserRole leafUserRole) {
        leafUserRoleRepository.save(leafUserRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        leafUserRoleRepository.deleteAllById(ids);
    }

    private final LeafUserRoleRepository leafUserRoleRepository;

    public LeafUserRoleServiceImpl(LeafUserRoleRepository leafUserRoleRepository) {
        this.leafUserRoleRepository = leafUserRoleRepository;
    }
}

