package com.leaves.system.domain;

import jakarta.persistence.Entity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 账户角色关联表(VebnUserRole)实体类
 *
 * @author jhlz
 * @since 2022-12-26 21:28:53
 */
@Entity(name = "vben_user_role")
@DynamicInsert
@DynamicUpdate
public class UserRole extends BaseEntity {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 角色id
     */
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}

