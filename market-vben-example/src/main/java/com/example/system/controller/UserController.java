package com.example.system.controller;

import com.example.system.domain.User;
import com.example.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author jhlz
 * @since 2022-12-11 13:46:28
 */
@Api(value = "user 管理模块", tags = "dev")
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    @ApiOperation(tags = "dev", value = "short desc", notes = "interface operation details")
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation(tags = "dev", value = "short desc", notes = "interface operation details")
    public ResponseEntity<User> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation(tags = "dev", value = "short desc", notes = "interface operation details")
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insertOrUpdate(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    @ApiOperation(tags = "dev", value = "short desc", notes = "interface operation details")
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.insertOrUpdate(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    @ApiOperation(tags = "dev", value = "short desc", notes = "interface operation details")
    public ResponseEntity<String> deleteById(Long id) {
        this.userService.deleteById(id);
        return ResponseEntity.ok("nice");
    }


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}

