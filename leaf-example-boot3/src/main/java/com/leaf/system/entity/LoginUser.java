package com.leaf.system.entity;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
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

    private String username;

    private String password;

    private MutableList<LeafRole> roles = Lists.mutable.empty();

    public LoginUser() {
    }

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public List<LeafRole> getRoles() {
        return roles;
    }

    public void setRoles(MutableList<LeafRole> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        MutableList<SimpleGrantedAuthority> result = Lists.mutable.empty();
        roles.forEach(r -> {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(r.getZhName());
            result.add(authority);
        });
        return result;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return true;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
