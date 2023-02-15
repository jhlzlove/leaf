package com.leaf.system.repository;


import com.leaf.system.entity.LeafDept;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 部门信息表持久层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:30
 */
public interface LeafDeptRepository extends JpaRepository<LeafDept, Long> {

}

