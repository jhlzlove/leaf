package com.leaf.system.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;


/**
 * 用户登录信息表(LeafUser)实体类
 *
 * @author jhlz
 * @version 1.0.0
 */
@Entity
public interface LeafUser extends ID, BaseEntity {

    /**
     * 用户名
     */
    String username();

    /**
     * 密码
     */
    String password();

    /**
     * 昵称
     */
    String nickName();

    /**
     * 电话
     */
    @Nullable
    String phone();

    /**
     * 邮箱
     */
    @Nullable
    String email();

    /**
     * 头像地址
     */
    String avatar();

    /**
     * 状态：0 正常，1 禁用
     */
    int status();

    /**
     * 用户详情 ID
     */
    @Nullable
    @IdView
    Long userDetailId();

    /**
     * 部门 id
     */
    @IdView("dept")
    Long deptId();

    /**
     * 角色 ids
     */
    @IdView("roles")
    List<Long> roleIds();

    @OneToOne
    @Nullable
    LeafUserDetail userDetail();

    @Nullable
    @ManyToOne
    LeafDept dept();

    @ManyToMany
    @JoinTable(
            name = "leaf_user_role",
            joinColumnName = "id",
            inverseJoinColumnName = "id"
    )
    List<LeafRole> roles();

}

