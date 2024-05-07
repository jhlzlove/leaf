package com.leaf.domain;

import org.babyfish.jimmer.sql.*;

import java.util.List;

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
     * 状态：1正常，0禁用
     */
    int status();

    @OneToMany(mappedBy = "dict")
    List<LeafDictItem> items();
}
