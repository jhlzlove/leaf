package com.leaf.system.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;

/**
 * 使用 @MappedSuperclass 注解的父类可以被多继承
 * <a href="https://babyfish-ct.github.io/jimmer-doc/zh/docs/mapping/advanced/mapped-super-class">关于 Jimmer 的继承</a>
 *
 * @author jhlz
 * @version 1.0.0
 */
@MappedSuperclass
public interface BaseEntity {

    /**
     * 创建时间
     */
    LocalDateTime createTime();

    /**
     * 更新时间
     */
    LocalDateTime updateTime();

    /**
     * 创建人
     */
    long createId();

    /**
     * 更新人
     */
    long updateId();

    /**
     * 备注
     */
    @Nullable
    String remark();
}
