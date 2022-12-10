package com.example.system.controller;

import com.example.entity.Account;
import com.example.system.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jhlz
 * @since 2022-11-20 20:04:35
 */
@Api(value = "", tags = "dev")
@RestController
@RequestMapping("account")
public class AccountController {

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation(tags = "dev", value = "short desc", notes = "interface operation details")
    public ResponseEntity<Account> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.accountService.queryById(id));
    }

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
}

