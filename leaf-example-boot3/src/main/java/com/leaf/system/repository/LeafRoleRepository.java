package repository;


import java.lang.Long;

import .entity.LeafRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色表持久层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Repository
public interface LeafRoleRepository extends JpaRepository<LeafRole, Long> {

}

