package com.leaf.system.repository;

import com.leaf.system.domain.LeafRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jhlz
 * @version 0.0.1
 * @since 2023/9/18 12:01
 */
@Repository
public interface LeafRoleRepository extends JpaRepository<LeafRole, Long> {

}
