package com.leaf.system.service;

import com.leaf.framework.record.PageRecord;
import com.leaf.system.domain.LeafRole;
import com.leaf.system.domain.LeafRoleTable;
import jakarta.enterprise.context.ApplicationScoped;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;

/**
 * @author jhlz
 * @version 1.0.0
 */
@ApplicationScoped
public class LeafRoleService {
    private final JSqlClient sqlClient;
    LeafRoleTable table = LeafRoleTable.$;

    public LeafRoleService( JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    public LeafRole save(LeafRole leafRole) {
        return sqlClient.save(leafRole).getModifiedEntity();
    }

    public LeafRole findById(long id) {
        return sqlClient.findById(LeafRole.class, id);
    }

    public Page<LeafRole> page(PageRecord page) {
        System.out.println(page);
        return null;
        // return sqlClient.createQuery(table)
        //         .select(table)
        //         .fetchPage(page.page() - 1, page.size());
    }
}
