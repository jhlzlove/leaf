package com.leaf.domain;

import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.IdView;
import org.babyfish.jimmer.sql.ManyToOne;
import org.jetbrains.annotations.Nullable;

/**
 * 字典项，与 字典表 是多对一的关系
 *
 * @author jhlz
 * @version x.x.x
 */
@Entity
public interface LeafDictItem extends BaseEntity, ID {

    /**
     * 字典 ID
     */
    @IdView("dict")
    Long dictId();

    /**
     * 字典键
     */
    String label();

    /**
     * 字典值
     */
    String value();

    /**
     * 状态：1正常，0禁用
     */
    int status();

    /**
     * 排序
     */
    int sortable();

    @Nullable
    @ManyToOne
    LeafDict dict();
}
