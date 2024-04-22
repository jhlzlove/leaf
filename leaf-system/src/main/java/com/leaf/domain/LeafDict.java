package com.leaf.domain;

import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.GenerationType;
import org.babyfish.jimmer.sql.Id;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
public interface LeafDict extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long dictId();

    /**
     * 字典类型
     */
    String dictType();

    /**
     * 字典名称
     */
    String dictName();

    /**
     * 字典键
     */
    String dictKey();

    /**
     * 字典值
     */
    String dictValue();

    /**
     * 状态：1正常，0禁用
     */
    int status();
}
