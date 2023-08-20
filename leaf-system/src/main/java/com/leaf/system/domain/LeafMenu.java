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
 * 菜单表(LeafMenu)实体类
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
@Entity(name = "leaf_menu")
@DynamicInsert
@DynamicUpdate
public class LeafMenu implements Serializable {
    @Serial
    private static final long serialVersionUID = 680208274913281871L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单地址
     */
    private String menuUrl;
    /**
     * 父菜单id
     */
    private Long parentId;
    /**
     * 菜单图标
     */
    private String menuIcon;
    /**
     * 菜单类型：D目录，M菜单，B按钮
     */
    private String menuType;
    /**
     * 菜单显示顺序
     */
    private Long orderNum;
    /**
     * 状态：1正常，0禁用
     */
    private Integer status;
    /**
     * 权限字符
     */
    private String permission;


    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "LeafMenu{" +
                "menuId=" + menuId + "," +
                "menuName=" + menuName + "," +
                "menuUrl=" + menuUrl + "," +
                "parentId=" + parentId + "," +
                "menuIcon=" + menuIcon + "," +
                "menuType=" + menuType + "," +
                "orderNum=" + orderNum + "," +
                "status=" + status + "," +
                "permission=" + permission +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeafMenu leafMenu = (LeafMenu) o;
        return
                Objects.equals(menuId, leafMenu.menuId) &&
                        Objects.equals(menuName, leafMenu.menuName) &&
                        Objects.equals(menuUrl, leafMenu.menuUrl) &&
                        Objects.equals(parentId, leafMenu.parentId) &&
                        Objects.equals(menuIcon, leafMenu.menuIcon) &&
                        Objects.equals(menuType, leafMenu.menuType) &&
                        Objects.equals(orderNum, leafMenu.orderNum) &&
                        Objects.equals(status, leafMenu.status) &&
                        Objects.equals(permission, leafMenu.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, menuName, menuUrl, parentId, menuIcon, menuType, orderNum, status, permission);
    }

}

