package service.impl;


import java.lang.Long;

import .entity.LeafRole;
import .service.LeafRoleService;
import .repository.LeafRoleRepository;
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
 * 角色表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Service
public class LeafRoleServiceImpl implements LeafRoleService {
    @Override
    public Page<LeafRole> listPage(LeafRole leafRole, Pageable page) {
        return leafRoleRepository.findAll(page);
    }

    @Override
    public LeafRole findById(Long id) {
        return leafRoleRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeafRole save(LeafRole leafRole) {
        leafRoleRepository.save(leafRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LeafRole leafRole) {
        leafRoleRepository.save(leafRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        leafRoleRepository.deleteAllById(ids);
    }

    private final LeafRoleRepository leafRoleRepository;

    public LeafRoleServiceImpl(LeafRoleRepository leafRoleRepository) {
        this.leafRoleRepository = leafRoleRepository;
    }
}

