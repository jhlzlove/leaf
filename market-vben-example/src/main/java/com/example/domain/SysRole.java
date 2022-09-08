package com.example.domain;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @author jhlz
 * @since 2022-09-08 17:46:58
 */
@Data
@Entity
public class SysRole extends BaseEntity {

    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色权限字符串
     */
    private String roleValue;
    /**
     * 排序
     */
    private Integer orderNo;
    /**
     * 删除标志(0未删除；1删除)
     */
    private Boolean delFlag;
    /**
     * 状态（0停用；1启用）
     */
    private Boolean status;

}

