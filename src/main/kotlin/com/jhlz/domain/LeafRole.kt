package com.jhlz.domain

import org.babyfish.jimmer.sql.*

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
@Table(name = "leaf_role")
interface LeafRole : BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

    /**
     * 编码
     */
    @Key
    val roleCode: String

    /**
     * 名称
     */
    @Key
    val roleName: String

    /**
     * 1 正常 0 禁用
     */
    val status: Int

    /**
     * 排序
     */
    val sortable: Int

    @ManyToMany(mappedBy = "roles")
    val users: List<LeafUser>
}
