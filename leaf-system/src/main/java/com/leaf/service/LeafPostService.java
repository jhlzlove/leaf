package com.leaf.service;

import com.leaf.domain.LeafPost;
import org.babyfish.jimmer.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author jhlz
 * @version x.x.x
 */
public interface LeafPostService {

    /**
     * 分页查询
     *
     * @param pageable 分页对象
     * @return 分页结果
     */
    Page<LeafPost> page(LeafPost leafPost, Pageable pageable);

    /**
     * 添加
     *
     * @param leafPost 请求实体
     * @return int
     */
    int add(LeafPost leafPost);

    /**
     * 修改
     *
     * @param leafPost 请求实体
     * @return int
     */
    int update(LeafPost leafPost);

    /**
     * 删除
     *
     * @param ids 删除集合
     * @return 删除记录数
     */
    int delete(List<Long> ids);
}
