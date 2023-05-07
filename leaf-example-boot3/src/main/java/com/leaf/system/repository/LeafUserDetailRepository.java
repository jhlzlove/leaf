package repository;


import java.lang.Long;

import .entity.LeafUserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户信息表持久层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Repository
public interface LeafUserDetailRepository extends JpaRepository<LeafUserDetail, Long> {

}

