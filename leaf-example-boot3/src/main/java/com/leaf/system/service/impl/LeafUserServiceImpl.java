package com.leaf.system.service.impl;

import com.leaf.system.entity.LeafUser;
import com.leaf.system.repository.LeafUserRepository;
import com.leaf.system.service.LeafUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


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
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public Page<LeafUser> listPage(LeafUser user, Pageable page) {
        List<LeafUser> list = userRepository.findAll(Example.of(user));
        return new PageImpl<>(list, page, list.size());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(LeafUser user) {
        log.info("add target: {}", user);
        userRepository.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LeafUser user) {
        log.info("update target: {}", user);
        userRepository.findById(user.getId()).ifPresent(u -> userRepository.save(user));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        List<Long> targetIds = ids.stream().filter(Objects::nonNull).toList();
        log.info("删除的用户 ids {}", targetIds);
        userRepository.deleteAllById(targetIds);
    }

    private static final Logger log = LoggerFactory.getLogger(LeafUserServiceImpl.class);
    private final LeafUserRepository userRepository;

    public LeafUserServiceImpl(LeafUserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

