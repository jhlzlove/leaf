package com.leaf.domain;

import org.babyfish.jimmer.sql.*;

import java.util.List;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
public interface LeafDict extends BaseEntity, ID {

    /**
     * 字典编码
     */
    String dictCode();

    /**
     * 字典名称
     */
    String dictName();

    /**
     * 状态：0正常，1禁用
     */
    int status();

    @OneToMany(mappedBy = "dict")
    List<LeafDictItem> items();
}
