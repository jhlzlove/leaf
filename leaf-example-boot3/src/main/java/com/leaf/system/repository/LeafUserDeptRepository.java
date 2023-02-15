package com.leaf.system.repository;


import com.leaf.system.entity.LeafUserDept;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户部门关联表持久层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:32
 */
public interface LeafUserDeptRepository extends JpaRepository<LeafUserDept, Long> {

}

