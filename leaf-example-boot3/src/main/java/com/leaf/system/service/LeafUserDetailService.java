package com.leaf.system.service;


import com.leaf.system.domain.LeafUserDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 用户信息表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
public interface LeafUserDetailService {

    /**
     * 分页列表
     *
     * @param leafUserDetail 条件参数
     * @param page           分页参数
     * @return 符合条件的分页数据
     */
    Page<LeafUserDetail> listPage(LeafUserDetail leafUserDetail, Pageable page);

    /**
     * 根据 ID 获取详情
     *
     * @param id id
     * @return 详情对象
     */
    LeafUserDetail findById(Long id);

    /**
     * 添加数据
     *
     * @param leafUserDetail 添加数据内容
     */
    LeafUserDetail save(LeafUserDetail leafUserDetail);

    /**
     * 更新数据
     *
     * @param leafUserDetail 更新的数据内容
     */
    void update(LeafUserDetail leafUserDetail);

    /**
     * 删除数据
     *
     * @param ids 删除数据的 id 集合
     */
    void remove(List<Long> ids);
}

