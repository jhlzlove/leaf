package com.leaf.service;


import com.leaf.common.response.Response;
import com.leaf.domain.LeafUser;
import org.babyfish.jimmer.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 用户登录信息表业务层
 *
 * @author jhlz
 * @version 1.0.0
 */
public interface LeafUserService {

    /**
     * 分页列表
     *
     * @param leafUser 条件参数
     * @param page     分页参数
     * @return 符合条件的分页数据
     */
    Page<LeafUser> page(LeafUser leafUser, Pageable page);

    /**
     * 根据 ID 获取详情
     *
     * @param id id
     * @return 详情对象
     */
    LeafUser getUserById(Long id);

    /**
     * 添加数据
     *
     * @param request 添加数据内容
     */
    int add(LeafUser request);

    /**
     * 更新数据
     *
     * @param leafUser 更新的数据内容
     */
    Response update(LeafUser leafUser);

    /**
     * 删除数据
     *
     * @param ids 删除数据的 id 集合
     */
    void delete(List<Long> ids);
}

