package com.leaf;

import org.junit.jupiter.api.Test;

/**
 * @author jhlz
 * @version 0.0.1
 * @since 2023/9/17 12:00
 */
public class StringTest {
    /**
     * test: string_block example
     */
    @Test
    public void string_block_union_test() {
        String sql = """
                SELECT
                 A.attname AS field_name,-- 字段名
                 t.typname as typename,    --字段类型
                 NULLIF(information_schema._pg_char_max_length(A.atttypid, A.atttypmod), -1) AS maxlen,  -- 字符串最大长度
                 col_description ( A.attrelid, A.attnum ) AS COMMENT,   -- 字段备注
                 format_type ( A.atttypid, A.atttypmod ) AS TYPE,
                 A.attnotnull AS NOTNULL ,  -- 是否非空
                 A.atthasdef ,  --是否存在默认值
                 A.atttypmod
                FROM
                    pg_class AS C,
                    pg_attribute AS A ,
                    pg_type as T
                WHERE
                    C.relname = '%s'
                    AND A.attrelid = C.oid
                    AND A.atttypid= T.oid
                    AND A.attnum > 0
                    AND NOT A.attisdropped;
                """;
        final String finalSql = String.format(sql, "leaf_user");
        System.out.println(finalSql);
    }
}
