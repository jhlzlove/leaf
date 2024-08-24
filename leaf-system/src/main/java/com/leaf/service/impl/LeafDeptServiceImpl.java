package com.leaf.service.impl;

import com.leaf.domain.LeafDept;
import com.leaf.domain.LeafDeptTable;
import com.leaf.service.LeafDeptService;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jhlz
 * @version x.x.x
 */
@Service
public class LeafDeptServiceImpl implements LeafDeptService {

    final JSqlClient sqlClient;
    LeafDeptTable table = LeafDeptTable.$;

    public LeafDeptServiceImpl(JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    @Override
    public int add(LeafDept dept) {

        return sqlClient.save(dept).getTotalAffectedRowCount();
    }

    @Override
    public void delete(List<Long> ids) {
        sqlClient.deleteByIds(LeafDept.class, ids);
    }
}
