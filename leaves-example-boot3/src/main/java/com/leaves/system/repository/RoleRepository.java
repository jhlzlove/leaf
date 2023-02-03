package com.leaves.system.repository;

import com.leaves.system.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 角色表(Role)表数据库访问层
 *
 * @author jhlz
 * @since 2022-12-26 17:56:03
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * 根据 id 删除数据
     *
     * @param id must not be {@literal null}.
     * @return 是否成功
     */
    boolean deleteRoleById(Long id);

}

