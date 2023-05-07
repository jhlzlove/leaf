package com.leaf.system.service.impl;


import com.leaf.system.domain.LeafDict;
import com.leaf.system.repository.LeafDictRepository;
import com.leaf.system.service.LeafDictService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 字典表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
@Service
public class LeafDictServiceImpl implements LeafDictService {
    @Override
    public Page<LeafDict> listPage(LeafDict leafDict, Pageable page) {
        return leafDictRepository.findAll(page);
    }

    @Override
    public LeafDict findById(Long id) {
        return leafDictRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeafDict save(LeafDict leafDict) {
        return leafDictRepository.save(leafDict);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LeafDict leafDict) {
        leafDictRepository.save(leafDict);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        leafDictRepository.deleteAllById(ids);
    }

    private final LeafDictRepository leafDictRepository;

    public LeafDictServiceImpl(LeafDictRepository leafDictRepository) {
        this.leafDictRepository = leafDictRepository;
    }
}

