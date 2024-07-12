package com.leaf.domain;

import org.babyfish.jimmer.sql.*;

import java.util.List;

/**
 * @author jhlz
 * @version x.x.x
 */
@Entity
public interface LeafPost extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long postId();

    /**
     * 岗位编码
     */
    String postCode();

    /**
     * 岗位名称
     */
    String postName();

    /**
     * 所属部门 ID
     */
    long deptId();

    @ManyToMany(mappedBy = "postList")
    List<LeafUser> userList();
}
