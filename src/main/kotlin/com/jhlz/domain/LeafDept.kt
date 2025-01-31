package com.jhlz.domain

import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.Key
import org.babyfish.jimmer.sql.OneToMany
import org.babyfish.jimmer.sql.Table

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
@Table(name = "leaf_dept")
interface LeafDept : BaseEntity, BaseID {
    /**
     * 部门名称
     */
    @Key
    val name: String?

    /**
     * 父级部门 ID
     */
    val parentId: Long?

    /**
     * 部门领导
     */
    val leaderId: Long

    /**
     * 部门描述
     */
    val description: String?

    /**
     * 状态：0正常，1禁用
     */
    val status: Int

    /**
     * 排序
     */
    val sortable: Int

    /**
     * 父级列表
     */
    val ancestors: String?

    @OneToMany(mappedBy = "dept")
    val userList: List<LeafUser>
}
