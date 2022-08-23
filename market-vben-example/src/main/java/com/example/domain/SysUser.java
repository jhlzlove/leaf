package com.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * sys_user
 *
 * @author
 */
@Data
public class SysUser implements Serializable {
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 删除标志(0：未删除；1：删除)
     */
    private Boolean delFlag;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 是否启用(0：未启用；1：启用)
     */
    private Boolean enabled;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

}