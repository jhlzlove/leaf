package com.leaf.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
@Table(name = "leaf_user_detail")
public interface LeafUserDetail extends ID {

    /**
     * 姓氏
     */
    @Key
    String firstName();

    /**
     * 名称
     */
    @Key
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

    // @OneToOne
    // // @JoinColumn(name = "id")
    // LeafUser user();
}
