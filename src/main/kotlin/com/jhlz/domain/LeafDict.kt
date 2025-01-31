package com.jhlz.domain

import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.OneToMany

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
interface LeafDict : BaseEntity, BaseID {
    /**
     * 字典编码
     */
    val dictCode: String?

    /**
     * 字典名称
     */
    val dictName: String?

    /**
     * 状态：0正常，1禁用
     */
    val status: Int

    @OneToMany(mappedBy = "dict")
    val items: List<LeafDictItem>
}
