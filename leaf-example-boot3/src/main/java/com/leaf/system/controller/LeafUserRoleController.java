package controller;


import java.lang.Long;

import .entity.LeafUserRole;
import .service.LeafUserRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户-角色关联表控制层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@RestController
@RequestMapping("/leafUserRole")
public class LeafUserRoleController {

    /**
     * 获取用户-角色关联表列表(分页)
     */
    @GetMapping
    public Page<LeafUserRole> listPage(@RequestBody LeafUserRole leafUserRole,
                                       @PageableDefault(page = 0, size = 10) Pageable page) {
        return null;
    }

    /**
     * 获取用户-角色关联表
     */
    @GetMapping("/{id}")
    public LeafUserRole queryById(@PathVariable Long id) {
        return leafUserRoleService.findById(id);
    }

    /**
     * 添加用户-角色关联表
     */
    @PostMapping
    public void add(@RequestBody LeafUserRole leafUserRole) {
        leafUserRoleService.save(leafUserRole);
    }


    /**
     * 修改用户-角色关联表
     */
    @PutMapping
    public void edit(@RequestBody LeafUserRole leafUserRole) {
        leafUserRoleService.update(leafUserRole);
    }

    /**
     * 删除用户-角色关联表
     */
    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Long> ids) {
        leafUserRoleService.remove(ids);
    }

    private final LeafUserRoleService leafUserRoleService;

    public LeafUserRoleController(LeafUserRoleService leafUserRoleService) {
        this.leafUserRoleService = leafUserRoleService;
    }
}

