package com.leaf.system.repository;


import com.leaf.system.entity.LeafDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 部门信息表持久层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:30
 */
@Repository
public interface LeafDeptRepository extends JpaRepository<LeafDept, Long> {

}

