package com.example.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import java.util.Collection;

/**
 * sys_user
 *
 * @author
 */
@Data
@Accessors(chain = true)
@Entity
public class SysUser extends BaseEntity implements UserDetails {

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
     * 是否启用(0：未启用；1：启用)
     */
    private Boolean enabled;

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