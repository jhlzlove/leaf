package com.leaf.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

/**
 * 字典项，与 字典表 是多对一的关系
 *
 * @author jhlz
 * @version x.x.x
 */
@Entity
public interface LeafDictItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long dictItemId();

    /**
     * 字典 ID
     */
    @IdView
    Long dictId();

    /**
     * 字典键
     */
    String dictKey();

    /**
     * 字典值
     */
    String dictValue();

    @ManyToOne
    @Nullable
    LeafDict dict();
}
