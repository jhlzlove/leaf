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
    int add(LeafDept dept);

    void delete(List<Long> ids);
}
