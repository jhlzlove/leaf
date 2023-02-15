package com.leaf.system.repository;


import com.leaf.system.entity.LeafUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 持久层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:32
 */
public interface LeafUserRoleRepository extends JpaRepository<LeafUserRole, Long> {

}

