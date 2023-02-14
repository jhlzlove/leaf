package com.leaf.system.repository;

import com.leaf.system.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户信息表(User)表数据库访问层
 *
 * @author jhlz
 * @since 2022-12-11 13:46:28
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据 username 获取用户
     *
     * @param userName 用户名
     * @return 用户对象
     */
    User findByUserName(String userName);
}

