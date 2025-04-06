package com.jhlz.domain

import org.babyfish.jimmer.sql.*

/**
 * 用户登录信息表(LeafUser)实体类
 *
 * @author jhlz
 * @version 1.0.0
 */
@Entity
interface LeafUser : BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

    /**
     * 用户名
     */
    @Key
    val username: String

    /**
     * 密码
     */
    val password: String

    /**
     * 昵称
     */
    val nickname: String

    /**
     * 电话
     */
    val phone: String?

    /**
     * 邮箱
     */
    val email: String?

    /**
     * 头像地址
     */
    val avatar: String

    /**
     * 状态：0 正常，1 禁用
     */
    val status: Int

    /**
     * 部门 id
     */
    @IdView
    val deptId: Long

    /**
     * 用户详情 ID
     */
    val userDetailId: Long?

    @ManyToMany
    @JoinTable(
        name = "leaf_user_role",
        joinColumnName = "user_id",
        inverseJoinColumnName = "role_id",
    )
    val roles: List<LeafRole>

    @ManyToOne
    val dept: LeafDept
}

