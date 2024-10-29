package com.leaf.system.service;

import com.leaf.common.record.PageRecord;
import com.leaf.system.domain.LeafRole;
import com.leaf.system.domain.LeafRoleTable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author jhlz
 * @version 1.0.0
 */
@ApplicationScoped
public class LeafRoleService {
    private final JSqlClient sqlClient;
    LeafRoleTable table = LeafRoleTable.$;

    public LeafRoleService(@Named("sqlClient") JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    public LeafRole save(LeafRole leafRole) {
        return sqlClient.save(leafRole).getModifiedEntity();
    }

    public LeafRole findById(long id) {
        return sqlClient.findById(LeafRole.class, id);
    }

    public @NotNull Page<LeafRole> findAll(PageRecord page) {
        if (Objects.isNull(page)) {
            page = new PageRecord();
        }
        System.out.println(page);
        // return sqlClient.createQuery(table)
        //         .select(table)
        //         .fetchPage(page.page(), page.size());
        return null;
    }
}
