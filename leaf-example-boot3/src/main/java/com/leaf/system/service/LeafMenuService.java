package service;


import java.lang.Long;

import .entity.LeafMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;


/**
 * 菜单表业务层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
public interface LeafMenuService {

    /**
     * 分页列表
     *
     * @param leafMenu 条件参数
     * @param page     分页参数
     * @return 符合条件的分页数据
     */
    Page<LeafMenu> listPage(LeafMenu leafMenu, Pageable page);

    /**
     * 根据 ID 获取详情
     *
     * @param id id
     * @return 详情对象
     */
    LeafMenu findById(Long id);

    /**
     * 添加数据
     *
     * @param leafMenu 添加数据内容
     */
    void save(LeafMenu leafMenu);

    /**
     * 更新数据
     *
     * @param leafMenu 更新的数据内容
     */
    void update(LeafMenu leafMenu);

    /**
     * 删除数据
     *
     * @param ids 删除数据的 id 集合
     */
    void remove(List<Long> ids);
}

