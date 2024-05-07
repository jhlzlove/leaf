package com.leaf.service;

import com.leaf.domain.LeafDept;

import java.util.List;

/**
 * @author jhlz
 * @version x.x.x
 */
public interface LeafDeptService {
    /**
     * 添加部门
     *
     * @param dept 部门信息
     * @return 部门
     */
    LeafDept add(LeafDept dept);

    void remove(List<Long> ids);
}
