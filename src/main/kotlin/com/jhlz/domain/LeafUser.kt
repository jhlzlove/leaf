package com.jhlz.domain

import org.babyfish.jimmer.sql.*

/**
 * 用户登录信息表(LeafUser)实体类
 *
 * @author jhlz
 * @version 1.0.0
 */
@Entity
interface LeafUser : BaseID, BaseEntity {
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
    val nickName: String

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
     * 用户详情 ID
     */
    @IdView
    val userDetailId: Long?

    /**
     * 部门 id
     */
    @IdView("dept")
    val deptId: Long?

    /**
     * 角色 ids
     */
    @IdView("roles")
    val roleIds: List<Long>

    @OneToOne
    val userDetail: LeafUserDetail?

    @ManyToOne
    val dept: LeafDept?

    @ManyToMany
    @JoinTable(name = "leaf_user_role", joinColumnName = "id", inverseJoinColumnName = "id")
    val roles: List<LeafRole>
}

