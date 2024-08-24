package com.leaf.domain

/**
 * @author jhlz
 * @version x.x.x
 */
data class TableInfo(
    /* 数据库名 */
    val tableName: String,
    /* 数据库 schema */
    val tableSchema: String,
    /* 类型 */
    val tableType: String,
    /* 备注 */
    val tableDesc: String,
)