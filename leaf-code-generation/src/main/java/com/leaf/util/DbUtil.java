package com.leaf.util;

import com.leaf.domain.TableInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jhlz
 * @version 0.0.1
 * @since 2023/9/17 11:32
 */
@Component
public class DbUtil {
    private static final Logger log = LoggerFactory.getLogger(DbUtil.class);
    private final DataSource dataSource;

    public DbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取除模板数据库外的所有数据库
     *
     * @return 数据库集合
     */
    public List<String> getAllDatabases() {
        String sql = "select datname from pg_database where datistemplate = false;";
        return executeQueryResult(sql, "datname");
    }

    /**
     * 获取数据库中 public 模式的所有表名称
     *
     * @return 表名称集合
     */
    public List<String> getAllTables() {
        String sql = "select tablename from pg_tables where schemaname=\'public\'";
        return executeQueryResult(sql, "table_name");
    }

    /**
     * 获取表字段信息
     *
     * @return 表字段信息集合
     */
    public List<TableInfo> getTableInfo(String tableName) {
        Connection connection = getConnection();
        List<TableInfo> list = new ArrayList<>();
        String sql = """
                SELECT
                 A.attname AS fieldName,-- 字段名
                 t.typname as fieldType,    --字段类型
                 NULLIF(information_schema._pg_char_max_length(A.atttypid, A.atttypmod), -1) AS maxLen,  -- 字符串最大长度
                 col_description ( A.attrelid, A.attnum ) AS comment,   -- 字段备注
                  case A.attnotnull when 't' then 'Y' else 'N' end AS isNotNull,  -- 是否非空
                  case A.atthasdef when 't' then 'Y' else 'N' end AS defaultValue --是否存在默认值
                FROM
                    pg_class AS C,
                    pg_attribute AS A,
                    pg_type as T
                WHERE
                    C.relname = '%s'
                    AND A.attrelid = C.oid
                    AND A.atttypid= T.oid
                    AND A.attnum > 0
                    AND NOT A.attisdropped;
                """;
        final String finalSql = String.format(sql, tableName);
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(finalSql);
            while (resultSet.next()) {
                String fieldName = resultSet.getString("fieldName");
                String fieldType = resultSet.getString("fieldType");
                String maxLen = resultSet.getString("maxLen");
                String comment = resultSet.getString("comment");
                String notnull = resultSet.getString("isNotNull");
                String defaultValue = resultSet.getString("defaultValue");
                TableInfo info = new TableInfo(tableName, fieldName, fieldType, maxLen, comment, notnull, defaultValue);
                list.add(info);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询结果
     *
     * @param sql SQL 语句
     * @param key 获取的键
     * @return 结果集合
     */
    private List<String> executeQueryResult(String sql, String key) {
        List<String> list = new ArrayList<>();
        Connection connection = getConnection();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                String value = resultSet.getString(key);
                list.add(value);
            }
            return list;
        } catch (SQLException e) {
            log.error("执行语句失败！{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
