package com.example.system.controller;

import com.example.system.domain.User;
import com.example.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author jhlz
 * @since 2022-12-11 13:46:28
 */
@Api(value = "user 管理模块", tags = "用户模块")
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * 分页查询
     *
     * @param user      筛选条件
     * @param pageIndex 第几页
     * @param pageSize  每页记录数
     * @return 查询结果
     */
    @GetMapping
    @ApiOperation(value = "用户数据分页", notes = "interface operation details")
    public ResponseEntity<Page<User>> queryByPage(User user, int pageIndex, int pageSize) {
        return ResponseEntity.ok(userService.queryByPage(user, pageIndex, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation(value = "获取指定用户", notes = "interface operation details")
    public ResponseEntity<User> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation(value = "添加用户", notes = "interface operation details")
    public ResponseEntity<User> add(@RequestBody User user) {
        return ResponseEntity.ok(userService.insertOrUpdate(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    @ApiOperation(value = "编辑用户", notes = "interface operation details")
    public ResponseEntity<User> edit(@RequestBody User user) {
        return ResponseEntity.ok(userService.insertOrUpdate(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    @ApiOperation(value = "删除用户", notes = "interface operation details")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("nice");
    }


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}

