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
    private LeafUser user;
    private List<String> permission = new ArrayList<>();

    public LeafUser getUser() {
        return user;
    }

    public void setUser(LeafUser user) {
        this.user = user;
    }

    public List<String> getPermission() {
        return this.permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }

    public LoginUser() {
    }

    public LoginUser(LeafUser user) {
        this.user = user;
    }

    public LoginUser(LeafUser user, List<String> permission) {
        this.user = user;
        this.permission = permission;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permission.stream().map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
        return user.getStatus() == 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginUser{");
        sb.append("user=").append(user);
        sb.append(", permission=").append(permission);
        sb.append('}');
        return sb.toString();
    }
}
