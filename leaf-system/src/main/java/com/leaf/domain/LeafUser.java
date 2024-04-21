package com.leaf.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.util.List;


/**
 * 用户登录信息表(LeafUser)实体类
 *
 * @author jhlz
 * @version 1.0.0
 */
@Entity
public interface LeafUser extends BaseEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long userId();

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
    @Nullable
    String avatar();

    /**
     * 最后一次登录时间
     */
    @Nullable
    LocalDate lastLoginTime();

    /**
     * 状态：0 正常，1 禁用
     */
    int status();

    /**
     * 用户详情 ID
     */
    @IdView
    Long userDetailId();

    @Nullable
    @ManyToOne
    @JoinColumn(name = "user_detail_id", foreignKeyType = ForeignKeyType.FAKE)
    LeafUserDetail userDetail();

    @ManyToMany
    @JoinTable(
            name = "leaf_user_dept",
            joinColumnName = "user_id",
            inverseJoinColumnName = "dept_id"
    )
    List<LeafDept> deptList();

}

