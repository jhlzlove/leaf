package com.leaf.system.service.impl;


import com.leaf.system.domain.LeafUser;
import com.leaf.system.repository.LeafUserRepository;
import com.leaf.system.service.LeafUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户登录信息表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Service
public class LeafUserServiceImpl implements LeafUserService {

    private static final Logger log = LoggerFactory.getLogger(LeafUserServiceImpl.class);
    private final LeafUserRepository leafUserRepository;

    public LeafUserServiceImpl(LeafUserRepository leafUserRepository) {
        this.leafUserRepository = leafUserRepository;
    }

    @Override
    public Page<LeafUser> listPage(LeafUser leafUser, Pageable page) {
        return leafUserRepository.findAll(Example.of(leafUser), page);
    }

    @Override
    public LeafUser findById(Long id) {
        return leafUserRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeafUser save(LeafUser request) {
        return leafUserRepository.save(request);
        // return leafUserRepository.saveUser(request);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LeafUser leafUser) {
        leafUserRepository.save(leafUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        leafUserRepository.deleteAllById(ids);
    }
}

