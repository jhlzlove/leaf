package com.example.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import javax.persistence.Entity;

/**
 * sys_user
 *
 * @author
 */
@Data
@Entity
public class SysUser extends BaseEntity {

    /**
     * 用户名
     */
    @JsonAlias("username")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * token
     */
    private String token;

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
     * 描述
     */
    private String desc;

    /**
     * 是否启用(0：未启用；1：启用)
     */
    private Boolean enabled;
}