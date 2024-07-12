package com.leaf.util

import com.leaf.domain.DataSourceProperties
import com.leaf.domain.TableField
import com.leaf.domain.TableInfo
import java.sql.Connection
import java.sql.DriverManager

/**
 * @author jhlz
 * @version x.x.x
 */
class SQLUtil {
    companion object {

        fun getConnection(): Connection {
            val properties = DataSourceProperties()
            return DriverManager.getConnection(properties.url, properties.username, properties.password)
        }

        /**
         * 获取所有表信息
         */
        fun getTableInfos(): List<TableInfo> {
            val connection = getConnection()
            val meta = connection.metaData
            println("数据库版本号：" + meta.databaseProductVersion)
            val catalogs = meta.catalogs

            // 获取连接中所有的数据库
            while (catalogs.next()) {
                println(catalogs.getString("TABLE_CAT"))
            }

            println("connect database name: ${connection.catalog}")
            // 获取指定数据库的所有数据表
            val tables = meta.getTables(connection.catalog, null, null, arrayOf("TABLE"))
            val list = arrayListOf<TableInfo>()
            while (tables.next()) {
                val tableName = tables.getString("TABLE_NAME")
                val tableSchema = tables.getString("TABLE_SCHEM")
                val tableType = tables.getString("TABLE_TYPE")
                val tableRemark = tables.getString("REMARKS")
                println("数据库名称：${tableName} , 数据库模式: ${tableSchema} 数据库类型: ${tableType} 数据库描述 :${tableRemark}")
                list.add(TableInfo(tableName, tableSchema, tableType, tableRemark))
            }
            return list
        }

        /**
         * 获取所有表的字段信息
         */
        fun getTableFields(): List<TableField> {
            val tableInfos = getTableInfos()
            val connection = getConnection()
            val catalog = connection.catalog
            val meta = connection.metaData
            val result = arrayListOf<TableField>()

            for (tableInfo in tableInfos) {
                val columns = meta.getColumns(catalog, null, tableInfo.tableName, null)
                while (columns.next()) {
                    val name = columns.getString("COLUMN_NAME")
                    val sqlType = columns.getString("TYPE_NAME")
                    // 列的大小。对于 char 或 date 类型，列的大小是最大字符数，对于 numeric 和 decimal 类型，列的大小就是精度。
                    val columnSize = columns.getString("COLUMN_SIZE")
                    // 默认值
                    val defaultV = columns.getString("COLUMN_DEF")
                    // 字段备注
                    val remark = columns.getString("REMARKS")
                    // 是否自增
                    val isIncrement = columns.getString("IS_AUTOINCREMENT")
                    // 是否可空
                    val isNull = columns.getString("IS_NULLABLE")
                    val tableField = TableField(name, sqlType, isNull, defaultV, isIncrement, remark)
                    result.add(tableField)
                }
            }
            return result
        }
    }

}