package com.example.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * sys_menu
 *
 * @author
 */
@Data
@Accessors(chain = true)
@Entity
@DynamicUpdate
@DynamicInsert
public class SysMenu extends BaseEntity {

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 显示顺序
     */
    private Integer orderNo;

    /**
     * 路由地址
     */
    private String routePath;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 路由参数
     */
    private String query;

    /**
     * 是否为外链（0是 1否）
     */
    private Integer isExt;

    /**
     * 是否缓存（0不缓存 1缓存）
     */
    private Integer keepalive;

    /**
     * 菜单类型（0目录 1菜单 2按钮）
     */
    private String menuType;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    private Integer visible;

    /**
     * 菜单状态（0正常 1停用）
     */
    private Integer status;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单子集，也可以使用 @Transient 注解表明此属性不映射到数据库
     * 这里使用一对多关系更加清晰
     */
    @OneToMany
    private List<SysMenu> children;

}