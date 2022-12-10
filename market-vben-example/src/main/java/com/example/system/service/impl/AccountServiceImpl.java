package com.example.system.service.impl;

import com.example.entity.Account;
import com.example.system.repository.AccountRepository;
import com.example.system.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * 帐户表(Account)表服务实现类
 *
 * @author jhlz
 * @since 2022-11-20 20:04:41
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Account queryById(Long id) {
        return this.accountRepository.findById(id).orElseGet(Account::new);
    }


    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
