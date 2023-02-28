package com.leaf.system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

/**
 * 用户信息表(LeafUser)实体类
 *
 * @author jhlz
 * @since 2023-02-15 14:25:31
 */
@Entity(name = "leaf_user")
public class LeafUser extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -83128214293345737L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 登录账户
     */
    @NotBlank(message = "用户名不能为空且不能包含空格！")
    private String username;
    /**
     * 登录密码
     */
    @NotEmpty
    private String password;

    @Transient
    private List<LeafRole> roles;

    @Transient
    private List<LeafDept> depts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<LeafRole> getRoles() {
        return roles;
    }

    public void setRoles(List<LeafRole> roles) {
        this.roles = roles;
    }

    public List<LeafDept> getDepts() {
        return depts;
    }

    public void setDepts(List<LeafDept> depts) {
        this.depts = depts;
    }

    @Override
    public String toString() {
        return "LeafUser{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeafUser leafUser = (LeafUser) o;
        return Objects.equals(id, leafUser.id) && Objects.equals(realName, leafUser.realName) && Objects.equals(username, leafUser.username) && Objects.equals(password, leafUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, realName, username, password);
    }
}

