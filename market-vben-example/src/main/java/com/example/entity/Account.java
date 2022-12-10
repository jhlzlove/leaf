package com.example.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 帐户表(Account)实体类
 *
 * @author jhlz
 * @since 2022-11-20 20:04:37
 */
@Entity
@Data
public class Account implements Serializable {
    private static final long serialVersionUID = -59485070490924360L;
    @Id
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 密码
     */
    private String password;
    /**
     * userId
     */
    private Long userId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 备注
     */
    private String remark;

}

