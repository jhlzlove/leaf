package com.leaf.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
@Table(name = "leaf_dept")
public interface LeafDept extends BaseEntity, ID {

    /**
     * 部门名称
     */
    @Key
    String deptName();

    /**
     * 父级部门 ID
     */
    Long parentId();

    /**
     * 部门领导
     */
    long leaderId();

    /**
     * 部门描述
     */
    @Nullable
    String description();

    /**
     * 状态：0正常，1禁用
     */
    int status();

    /**
     * 排序
     */
    int sortable();

    /**
     * 父级列表
     */
    @Nullable
    String ancestors();

    @OneToMany(mappedBy = "dept")
    List<LeafUser> userList();
}
