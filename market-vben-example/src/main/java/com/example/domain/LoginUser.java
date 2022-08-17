package com.market.example.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author clf
 * @time 2022/8/13 10:33
 * @desc: CustomerUserDetails
 * 自定义 Spring Security UserDetails 对象的封装实现
 */
public class LoginUser implements UserDetails {
    private static final long serialVersionUID = 1L;

    private SysUser user;

    public LoginUser() {
    }

    public LoginUser(SysUser user) {
        this.user = user;
    }

    private List<String> roles = new ArrayList<>();

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grantedAuthorities =
                roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return grantedAuthorities;
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
}