package com.leaf.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
public interface LeafDept extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long deptId();

    /**
     * 部门名称
     */
    String deptName();

    /**
     * 父级部门 ID
     */
    Long parentId();

    /**
     * 部门编码
     */
    String deptCode();

    /**
     * 部门领导
     */
    Long leaderId();

    /**
     * 部门描述
     */
    @Nullable
    String description();

    /**
     * 状态：1正常，0禁用
     */
    int status();

    /**
     * 排序
     */
    Integer sortable();

    /**
     * 部门关联角色
     */
    Long roleId();

    @ManyToMany(mappedBy = "deptList")
    List<LeafUser> userList();
}
