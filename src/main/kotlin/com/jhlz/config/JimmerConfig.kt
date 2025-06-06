package com.jhlz.config

import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import org.babyfish.jimmer.sql.dialect.PostgresDialect
import org.babyfish.jimmer.sql.kt.newKSqlClient
import org.babyfish.jimmer.sql.runtime.DatabaseValidationMode
import org.babyfish.jimmer.sql.runtime.DefaultDatabaseNamingStrategy
import org.babyfish.jimmer.sql.runtime.Executor
import org.babyfish.jimmer.sql.runtime.SqlFormatter
import javax.sql.DataSource

/**
 * @author jhlz
 * @version 0.0.1
 */
@Factory
class JimmerConfig(
    val dataSource: DataSource
) {
    @Singleton
    fun sqlClient() = newKSqlClient {
        setConnectionManager {
            val con = dataSource.connection
            con.use { proceed(con) }
        }

        // 使用小写命名策略
        setDatabaseNamingStrategy(DefaultDatabaseNamingStrategy.LOWER_CASE)
        // 设置方言
        setDialect(PostgresDialect.INSTANCE)
        // 数据库验证模式
        setDatabaseValidationMode(DatabaseValidationMode.NONE)
        // sql print
        setExecutor(Executor.log())
        setSqlFormatter(SqlFormatter.PRETTY)
    }
}
