package com.leaf.system.service;


import com.leaf.system.domain.LeafUserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 用户-角色关联表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
public interface LeafUserRoleService {

    /**
     * 分页列表
     *
     * @param leafUserRole 条件参数
     * @param page         分页参数
     * @return 符合条件的分页数据
     */
    Page<LeafUserRole> listPage(LeafUserRole leafUserRole, Pageable page);

    /**
     * 根据 ID 获取详情
     *
     * @param id id
     * @return 详情对象
     */
    LeafUserRole findById(Long id);

    /**
     * 添加数据
     *
     * @param leafUserRole 添加数据内容
     */
    LeafUserRole save(LeafUserRole leafUserRole);

    /**
     * 更新数据
     *
     * @param leafUserRole 更新的数据内容
     */
    void update(LeafUserRole leafUserRole);

    /**
     * 删除数据
     *
     * @param ids 删除数据的 id 集合
     */
    void remove(List<Long> ids);
}

