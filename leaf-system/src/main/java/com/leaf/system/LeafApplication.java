package com.leaf.system;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

@QuarkusMain
public class LeafApplication {

    private static final Logger log = LoggerFactory.getLogger(LeafApplication.class);

    public static void main(String[] args) throws SQLException {
        log.info("日志打印无法输入中文！");

        Quarkus.run(args);

        // DatabaseMetaData metaData = masterDataSource.getConnection().getMetaData();
        // System.out.println(
        //         "数据库名称: " + metaData.getDatabaseProductName() + "\n" +
        //                 "数据库版本: " + metaData.getDatabaseProductVersion() + "\n" +
        //                 "URL: " + metaData.getURL() + "\n"
        // );
    }
}