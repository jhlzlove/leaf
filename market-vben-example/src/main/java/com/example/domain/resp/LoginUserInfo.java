package com.example.domain.resp;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author jhlz
 * @time 2022/9/7 12:39
 * @desc: LoginUserInfo
 * 登录用户信息
 */
@Data
@Accessors(chain = true)
public class LoginUserInfo implements UserDetails {

    List<String> rolesInfo = Arrays.asList("admin");
    private Long id;
    /**
     * 用户名
     */
    @JsonAlias("username")
    private String userName;

    /**
     * 部门 id
     */
    private Long deptId;

    /**
     * 密码
     */
    private String password;

    /**
     * token
     */
    private String token;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
