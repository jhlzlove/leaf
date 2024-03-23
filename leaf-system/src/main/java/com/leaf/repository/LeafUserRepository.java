package com.leaf.repository;


import com.leaf.domain.LeafUser;
import org.babyfish.jimmer.spring.repository.JRepository;

/**
 * 用户登录信息表持久层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
public interface LeafUserRepository extends JRepository<LeafUser, Long> {

}

