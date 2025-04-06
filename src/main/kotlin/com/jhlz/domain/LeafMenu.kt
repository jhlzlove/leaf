package com.jhlz.domain

import org.babyfish.jimmer.sql.*

/**
 * @author jhlz
 * @version x.x.x
 */
@Entity
interface LeafMenu : BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

    /**
     * 标题
     */
    val title: String?

    /**
     * 菜单类型：1目录，2菜单，3按钮
     */
    val menuType: String?

    /**
     * 父菜单 ID
     */
    val parentId: Long?

    /**
     * 权限字符串
     */
    val permission: String?

    /**
     * 路由地址
     */
    val routePath: String?

    /**
     * 组件地址
     */
    val componentPath: String?

    /**
     * 组件名称
     */
    val component: String?

    /**
     * 图标
     */
    val icon: String?

    /**
     * 是否外链：0外链 1非外链
     */
    @Column(name = "is_external")
    val external: Int?

    /**
     * 是否隐藏：0显示 1隐藏
     */
    @Column(name = "is_hidden")
    val hidden: Int?

    /**
     * 状态：0正常，1禁用
     */
    val status: Int

    /**
     * 排序
     */
    val sortable: Int

}
