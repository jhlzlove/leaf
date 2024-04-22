package com.leaf.service.impl;


import com.leaf.common.response.Response;
import com.leaf.domain.LeafUser;
import com.leaf.domain.LeafUserTable;
import com.leaf.domain.Tables;
import com.leaf.repository.LeafUserRepository;
import com.leaf.service.LeafUserService;
import org.babyfish.jimmer.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户登录信息表业务层
 *
 * @author jhlz
 * @version 1.0.0
 */
@Service
public class LeafUserServiceImpl implements LeafUserService {

    private static final Logger log = LoggerFactory.getLogger(LeafUserServiceImpl.class);
    private final LeafUserRepository leafUserRepository;

    LeafUserTable userTable = Tables.LEAF_USER_TABLE;

    public LeafUserServiceImpl(LeafUserRepository leafUserRepository) {
        this.leafUserRepository = leafUserRepository;
    }

    @Override
    public Page<LeafUser> listPage(Pageable page) {
        return leafUserRepository.sql()
                .createQuery(userTable)
                .select(userTable)
                .fetchPage(page.getPageNumber(), page.getPageSize());
    }

    @Override
    public LeafUser findById(Long id) {
        return leafUserRepository.findById(id).orElseThrow();
    }

    @Override
    public LeafUser save(LeafUser request) {
        return leafUserRepository.save(request);
    }

    @Override
    public Response update(LeafUser leafUser) {
        LeafUser update = leafUserRepository.update(leafUser);
        // Long userId = leafUser.getUserId();
        // LeafUser user = leafUserRepository.findById(userId)
        //         .orElseThrow(() -> new RuntimeException("userId 为 " + userId + " 的用户不存在！"));
        // BeanUtils.copyProperties(user, leafUser, SpringUtil.getNonNullPropertyNames(leafUser));
        // LeafUser save = leafUserRepository.saveAndFlush(leafUser);
        // log.debug("修改后的用户信息：{}", save);
        return Response.ok(update);
    }

    @Override
    public void remove(List<Long> ids) {
        leafUserRepository.deleteAllById(ids);
    }
}

