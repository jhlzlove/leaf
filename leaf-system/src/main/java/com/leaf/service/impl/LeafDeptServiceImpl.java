package com.leaf.service.impl;

import com.leaf.domain.LeafDept;
import com.leaf.repository.LeafDeptRepository;
import com.leaf.service.LeafDeptService;
import org.springframework.stereotype.Service;

/**
 * @author jhlz
 * @version x.x.x
 */
@Service
public class LeafDeptServiceImpl implements LeafDeptService {
    private final LeafDeptRepository deptRepository;

    public LeafDeptServiceImpl(LeafDeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    @Override
    public LeafDept add(LeafDept dept) {
        return deptRepository.save(dept);
    }
}
