package com.leaf.system.service;


import com.leaf.system.entity.LeafUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 用户信息表业务层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:32
 */
public interface LeafUserService {

    /**
     * 分页列表
     *
     * @param user 条件参数
     * @param page 分页参数
     * @return 符合条件的分页数据
     */
    Page<LeafUser> listPage(LeafUser user, Pageable page);

    /**
     * 根据 ID 获取详情
     *
     * @param id id
     * @return
     */
    LeafUser findById(Long id);

    /**
     * 添加数据
     *
     * @param leafUser 添加对象
     */
    void save(LeafUser leafUser);

    /**
     * 更新数据
     *
     * @param leafUser 更新对象
     */
    void update(LeafUser leafUser);

    /**
     * 删除数据
     *
     * @param ids 删除数据的 id 集合
     */
    void remove(List<Long> ids);
}

