package com.leaf.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author jhlz
 * @since 1.0.0
 */
public class LoginUser implements UserDetails {

    private String username;
    private String password;
    /**
     * 状态：0 正常，1 禁用
     */
    private Integer status;

    /**
     * 是否删除：0 正常；1 删除
     */
    private Integer delFlag;

    public record UserRecord(String username,
                             String password,
                             Integer status,
                             Integer delFlag) {

    }

    private List<String> permission = new ArrayList<>();

    public List<String> getPermission() {
        return this.permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }

    public LoginUser() {
    }

    public LoginUser(UserRecord user, List<String> permission) {
        this.username = user.username();
        this.password = user.password();
        this.status = user.status();
        this.delFlag = user.delFlag();
        this.permission = permission;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permission.stream().map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
        return status == 0;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
