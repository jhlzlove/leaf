package com.leaf.system.service.impl;


import com.leaf.system.entity.LeafUserDept;
import com.leaf.system.repository.LeafUserDeptRepository;
import com.leaf.system.service.LeafUserDeptService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户部门关联表业务层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:32
 */
@Service
public class LeafUserDeptServiceImpl implements LeafUserDeptService {
    @Override
    public LeafUserDept findById(Long id) {
        return leafUserDeptRepository.findById(id).orElseThrow();
    }

    @Override
    public Page<LeafUserDept> listPage(Pageable page) {
        return leafUserDeptRepository.findAll(page);
    }

    @Override
    public void save(LeafUserDept leafUserDept) {
        leafUserDeptRepository.save(leafUserDept);
    }

    @Override
    public void update(LeafUserDept leafUserDept) {
        leafUserDeptRepository.save(leafUserDept);
    }

    @Override
    public void remove(List<Long> ids) {
        leafUserDeptRepository.deleteAllById(ids);
    }

    private final LeafUserDeptRepository leafUserDeptRepository;

    public LeafUserDeptServiceImpl(LeafUserDeptRepository leafUserDeptRepository) {
        this.leafUserDeptRepository = leafUserDeptRepository;
    }
}

