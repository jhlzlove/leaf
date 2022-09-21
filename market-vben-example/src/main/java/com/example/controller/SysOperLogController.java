package com.example.controller;

import com.example.domain.SysOperLog;
import com.example.service.SysOperLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author jhlz
 * @since 2022-09-11 16:49:04
 */
@Api(value = "SysOperLogController", tags = "操作日志")
@RestController
@RequestMapping("system/log")
public class SysOperLogController {

    @GetMapping
    @ApiOperation(value = "listByPage", notes = "分页查询")
    public ResponseEntity<Page<SysOperLog>> listByPage(SysOperLog sysOperLog, int page, int pageSize) {
        return ResponseEntity.ok(this.sysOperLogService.listByPage(sysOperLog, page, pageSize));
    }

    @GetMapping("{id}")
    @ApiOperation(value = "getById", notes = "根据id查询")
    public ResponseEntity<SysOperLog> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.sysOperLogService.findById(id));
    }

    @DeleteMapping
    @ApiOperation(value = "delete", notes = "删除")
    public void deleteById(Long id) {
        sysOperLogService.deleteById(id);
    }

    private final SysOperLogService sysOperLogService;

    public SysOperLogController(SysOperLogService sysOperLogService) {
        this.sysOperLogService = sysOperLogService;
    }
}

