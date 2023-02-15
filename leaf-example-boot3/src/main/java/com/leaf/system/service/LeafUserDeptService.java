package com.leaf.system.service;


import com.leaf.system.entity.LeafUserDept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 用户部门关联表业务层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:32
 */
public interface LeafUserDeptService {

    Page<LeafUserDept> listPage(Pageable page);

    LeafUserDept findById(Long id);

    void save(LeafUserDept leafUserDept);

    void update(LeafUserDept leafUserDept);

    void remove(List<Long> ids);
}

