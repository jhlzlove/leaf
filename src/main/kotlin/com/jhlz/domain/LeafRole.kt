package com.jhlz.domain

import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.JoinTable
import org.babyfish.jimmer.sql.ManyToMany
import org.babyfish.jimmer.sql.Table

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
@Table(name = "leaf_role")
interface LeafRole : BaseID, BaseEntity {
    /**
     * 编码
     */
    val code: String?

    /**
     * 名称
     */
    val name: String?

    /**
     * 1 正常 0 禁用
     */
    val status: Int

    /**
     * 排序
     */
    val sortable: Int

    @ManyToMany
    @JoinTable(name = "leaf_menu_role", joinColumnName = "role_id", inverseJoinColumnName = "menu_id")
    val menus: List<LeafMenu>

    @ManyToMany(mappedBy = "roles")
    val users: List<LeafUser>
}
