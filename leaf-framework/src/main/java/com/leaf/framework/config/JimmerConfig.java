package com.leaf.framework.config;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.dialect.PostgresDialect;
import org.babyfish.jimmer.sql.runtime.ConnectionManager;
import org.babyfish.jimmer.sql.runtime.DatabaseValidationMode;
import org.babyfish.jimmer.sql.runtime.Executor;
import org.babyfish.jimmer.sql.runtime.SqlFormatter;

public class JimmerConfig {

    private final AgroalDataSource masterDataSource;
    private final AgroalDataSource slave1DataSource;

    public JimmerConfig(@DataSource("master") AgroalDataSource masterDataSource,
                        @DataSource("slave1") AgroalDataSource slave1DataSource) {
        this.masterDataSource = masterDataSource;
        this.slave1DataSource = slave1DataSource;
    }

    @Produces
    @Named("sqlClient")
    public JSqlClient defaultSqlClient() {
        return JSqlClient.newBuilder()
                .setConnectionManager(
                        ConnectionManager.simpleConnectionManager(masterDataSource)
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
                .setDatabaseValidationMode(DatabaseValidationMode.ERROR)
                .build();
    }

    @Produces
    @Named("sqlClient1")
    public JSqlClient slave1SqlClient() {
        return JSqlClient.newBuilder()
                .setConnectionManager(
                        ConnectionManager.simpleConnectionManager(slave1DataSource)
                )
                // 打印 sql
                .setExecutor(Executor.log())
                // 美化 sql 输出
                .setSqlFormatter(SqlFormatter.PRETTY)
                .setForeignKeyEnabledByDefault(false)
                // 设置方言
                .setDialect(PostgresDialect.INSTANCE)
                // 非严格验证数据库
                .setDatabaseValidationMode(DatabaseValidationMode.NONE)
                .build();
    }
}
