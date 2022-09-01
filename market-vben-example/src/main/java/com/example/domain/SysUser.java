package com.example.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * sys_user
 *
 * @author
 */
@Data
@Accessors(chain = true)
@Entity
public class SysUser implements UserDetails {

    @Id
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    /**
     * 账户没有过期？
     *
     * @return true ? no : yes
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户被锁定了？
     *
     * @return true ? no : yes
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 凭证信息过期了？
     *
     * @return true ? no : yes
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否启用
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}