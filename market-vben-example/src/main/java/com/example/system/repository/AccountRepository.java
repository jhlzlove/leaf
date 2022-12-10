package com.example.system.repository;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 帐户表(Account)表数据库访问层
 *
 * @author jhlz
 * @since 2022-11-20 20:04:35
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

}

