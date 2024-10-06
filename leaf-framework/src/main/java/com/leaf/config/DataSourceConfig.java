// package com.leaf.common.config;
//
// import io.agroal.api.AgroalDataSource;
// import io.quarkus.agroal.DataSource;
// import io.quarkus.arc.DefaultBean;
// import io.quarkus.datasource.runtime.DataSourceSupport;
// import jakarta.enterprise.context.ApplicationScoped;
// import jakarta.inject.Inject;
// import jakarta.ws.rs.Produces;
//
// /**
//  * 数据源配置管理
//  *
//  * @author jhlz
//  * @version 1.0.0
//  */
// // @ApplicationScoped
// public class DataSourceConfig {
//     @Inject
//     DataSourceSupport dataSourceSupport;
//
//     @Inject
//     @DefaultBean
//     @DataSource("master")
//     AgroalDataSource masterDataSource;
//
//     @Inject
//     @DataSource("slave")
//     AgroalDataSource slaveDataSource;
//
//     @Produces
//     @ApplicationScoped
//     public AgroalDataSource dataSource() {
//         if (dataSourceSupport.getInactiveNames().contains("master")) {
//             return masterDataSource;
//         } else {
//             return slaveDataSource;
//         }
//     }
// }
