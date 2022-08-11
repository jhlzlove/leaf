package com.market.example.domain;

import java.io.Serializable;

/**
 * sys_role
 *
 * @author
 */
public class SysRole implements Serializable {
    private Integer id;

    /**
     * 英文角色
     */
    private String role;

    /**
     * 中文角色
     */
    private String name;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}