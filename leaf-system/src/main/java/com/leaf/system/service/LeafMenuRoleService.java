package com.leaf.system.service;


import com.leaf.system.domain.LeafMenuRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 菜单-角色关联表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
public interface LeafMenuRoleService {

    /**
     * 分页列表
     *
     * @param leafMenuRole 条件参数
     * @param page         分页参数
     * @return 符合条件的分页数据
     */
    Page<LeafMenuRole> listPage(LeafMenuRole leafMenuRole, Pageable page);

    /**
     * 根据 ID 获取详情
     *
     * @param id id
     * @return 详情对象
     */
    LeafMenuRole findById(Long id);

    /**
     * 添加数据
     *
     * @param leafMenuRole 添加数据内容
     */
    LeafMenuRole save(LeafMenuRole leafMenuRole);

    /**
     * 更新数据
     *
     * @param leafMenuRole 更新的数据内容
     */
    void update(LeafMenuRole leafMenuRole);

    /**
     * 删除数据
     *
     * @param ids 删除数据的 id 集合
     */
    void remove(List<Long> ids);
}

