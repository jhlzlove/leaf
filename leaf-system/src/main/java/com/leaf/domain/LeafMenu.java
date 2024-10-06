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
     * 标题
     */
    String title();

    /**
     * 菜单类型：1目录，2菜单，3按钮
     */
    String menuType();

    /**
     * 父菜单 ID
     */
    @Nullable
    Long parentId();

    /**
     * 权限字符串
     */
    @Nullable
    String permission();

    /**
     * 路由地址
     */
    @Nullable
    String routePath();

    /**
     * 组件地址
     */
    @Nullable
    String componentPath();

    /**
     * 组件名称
     */
    @Nullable
    String component();

    /**
     * 图标
     */
    @Nullable
    String icon();

    /**
     * 是否外链：0外链 1非外链
     */
    @Nullable
    @Column(name = "is_external")
    Integer external();

    /**
     * 是否隐藏：0显示 1隐藏
     */
    @Nullable
    @Column(name = "is_hidden")
    Integer hidden();

    /**
     * 状态：0正常，1禁用
     */
    int status();

    /**
     * 排序
     */
    int sortable();

    @ManyToMany(mappedBy = "menus")
    List<LeafRole> roles();
}
