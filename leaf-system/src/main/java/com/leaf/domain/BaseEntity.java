package com.leaf.domain;

import org.babyfish.jimmer.sql.MappedSuperclass;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;

/**
 * 公共属性类
 * <p>
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
    @Nullable
    LocalDateTime createTime();

    /**
     * 更新时间
     */
    @Nullable
    LocalDateTime updateTime();

    /**
     * 创建人
     */
    @Nullable
    String createBy();

    /**
     * 更新人
     */
    @Nullable
    String updateBy();

    /**
     * 备注
     */
    @Nullable
    String remark();
}
