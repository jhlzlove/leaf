package com.example.system.service;

import com.example.entity.Account;

/**
 * 帐户表(Account)表服务接口
 *
 * @author jhlz
 * @since 2022-11-20 20:04:39
 */
public interface AccountService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Account queryById(Long id);

}
