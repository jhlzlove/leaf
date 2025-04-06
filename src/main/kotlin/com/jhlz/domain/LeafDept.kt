package com.jhlz.domain

import org.babyfish.jimmer.sql.*

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
@Table(name = "leaf_dept")
interface LeafDept : BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

    /**
     * 部门名称
     */
    @Key
    val deptName: String

    /**
     * 父部门 id
     */
    val parentId: Long?

    /**
     * 父级列表
     */
    val ancestors: String?

    /**
     * 部门领导 id
     */
    val leaderId: Long?

    /**
     * 状态：0正常，1禁用
     */
    val status: Int

    /**
     * 排序
     */
    val sortable: Int

    @OneToMany(mappedBy = "dept")
    val users: List<LeafUser>
}
