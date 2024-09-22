package com.leaf.domain;

import org.babyfish.jimmer.sql.Entity;

/**
 * @author jhlz
 * @version x.x.x
 */
@Entity
public interface LeafPost extends ID, BaseEntity {

    /**
     * 岗位编码
     */
    String code();

    /**
     * 岗位名称
     */
    String name();

    // @ManyToMany(mappedBy = "postList")
    // List<LeafUser> userList();
}
