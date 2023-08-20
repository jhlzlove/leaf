package com.leaf.system.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


/**
 * 用户-角色关联表(LeafUserRole)实体类
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Entity(name = "leaf_user_role")
@DynamicInsert
@DynamicUpdate
public class LeafUserRole implements Serializable {
    @Serial
    private static final long serialVersionUID = 808279954826210799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 角色id
     */
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "LeafUserRole{" +
                "id=" + id + "," +
                "userId=" + userId + "," +
                "roleId=" + roleId +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeafUserRole leafUserRole = (LeafUserRole) o;
        return
                Objects.equals(id, leafUserRole.id) &&
                        Objects.equals(userId, leafUserRole.userId) &&
                        Objects.equals(roleId, leafUserRole.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, roleId);
    }

}

