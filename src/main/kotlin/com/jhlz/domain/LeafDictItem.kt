package com.jhlz.domain

import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.IdView
import org.babyfish.jimmer.sql.ManyToOne

/**
 * 字典项，与 字典表 是多对一的关系
 *
 * @author jhlz
 * @version x.x.x
 */
@Entity
interface LeafDictItem : BaseEntity, BaseID {
    /**
     * 字典 ID
     */
    @IdView("dict")
    val dictId: Long?

    /**
     * 字典键
     */
    val label: String?

    /**
     * 字典值
     */
    val value: String?

    /**
     * 状态：0正常，1禁用
     */
    val status: Int

    /**
     * 排序
     */
    val sortable: Int

    @ManyToOne
    val dict: LeafDict?
}
