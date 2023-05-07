package com.leaf.system.service.impl;


import java.lang.Long;

import com.leaf.system.entity.LeafDept;
import com.leaf.system.service.LeafDeptService;
import com.leaf.system.repository.LeafDeptRepository;
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
 * 部门表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
@Service
public class LeafDeptServiceImpl implements LeafDeptService {
    @Override
    public Page<LeafDept> listPage(LeafDept leafDept, Pageable page) {
        return leafDeptRepository.findAll(page);
    }

    @Override
    public LeafDept findById(Long id) {
        return leafDeptRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeafDept save(LeafDept leafDept) {
        leafDeptRepository.save(leafDept);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LeafDept leafDept) {
        leafDeptRepository.save(leafDept);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        leafDeptRepository.deleteAllById(ids);
    }

    private final LeafDeptRepository leafDeptRepository;

    public LeafDeptServiceImpl(LeafDeptRepository leafDeptRepository) {
        this.leafDeptRepository = leafDeptRepository;
    }
}

