package repository;


import java.lang.Long;

import .entity.LeafDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 字典表持久层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
@Repository
public interface LeafDictRepository extends JpaRepository<LeafDict, Long> {

}

