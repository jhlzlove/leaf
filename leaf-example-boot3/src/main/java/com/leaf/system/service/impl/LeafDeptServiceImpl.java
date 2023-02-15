package com.leaf.system.service.impl;


import com.leaf.system.entity.LeafDept;
import com.leaf.system.repository.LeafDeptRepository;
import com.leaf.system.service.LeafDeptService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 部门信息表业务层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:31
 */
@Service
public class LeafDeptServiceImpl implements LeafDeptService {
    @Override
    public LeafDept findById(Long id) {
        return leafDeptRepository.findById(id).orElseThrow();
    }

    @Override
    public Page<LeafDept> listPage(Pageable page) {
        return leafDeptRepository.findAll(page);
    }

    @Override
    public void save(LeafDept leafDept) {
        leafDeptRepository.save(leafDept);
    }

    @Override
    public void update(LeafDept leafDept) {
        leafDeptRepository.save(leafDept);
    }

    @Override
    public void remove(List<Long> ids) {
        leafDeptRepository.deleteAllById(ids);
    }

    private final LeafDeptRepository leafDeptRepository;

    public LeafDeptServiceImpl(LeafDeptRepository leafDeptRepository) {
        this.leafDeptRepository = leafDeptRepository;
    }
}

