package com.leaf.domain;

import org.babyfish.jimmer.sql.*;
import org.jetbrains.annotations.Nullable;

/**
 * @author jhlz
 * @version 0.0.1
 * @since 2023/9/18 11:57
 */
@Entity
public interface LeafRole extends BaseEntity {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long roleId();

    String roleCode();

    @Nullable
    String pCode();
    
    String roleName();

    Integer status();

}
