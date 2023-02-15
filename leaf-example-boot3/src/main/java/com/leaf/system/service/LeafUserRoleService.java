package com.leaf.system.service;


import com.leaf.system.entity.LeafUserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 业务层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:32
 */
public interface LeafUserRoleService {

    Page<LeafUserRole> listPage(Pageable page);

    LeafUserRole findById(Long id);

    void save(LeafUserRole leafUserRole);

    void update(LeafUserRole leafUserRole);

    void remove(List<Long> ids);
}

