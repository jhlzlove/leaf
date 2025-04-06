package com.jhlz.domain

import org.babyfish.jimmer.sql.*

/**
 * 字典项，与 字典表 是多对一的关系
 *
 * @author jhlz
 * @version x.x.x
 */
@Entity
interface LeafDictItem : BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

    /**
     * 字典表 id
     */
    @IdView("dict")
    val dictId: Long?

    /**
     * 字典键
     */
    val itemKey: String?

    /**
     * 字典值
     */
    val itemValue: String?

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
