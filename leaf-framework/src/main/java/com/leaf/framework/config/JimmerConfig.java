package com.leaf.framework.config;

import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.inject.Produces;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.dialect.PostgresDialect;
import org.babyfish.jimmer.sql.runtime.ConnectionManager;
import org.babyfish.jimmer.sql.runtime.DatabaseValidationMode;
import org.babyfish.jimmer.sql.runtime.Executor;
import org.babyfish.jimmer.sql.runtime.SqlFormatter;

import java.sql.SQLException;

/**
 * @author jhlz
 * @version 1.0.0
 */
public class JimmerConfig {
    private final AgroalDataSource dataSource;

    public JimmerConfig(AgroalDataSource masterDataSource) {
        this.dataSource = masterDataSource;
    }

    @Produces
    public JSqlClient sqlClient() throws SQLException {
        return JSqlClient.newBuilder()
                .setConnectionManager(
                        ConnectionManager.simpleConnectionManager(dataSource)
                )
                // 打印 sql
                .setExecutor(Executor.log())
                // 美化 sql 输出
                .setSqlFormatter(SqlFormatter.PRETTY)
                // 默认是否真外键
                .setForeignKeyEnabledByDefault(true)
                // 设置方言
                .setDialect(PostgresDialect.INSTANCE)
                // 严格验证数据库
                .setDatabaseValidationMode(DatabaseValidationMode.NONE)
                .build();
    }
}
