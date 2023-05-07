package com.leaf.system.repository;


import com.leaf.system.domain.LeafMenuRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 菜单-角色关联表持久层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
@Repository
public interface LeafMenuRoleRepository extends JpaRepository<LeafMenuRole, Long> {

}

