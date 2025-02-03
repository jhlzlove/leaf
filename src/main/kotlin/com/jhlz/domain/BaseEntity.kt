package com.jhlz.domain

import org.babyfish.jimmer.sql.MappedSuperclass
import java.time.LocalDateTime

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
     * 创建时间
     */
    val createTime: LocalDateTime?

    /**
     * 更新时间
     */
    val updateTime: LocalDateTime?

    /**
     * 创建人
     */
    val createId: Long?

    /**
     * 更新人
     */
    val updateId: Long?

    /**
     * 备注
     */
    val remark: String?
}
