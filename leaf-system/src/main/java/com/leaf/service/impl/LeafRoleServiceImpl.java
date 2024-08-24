package com.leaf.service.impl;

import com.leaf.domain.LeafRole;
import com.leaf.domain.LeafRoleTable;
import com.leaf.service.LeafRoleService;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jhlz
 * @version x.x.x
 */
@Service
public class LeafRoleServiceImpl implements LeafRoleService {
    final JSqlClient sqlClient;

    public LeafRoleServiceImpl(JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    @Override
    public Page<LeafRole> page(LeafRole leafRole, Pageable pageable) {
        LeafRoleTable table = LeafRoleTable.$;
        return sqlClient.createQuery(table)
                .select(table)
                .fetchPage(pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    public int add(LeafRole leafRole) {
        return sqlClient.save(leafRole).getTotalAffectedRowCount();
    }

    @Override
    public int update(LeafRole leafRole) {
        return sqlClient.save(leafRole).getTotalAffectedRowCount();
    }

    @Override
    public int delete(List<Long> ids) {
        return sqlClient.deleteByIds(LeafRole.class, ids).getTotalAffectedRowCount();
    }
}
