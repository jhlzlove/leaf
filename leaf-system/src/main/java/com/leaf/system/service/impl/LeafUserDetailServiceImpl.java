package com.leaf.system.service.impl;


import com.leaf.system.domain.LeafUserDetail;
import com.leaf.system.repository.LeafUserDetailRepository;
import com.leaf.system.service.LeafUserDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户信息表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Service
public class LeafUserDetailServiceImpl implements LeafUserDetailService {
    @Override
    public Page<LeafUserDetail> listPage(LeafUserDetail leafUserDetail, Pageable page) {
        return leafUserDetailRepository.findAll(page);
    }

    @Override
    public LeafUserDetail findById(Long id) {
        return leafUserDetailRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeafUserDetail save(LeafUserDetail leafUserDetail) {
        return leafUserDetailRepository.save(leafUserDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LeafUserDetail leafUserDetail) {
        leafUserDetailRepository.save(leafUserDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        leafUserDetailRepository.deleteAllById(ids);
    }

    private final LeafUserDetailRepository leafUserDetailRepository;

    public LeafUserDetailServiceImpl(LeafUserDetailRepository leafUserDetailRepository) {
        this.leafUserDetailRepository = leafUserDetailRepository;
    }
}

