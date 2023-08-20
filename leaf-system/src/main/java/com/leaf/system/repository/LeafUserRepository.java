package com.leaf.system.repository;


import com.leaf.system.domain.LeafUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 用户登录信息表持久层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@Repository
public interface LeafUserRepository extends JpaRepository<LeafUser, Long> {

    LeafUser findByUsername(String username);

    @Modifying
    @Query("update leaf_user set password = ?2 where username = ?1")
    boolean updatePasswordByUsername(String username, String newPassword);
}

