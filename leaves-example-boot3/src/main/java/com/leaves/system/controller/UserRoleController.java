package com.leaves.system.controller;

import com.leaves.system.domain.UserRole;
import com.leaves.system.service.UserRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author jhlz
 * @since 2022-12-26 21:28:53
 */
@RestController
@RequestMapping("UserRole")
public class UserRoleController {

    @GetMapping
    public ResponseEntity<Page<UserRole>> queryByPage(UserRole UserRole, PageRequest pageRequest) {
        return ResponseEntity.ok(UserRoleService.queryByPage(UserRole, pageRequest));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserRole> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(UserRoleService.queryById(id));
    }

    @PostMapping
    public ResponseEntity<UserRole> add(UserRole UserRole) {
        return ResponseEntity.ok(UserRoleService.insertOrUpdate(UserRole));
    }

    @PutMapping
    public ResponseEntity<UserRole> edit(UserRole UserRole) {
        return ResponseEntity.ok(UserRoleService.insertOrUpdate(UserRole));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(UserRoleService.deleteById(id));
    }

    private final UserRoleService UserRoleService;

    public UserRoleController(UserRoleService UserRoleService) {
        this.UserRoleService = UserRoleService;
    }
}

