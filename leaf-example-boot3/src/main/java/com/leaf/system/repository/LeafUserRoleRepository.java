package com.leaf.system.repository;


import com.leaf.system.domain.LeafUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户-角色关联表持久层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Repository
public interface LeafUserRoleRepository extends JpaRepository<LeafUserRole, Long> {

}

