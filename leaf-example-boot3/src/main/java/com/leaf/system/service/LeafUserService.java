package com.leaf.system.service;


import com.leaf.system.domain.LeafUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 用户登录信息表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
public interface LeafUserService {

    /**
     * 分页列表
     *
     * @param leafUser 条件参数
     * @param page     分页参数
     * @return 符合条件的分页数据
     */
    Page<LeafUser> listPage(LeafUser leafUser, Pageable page);

    /**
     * 根据 ID 获取详情
     *
     * @param id id
     * @return 详情对象
     */
    LeafUser findById(Long id);

    /**
     * 添加数据
     *
     * @param leafUser 添加数据内容
     */
    LeafUser save(LeafUser leafUser);

    /**
     * 更新数据
     *
     * @param leafUser 更新的数据内容
     */
    void update(LeafUser leafUser);

    /**
     * 删除数据
     *
     * @param ids 删除数据的 id 集合
     */
    void remove(List<Long> ids);

    /**
     * 登录
     *
     * @param user 登录对象
     * @return token
     */
    String login(LeafUser user);
}

