package com.leaf.system.service;


import com.leaf.system.entity.LeafDept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 部门信息表业务层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:30
 */
public interface LeafDeptService {

    Page<LeafDept> listPage(Pageable page, LeafDept dept);

    LeafDept findById(Long id);

    void save(LeafDept leafDept);

    void update(LeafDept leafDept);

    void remove(List<Long> ids);
}

