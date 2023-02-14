package com.leaf.system.repository;

import com.leaf.system.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 账户角色关联表(VebnUserRole)表数据库访问层
 *
 * @author jhlz
 * @since 2022-12-26 21:28:53
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    /**
     * 根据 id 删除数据
     *
     * @param id must not be {@literal null}.
     * @return 是否成功
     */
    boolean deleteUserRoleById(Long id);


    List<UserRole> findAllByUserId(Long userId);

}

