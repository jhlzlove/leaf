package com.leaf.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author jhlz
 * @version x.x.x
 */
@Entity
public interface LeafMenu extends ID, BaseEntity {

    /**
     * 菜单类型
     */
    String menuType();

    /**
     * 父菜单 ID
     */
    Long parentId();

    /**
     * 排序
     */
    int sortable();

    /**
     * 权限字符串
     */
    @Nullable
    String permission();

    /**
     * 状态：1正常，0禁用
     */
    int status();

    /**
     * 标题
     */
    String title();

    /**
     * 路由地址
     */
    @Nullable
    String path();

    /**
     * 组件地址
     */
    @Nullable
    String component();

    /**
     * 组件名称
     */
    @Nullable
    String name();

    /**
     * 图标
     */
    @Nullable
    String icon();

    /**
     * 是否外链：1是，0否
     */
    @Nullable
    @Column(name = "is_external")
    Integer external();

    /**
     * 是否隐藏：1是，0否
     */
    @Nullable
    @Column(name = "is_hidden")
    Integer hidden();

    @ManyToMany(mappedBy = "menus")
    List<LeafRole> roles();
}
