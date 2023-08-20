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
 * 菜单-角色关联表(LeafMenuRole)实体类
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
@Entity(name = "leaf_menu_role")
@DynamicInsert
@DynamicUpdate
public class LeafMenuRole implements Serializable {
    @Serial
    private static final long serialVersionUID = 372959706477070323L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 菜单id
     */
    private Long menuId;
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

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "LeafMenuRole{" +
                "id=" + id + "," +
                "menuId=" + menuId + "," +
                "roleId=" + roleId +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeafMenuRole leafMenuRole = (LeafMenuRole) o;
        return
                Objects.equals(id, leafMenuRole.id) &&
                        Objects.equals(menuId, leafMenuRole.menuId) &&
                        Objects.equals(roleId, leafMenuRole.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuId, roleId);
    }

}

