package com.leaf.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
@Table(name = "leaf_user_detail")
public interface LeafUserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long userDetailId();

    /**
     * 姓氏
     */
    String firstName();

    /**
     * 名称
     */
    String lastName();

    /**
     * 民族
     */
    @Nullable
    String ethnic();

    /**
     * 性别
     */
    @Nullable
    String gender();

    /**
     * 年龄
     */
    @Nullable
    Integer age();

    /**
     * 现住址
     */
    @Nullable
    String address();

    /**
     * 故乡
     */
    @Nullable
    String hometown();

    /**
     * 身份证号
     */
    @Nullable
    String idCard();

    @OneToMany(mappedBy = "userDetail")
    List<LeafUser> users();
}
