package com.jhlz.record

import io.micronaut.core.annotation.Introspected

@Introspected
data class PageQuery(
    /* 第几页 */
    val pageNum: Int,
    /* 每页数量 */
    val pageSize: Int
)