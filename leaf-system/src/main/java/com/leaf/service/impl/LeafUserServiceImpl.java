package com.leaf.service.impl;


import com.leaf.domain.LeafUser;
import com.leaf.repository.LeafUserRepository;
import com.leaf.response.Response;
import com.leaf.service.LeafUserService;
import com.leaf.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


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
        if (Objects.isNull(leafUser)) {
            return leafUserRepository.findAll(page);
        } else {
            return leafUserRepository.findAll(Example.of(leafUser), page);
        }
    }

    @Override
    public LeafUser findById(Long id) {
        return leafUserRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LeafUser save(LeafUser request) {
        return leafUserRepository.saveAndFlush(request);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response update(LeafUser leafUser) {
        Long userId = leafUser.getUserId();
        LeafUser user = leafUserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("userId 为 " + userId + " 的用户不存在！"));
        BeanUtils.copyProperties(user, leafUser, SpringUtil.getNonNullPropertyNames(leafUser));
        LeafUser save = leafUserRepository.saveAndFlush(leafUser);
        log.debug("修改后的用户信息：{}", save);
        return Response.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(List<Long> ids) {
        leafUserRepository.deleteAllById(ids);
    }
}

