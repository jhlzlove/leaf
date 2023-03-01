package com.leaf.system.repository;


import com.leaf.system.entity.LeafRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色信息表持久层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:31
 */
@Repository
public interface LeafRoleRepository extends JpaRepository<LeafRole, Long> {

}

