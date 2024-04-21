package com.leaf.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author jhlz
 * @version 1.0.0
 */
@Data
public class LoginUser implements UserDetails {

    private String username;
    private String password;
    /**
     * 状态：1 正常，0 禁用
     */
    private Integer status;

    public record UserRecord(String username,
                             String password,
                             Integer status) {

    }

    private List<String> permission = new ArrayList<>();

    public LoginUser() {
    }

    public LoginUser(UserRecord user, List<String> permission) {
        this.username = user.username();
        this.password = user.password();
        this.status = user.status();
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
        return status == 1;
    }

}
