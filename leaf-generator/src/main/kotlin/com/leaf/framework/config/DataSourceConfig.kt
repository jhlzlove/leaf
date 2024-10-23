package com.leaf.framework.config

import com.leaf.framework.util.SQLUtil

/**
 * @author jhlz
 * @version x.x.x
 */
class DataSourceConfig {


    // fun dataSource(): DataSource {
    //     // val url = "jdbc:postgresql://localhost:5432/postgres"
    //     // var connection = DriverManager.getConnection(url, "postgres", "postgres")
    //     // return connection
    //     return null
    // }


}

fun main() {

    // SQLUtil.getTableFields().forEach {
    //     println(it)
    // }

    SQLUtil.getTableInfos()
}
