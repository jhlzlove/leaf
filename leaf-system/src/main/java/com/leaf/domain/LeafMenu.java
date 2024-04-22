package com.leaf.domain;

import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.GenerationType;
import org.babyfish.jimmer.sql.Id;

/**
 * @author jhlz
 * @version x.x.x
 */
@Entity
public interface LeafMenu extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long menuId();

    /**
     * 菜单类型
     */
    String menuType();

    /**
     * 菜单名称
     */
    String menuName();

    /**
     * 父菜单 ID
     */
    Long parentId();

    /**
     * 排序
     */
    Integer sortable();

    /**
     * 权限字符串
     */
    String permission();

    /**
     * 状态：1正常，0禁用
     */
    int status();

}
