package com.leaf.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
    long parentId();

    /**
     * 排序
     */
    Integer sortable();

    /**
     * 权限字符串
     */
    @Nullable
    String permission();

    /**
     * 状态：1正常，0禁用
     */
    int status();

    @ManyToMany(mappedBy = "menus")
    List<LeafRole> roles();
}
