package repository;


import java.lang.Long;

import .entity.LeafUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户登录信息表持久层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Repository
public interface LeafUserRepository extends JpaRepository<LeafUser, Long> {

}

