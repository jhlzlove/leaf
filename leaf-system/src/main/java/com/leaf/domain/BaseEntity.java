package com.leaf.domain;

import org.babyfish.jimmer.sql.MappedSuperclass;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;

/**
 * 公共属性类
 * <p>
 * 使用 @MappedSuperclass 注解的父类可以被多继承
 * https://babyfish-ct.github.io/jimmer-doc/zh/docs/mapping/advanced/mapped-super-class
 *
 * @author jhlz
 * @since 2022/11/26 15:33:42
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
    // @ManyToOne
    @Nullable
    // @JoinColumn(
    //         name = "CREATE_BY",
    //         foreignKeyType = ForeignKeyType.FAKE
    // )
    String createBy();

    /**
     * 更新人
     */
    // @ManyToOne
    @Nullable
    // @JoinColumn(
    //         name = "UPDATE_BY",
    //         foreignKeyType = ForeignKeyType.FAKE
    // )
    String updateBy();

    /**
     * 备注
     */
    @Nullable
    String remark();
}
