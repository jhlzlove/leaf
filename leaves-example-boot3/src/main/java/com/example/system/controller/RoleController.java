package com.example.system.controller;

import com.example.system.domain.Role;
import com.example.system.service.RoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author jhlz
 * @since 2022-12-26 17:56:03
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @GetMapping
    public ResponseEntity<Page<Role>> queryByPage(Role role, PageRequest pageRequest) {
        return ResponseEntity.ok(roleService.queryByPage(role, pageRequest));
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(roleService.queryById(id));
    }

    @PostMapping
    public ResponseEntity<Role> add(Role role) {
        return ResponseEntity.ok(roleService.insertOrUpdate(role));
    }

    @PutMapping
    public ResponseEntity<Role> edit(Role role) {
        return ResponseEntity.ok(roleService.insertOrUpdate(role));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(roleService.deleteById(id));
    }

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
}

