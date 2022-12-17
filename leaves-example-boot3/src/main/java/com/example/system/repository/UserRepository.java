package com.example.system.repository;

import com.example.system.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户信息表(User)表数据库访问层
 *
 * @author jhlz
 * @since 2022-12-11 13:46:28
 */
public interface UserRepository extends JpaRepository<User, Long> {

}

