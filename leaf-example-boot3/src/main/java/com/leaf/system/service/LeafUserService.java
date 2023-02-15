package com.leaf.system.service;


import com.leaf.system.entity.LeafUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 用户信息表业务层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:32
 */
public interface LeafUserService {

    Page<LeafUser> listPage(Pageable page);

    LeafUser findById(Long id);

    LeafUser save(LeafUser leafUser);

    LeafUser update(LeafUser leafUser);

    void remove(List<Long> ids);
}

