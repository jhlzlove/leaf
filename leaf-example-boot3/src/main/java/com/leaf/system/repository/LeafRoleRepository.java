package com.leaf.system.repository;


import com.leaf.system.entity.LeafRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 角色信息表持久层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:31
 */
public interface LeafRoleRepository extends JpaRepository<LeafRole, Long> {

}

