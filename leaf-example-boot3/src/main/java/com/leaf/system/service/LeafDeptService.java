package com.leaf.system.service;


import com.leaf.system.domain.LeafDept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 部门表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
public interface LeafDeptService {

    /**
     * 分页列表
     *
     * @param leafDept 条件参数
     * @param page     分页参数
     * @return 符合条件的分页数据
     */
    Page<LeafDept> listPage(LeafDept leafDept, Pageable page);

    /**
     * 根据 ID 获取详情
     *
     * @param id id
     * @return 详情对象
     */
    LeafDept findById(Long id);

    /**
     * 添加数据
     *
     * @param leafDept 添加数据内容
     */
    boolean save(LeafDept leafDept);

    /**
     * 更新数据
     *
     * @param leafDept 更新的数据内容
     */
    void update(LeafDept leafDept);

    /**
     * 删除数据
     *
     * @param ids 删除数据的 id 集合
     */
    void remove(List<Long> ids);
}

