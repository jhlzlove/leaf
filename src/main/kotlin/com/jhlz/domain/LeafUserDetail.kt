package com.jhlz.domain

import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.Key
import org.babyfish.jimmer.sql.OneToOne
import org.babyfish.jimmer.sql.Table

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
@Table(name = "leaf_user_detail")
interface LeafUserDetail : BaseID {
    /**
     * 姓氏
     */
    @Key
    val firstName: String?

    /**
     * 名称
     */
    @Key
    val lastName: String?

    /**
     * 民族
     */
    val ethnic: String?

    /**
     * 性别
     */
    val gender: String?

    /**
     * 年龄
     */
    val age: Int?

    /**
     * 现住址
     */
    val address: String?

    /**
     * 故乡
     */
    val hometown: String?

    /**
     * 身份证号
     */
    val idCard: String?

    @OneToOne
    val user: LeafUser?
}
