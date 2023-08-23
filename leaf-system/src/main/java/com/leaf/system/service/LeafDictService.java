package com.leaf.system.service;


import com.leaf.system.domain.LeafDict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 字典表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
public interface LeafDictService {

    /**
     * 分页列表
     *
     * @param leafDict 条件参数
     * @param page     分页参数
     * @return 符合条件的分页数据
     */
    Page<LeafDict> listPage(LeafDict leafDict, Pageable page);

    /**
     * 根据 ID 获取详情
     *
     * @param id id
     * @return 详情对象
     */
    LeafDict findById(Long id);

    /**
     * 添加数据
     *
     * @param leafDict 添加数据内容
     */
    LeafDict save(LeafDict leafDict);

    /**
     * 更新数据
     *
     * @param leafDict 更新的数据内容
     */
    void update(LeafDict leafDict);

    /**
     * 删除数据
     *
     * @param ids 删除数据的 id 集合
     */
    void remove(List<Long> ids);
}

