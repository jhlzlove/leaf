package com.leaf.domain;

import org.babyfish.jimmer.sql.*;

import java.util.List;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
@Table(name = "leaf_role")
public interface LeafRole extends ID, BaseEntity {

    /**
     * 编码
     */
    String code();

    /**
     * 名称
     */
    String name();

    /**
     * 1 正常 0 禁用
     */
    int status();

    /**
     * 排序
     */
    int sortable();

    @ManyToMany
    @JoinTable(
            name = "leaf_menu_role",
            joinColumnName = "role_id",
            inverseJoinColumnName = "menu_id"
    )
    List<LeafMenu> menus();

    @ManyToMany(mappedBy = "roles")
    List<LeafUser> users();
}
