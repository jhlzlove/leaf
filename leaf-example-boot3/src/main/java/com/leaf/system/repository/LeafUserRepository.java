package com.leaf.system.repository;


import com.leaf.system.entity.LeafUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 用户信息表持久层
 *
 * @author jhlz
 * @since 2023-02-15 14:25:32
 */
@Repository
public interface LeafUserRepository extends JpaRepository<LeafUser, Long> {

    LeafUser findByUsername(String username);

    @Modifying
    @Query("update #{#entityName} u set u.password = ?2 where u.username = ?1")
    Integer updatePasswordByUsername(String username, String newPassword);
}

