package com.leaf.domain;

/**
 * @author jhlz
 * @version 0.0.1
 * @since 2023/9/10 14:57
 */
public record TableInfo(String tableName,
                        String filedName,
                        String fieldType,
                        String maxLen,
                        String comment,
                        String notnull,
                        String defaultValue) {
}
