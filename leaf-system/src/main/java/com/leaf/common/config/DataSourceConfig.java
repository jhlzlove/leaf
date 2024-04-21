package com.leaf.common.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据源配置管理
 *
 * @author jhlz
 * @version 1.0.0
 */
// @Configuration
public class DataSourceConfig {

    /**
     * 主数据源
     *
     * @return 主数据源 DataSource
     */
    @Bean("ds1")
    @Primary
    @ConfigurationProperties("spring.datasource.ds1")
    public DataSource ds1() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean("ds2")
    @ConfigurationProperties("spring.datasource.ds2")
    public DataSource ds2() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
