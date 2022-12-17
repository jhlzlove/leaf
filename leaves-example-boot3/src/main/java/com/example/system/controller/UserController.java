package com.example.system.controller;

import com.example.common.annotation.OperationLog;
import com.example.common.log.BusinessEnum;
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
    @OperationLog(operation = BusinessEnum.LIST_USER)
    @GetMapping
    @ApiOperation(value = "用户数据分页", notes = "分页展示用户数据")
    public ResponseEntity<Page<User>> queryByPage(User user, int pageIndex, int pageSize) {
        return ResponseEntity.ok(userService.queryByPage(user, pageIndex, pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @OperationLog(operation = BusinessEnum.GET_USER)
    @GetMapping("{id}")
    @ApiOperation(value = "获取指定用户", notes = "根据 id 获取用户")
    public ResponseEntity<User> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @OperationLog(operation = BusinessEnum.ADD_USER)
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
    @OperationLog(operation = BusinessEnum.UPDATE_USER)
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
    @OperationLog(operation = BusinessEnum.DELETE_USER)
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

