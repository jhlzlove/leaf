package com.jhlz.domain

import org.babyfish.jimmer.sql.*

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
interface LeafDict : BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

    /**
     * 字典类型标识
     */
    val dictType: String

    /**
     * 字典类型名称
     */
    val dictName: String?

    /**
     * 状态：0正常，1禁用
     */
    val status: Int

    /**
     * 排序
     */
    val sortable: Int

    @OneToMany(mappedBy = "dict")
    val items: List<LeafDictItem>
}
