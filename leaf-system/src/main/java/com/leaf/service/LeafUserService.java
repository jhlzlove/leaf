package com.leaf.service;

import com.leaf.annotation.Log;
import com.leaf.domain.Fetchers;
import com.leaf.domain.LeafUser;
import com.leaf.domain.LeafUserTable;
import com.leaf.record.PageRecord;
import jakarta.enterprise.context.ApplicationScoped;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;

import java.util.List;

/**
 * @author jhlz
 * @version 1.0.0
 */
@ApplicationScoped
public class LeafUserService {

    private final JSqlClient sqlClient;
    LeafUserTable table = LeafUserTable.$;

    public LeafUserService(JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    public Page<LeafUser> page(PageRecord page) {
        return sqlClient.createQuery(table)
                .select(table)
                .fetchPage(page.page(), page.size());
    }

    @Log(module = "详情")
    public LeafUser getById(long id) {
        return sqlClient.createQuery(table)
                .where(table.id().eq(id))
                .select(
                        table.fetch(
                                Fetchers.LEAF_USER_FETCHER
                                        .allScalarFields()
                                        .userDetail(
                                                Fetchers.LEAF_USER_DETAIL_FETCHER
                                                        .firstName()
                                                        .lastName()
                                                        .gender()
                                        )
                        )
                )
                .fetchOneOrNull();
    }

    public void add(LeafUser leafUser) {
        sqlClient.insert(leafUser);
    }

    public void update(LeafUser leafUser) {
        sqlClient.update(leafUser);
    }

    public void delete(List<Long> ids) {
        sqlClient.deleteByIds(LeafUser.class, ids);
    }
}
