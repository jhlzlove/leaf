package com.leaf.service;

import com.leaf.domain.Fetchers;
import com.leaf.domain.LeafUser;
import com.leaf.domain.LeafUserTable;
import com.leaf.record.PageRecord;
import jakarta.enterprise.context.ApplicationScoped;
import org.babyfish.jimmer.Page;
import org.babyfish.jimmer.sql.JSqlClient;

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




    public void login(LeafUser leafUser) {
        LeafUser user = sqlClient.createQuery(table)
                .where(
                        table.username().eq(leafUser.username()),
                        table.password().eq(leafUser.password())
                )
                .select(table)
                .fetchOneOrNull();
        System.out.println("login successful: ");
    }

    public void save(LeafUser leafUser) {
        sqlClient.save(leafUser);
    }
}
