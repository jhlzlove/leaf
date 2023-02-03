package com.leaves.system.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * 登录请求体
 *
 * @author jhlz
 * @since 2022/12/20 20:48
 */
public class LoginUser implements UserDetails {

    private User user;

    private List<String> permissions;

    public List<String> getPermissions() {
        return permissions;
    }

    public LoginUser setPermissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public User getUser() {
        return user;
    }

    public LoginUser setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions.stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
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
        return true;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "user=" + user +
                '}';
    }
}
