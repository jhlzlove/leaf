package com.leaf.service;

import com.leaf.domain.LeafRole;
import org.babyfish.jimmer.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author jhlz
 * @version x.x.x
 */
public interface LeafRoleService {
    /**
     * 分页查询
     *
     * @param pageable 分页对象
     * @return 分页结果
     */
    Page<LeafRole> page(LeafRole leafRole, Pageable pageable);

    /**
     * 添加
     *
     * @param leafRole 请求实体
     * @return int
     */
    int add(LeafRole leafRole);

    /**
     * 修改
     *
     * @param leafRole 请求实体
     * @return int
     */
    int update(LeafRole leafRole);

    /**
     * 删除
     *
     * @param ids 删除集合
     * @return 删除记录数
     */
    int delete(List<Long> ids);
}
