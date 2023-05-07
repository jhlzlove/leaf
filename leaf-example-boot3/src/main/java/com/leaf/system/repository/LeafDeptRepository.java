package com.leaf.system.repository;


import java.lang.Long;

import com.leaf.system.entity.LeafDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 部门表持久层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:02
 */
@Repository
public interface LeafDeptRepository extends JpaRepository<LeafDept, Long> {

}

