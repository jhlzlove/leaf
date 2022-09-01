package com.example.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * sys_role
 *
 * @author
 */
@Data
@Accessors(chain = true)
public class SysRole implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色权限字符串
     */
    private String roleKey;

    /**
     * 删除标志(0：未删除；1：删除)
     */
    private Boolean delFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;
}