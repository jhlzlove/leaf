package com.leaf.common.config;

import org.babyfish.jimmer.spring.SqlClients;
import org.babyfish.jimmer.spring.transaction.JimmerTransactionManager;
import org.babyfish.jimmer.spring.transaction.TransactionalSqlClients;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Jimmer sqlClient 多数据源配置
 *
 * @author jhlz
 * @version 1.0.0
 */
// @Configuration
public class SqlClientConfig {

    @Bean("tm1")
    @Primary
    public PlatformTransactionManager tm1(ApplicationContext ctx, @Qualifier("ds1") DataSource dataSource) {
        return new JimmerTransactionManager(SqlClients.java(ctx, dataSource, null));
    }

    @Bean("tm2")
    public PlatformTransactionManager tm2(ApplicationContext ctx, @Qualifier("ds2") DataSource dataSource) {
        return new JimmerTransactionManager(SqlClients.java(ctx, dataSource, null));
    }

    @Bean
    public JSqlClient sqlClient() {
        return TransactionalSqlClients.java();
    }
}
