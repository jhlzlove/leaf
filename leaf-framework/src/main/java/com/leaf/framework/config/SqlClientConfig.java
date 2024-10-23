package com.leaf.framework.config;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * Jimmer sqlClient 多数据源配置
 *
 * @author jhlz
 * @version 1.0.0
 */
@ApplicationScoped
public class SqlClientConfig {

    // @Bean("tm1")
    // @Primary
    // public PlatformTransactionManager tm1(ApplicationContext ctx, @Qualifier("ds1") DataSource dataSource) {
    //     return new JimmerTransactionManager(SqlClients.java(ctx, dataSource, null));
    // }
    //
    // @Bean("tm2")
    // public PlatformTransactionManager tm2(ApplicationContext ctx, @Qualifier("ds2") DataSource dataSource) {
    //     return new JimmerTransactionManager(SqlClients.java(ctx, dataSource, null));
    // }
    //
    // @Bean
    // public JSqlClient sqlClient() {
    //     return TransactionalSqlClients.java();
    // }
}
