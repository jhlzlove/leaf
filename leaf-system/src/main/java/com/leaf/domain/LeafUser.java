package com.leaf.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;


/**
 * 用户登录信息表(LeafUser)实体类
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
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
    @Nullable
    String nickName();

    /**
     * 头像地址
     */
    @Nullable
    String avatar();

    /**
     * 状态：0 正常，1 禁用
     */
    Integer status();

    /**
     * 是否删除：0 正常；1 删除
     */
    Integer delFlag();

    String userCode();

}

