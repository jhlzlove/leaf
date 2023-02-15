package com.leaf.system.repository;


import com.leaf.system.entity.LeafUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户信息表持久层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:32
 */
public interface LeafUserRepository extends JpaRepository<LeafUser, Long> {

}

