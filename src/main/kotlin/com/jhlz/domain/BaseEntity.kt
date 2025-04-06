package com.jhlz.domain

import org.babyfish.jimmer.sql.IdView
import org.babyfish.jimmer.sql.JoinColumn
import org.babyfish.jimmer.sql.ManyToOne
import org.babyfish.jimmer.sql.MappedSuperclass
import java.time.OffsetDateTime

/**
 * 使用 @MappedSuperclass 注解的父类可以被多继承
 * [关于 Jimmer 的继承](https://babyfish-ct.github.io/jimmer-doc/zh/docs/mapping/advanced/mapped-super-class)
 *
 * @author jhlz
 * @version 1.0.0
 */
@MappedSuperclass
interface BaseEntity {
    /**
     * 创建人
     */
    @IdView("creator")
    val createId: Long?

    @ManyToOne
    @JoinColumn(name = "create_id")
    val creator: LeafUser?

    /**
     * 创建时间
     */
    val createTime: OffsetDateTime

    /**
     * 更新人
     */
    @IdView("updator")
    val updateId: Long?

    @ManyToOne
    @JoinColumn(name = "update_id")
    val updator: LeafUser?

    /**
     * 更新时间
     */
    val updateTime: OffsetDateTime?

    /**
     * 备注
     */
    val remark: String?
}
