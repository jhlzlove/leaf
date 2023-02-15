package com.leaf.system.service.impl;

import com.leaf.system.entity.LeafUser;
import com.leaf.system.repository.LeafUserRepository;
import com.leaf.system.service.LeafUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 用户信息表业务层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:32
 */
@Service
public class LeafUserServiceImpl implements LeafUserService {
    @Override
    public LeafUser findById(Long id) {
        return leafUserRepository.findById(id).orElseThrow();
    }

    @Override
    public Page<LeafUser> listPage(Pageable page) {
        List<LeafUser> list = leafUserRepository.findAll();
        Page<LeafUser> leafUsers = new PageImpl<>(list, page, list.size());
        return leafUsers;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeafUser save(LeafUser leafUser) {
        LeafUser save = leafUserRepository.save(leafUser);
        log.info("{}", save.getId());
        return save;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeafUser update(LeafUser leafUser) {
        leafUser.setUpdateTime(LocalDateTime.now());
        return leafUserRepository.saveAndFlush(leafUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        leafUserRepository.deleteAllById(ids);
    }

    private static final Logger log = LoggerFactory.getLogger(LeafUserServiceImpl.class);
    private final LeafUserRepository leafUserRepository;

    public LeafUserServiceImpl(LeafUserRepository leafUserRepository) {
        this.leafUserRepository = leafUserRepository;
    }
}

