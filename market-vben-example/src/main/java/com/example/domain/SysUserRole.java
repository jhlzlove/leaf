package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_user_role
 *
 * @author
 */
@Data
public class SysUserRole implements Serializable {
    private Long id;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 角色id
     */
    private Long rid;

    private static final long serialVersionUID = 1L;
}