package com.leaf.service.impl;

import com.leaf.domain.LeafPost;
import com.leaf.domain.LeafPostTable;
import com.leaf.service.LeafPostService;
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
public class LeafPostServiceImpl implements LeafPostService {
    final JSqlClient sqlClient;

    public LeafPostServiceImpl(JSqlClient sqlClient) {
        this.sqlClient = sqlClient;
    }

    @Override
    public Page<LeafPost> page(LeafPost leafPost, Pageable pageable) {
        LeafPostTable table = LeafPostTable.$;
        return sqlClient.createQuery(table)
                .select(table)
                .fetchPage(pageable.getPageNumber(), pageable.getPageSize());
    }

    @Override
    public int add(LeafPost leafPost) {
        return sqlClient.save(leafPost).getTotalAffectedRowCount();
    }

    @Override
    public int update(LeafPost leafPost) {
        return sqlClient.save(leafPost).getTotalAffectedRowCount();
    }

    @Override
    public int delete(List<Long> ids) {
        return sqlClient.deleteByIds(LeafPost.class, ids).getTotalAffectedRowCount();
    }
}
