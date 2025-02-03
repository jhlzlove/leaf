package com.jhlz.domain

import org.babyfish.jimmer.sql.GeneratedValue
import org.babyfish.jimmer.sql.GenerationType
import org.babyfish.jimmer.sql.Id
import org.babyfish.jimmer.sql.MappedSuperclass

/**
 * 接口名称尽量不要直接使用 ID
 * @author jhlz
 * @version x.x.x
 */
@MappedSuperclass
interface BaseID {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long
}