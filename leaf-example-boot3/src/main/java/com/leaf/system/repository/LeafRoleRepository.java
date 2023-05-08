package com.leaf.system.repository;


import com.leaf.system.domain.LeafRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色表持久层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Repository
public interface LeafRoleRepository extends JpaRepository<LeafRole, Long> {

    @Query("select r.roleName,r.roleCode, r.roleId from leaf_role r left join leaf_user_role lur on r.roleId = lur.roleId where lur.userId = :userId")
    List<LeafRole> findAllByUserId(@Param("userId") Long userId);
}

