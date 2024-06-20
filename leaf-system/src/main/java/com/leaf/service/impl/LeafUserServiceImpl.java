package com.leaf.service.impl;


import com.leaf.common.response.Response;
import com.leaf.domain.LeafUser;
import com.leaf.domain.LeafUserTable;
import com.leaf.domain.Tables;
import com.leaf.service.LeafUserService;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;
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
    private final JSqlClient sqlClient;

    LeafUserTable userTable = Tables.LEAF_USER_TABLE;

    public LeafUserServiceImpl(JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    @Override
    public Page<LeafUser> page(LeafUser leafUser, Pageable page) {
        return sqlClient.createQuery(userTable)
                .select(userTable)
                .fetchPage(page.getPageNumber(), page.getPageSize());
    }

    @Override
    public LeafUser getUserById(Long id) {
        return sqlClient.findById(LeafUser.class, id);
    }

    @Override
    public int add(LeafUser request) {
        return sqlClient.save(request).getTotalAffectedRowCount();
    }

    @Override
    public Response update(LeafUser leafUser) {
        // LeafUser update = sqlClient.update(leafUser);
        // Long userId = leafUser.getUserId();
        // LeafUser user = leafUserRepository.findById(userId)
        //         .orElseThrow(() -> new RuntimeException("userId 为 " + userId + " 的用户不存在！"));
        // BeanUtils.copyProperties(user, leafUser, SpringUtil.getNonNullPropertyNames(leafUser));
        // LeafUser save = leafUserRepository.saveAndFlush(leafUser);
        // log.debug("修改后的用户信息：{}", save);
        return Response.ok();
    }

    @Override
    public void delete(List<Long> ids) {
        sqlClient.deleteByIds(LeafUser.class, ids);
    }
}

