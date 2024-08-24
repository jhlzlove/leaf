package com.leaf.domain

data class TableField(
    /* 字段名称 */
    val fieldName: String,
    /* 字段类型 */
    val fieldType: String,
    /* 是否可空 */
    val isNull: String?,
    /* 默认值 */
    val defaultValue: String?,
    /* 是否自增 */
    val isIncrement: String?,
    /* 备注 */
    val filedDesc: String?,
)
