package com.leaf.system.service;


import com.leaf.system.entity.LeafRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 角色信息表业务层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:31
 */
public interface LeafRoleService {

    Page<LeafRole> listPage(Pageable page);

    LeafRole findById(Long id);

    void save(LeafRole leafRole);

    void update(LeafRole leafRole);

    void remove(List<Long> ids);

    /**
     * 根据 userId 获取该用户角色列表
     *
     * @return 角色列表
     */
    List<LeafRole> findByUserId(Long userId);
}

