package com.leaf.domain;

import org.babyfish.jimmer.sql.*;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Entity
public interface LeafRole extends BaseEntity {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long roleId();

    String roleCode();

    String roleName();

    /**
     * 1 正常 0 禁用
     */
    int status();

}
