package controller;


import java.lang.Long;

import .entity.LeafMenuRole;
import .service.LeafMenuRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单-角色关联表控制层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
@RestController
@RequestMapping("/leafMenuRole")
public class LeafMenuRoleController {

    /**
     * 获取菜单-角色关联表列表(分页)
     */
    @GetMapping
    public Page<LeafMenuRole> listPage(@RequestBody LeafMenuRole leafMenuRole,
                                       @PageableDefault(page = 0, size = 10) Pageable page) {
        return null;
    }

    /**
     * 获取菜单-角色关联表
     */
    @GetMapping("/{id}")
    public LeafMenuRole queryById(@PathVariable Long id) {
        return leafMenuRoleService.findById(id);
    }

    /**
     * 添加菜单-角色关联表
     */
    @PostMapping
    public void add(@RequestBody LeafMenuRole leafMenuRole) {
        leafMenuRoleService.save(leafMenuRole);
    }


    /**
     * 修改菜单-角色关联表
     */
    @PutMapping
    public void edit(@RequestBody LeafMenuRole leafMenuRole) {
        leafMenuRoleService.update(leafMenuRole);
    }

    /**
     * 删除菜单-角色关联表
     */
    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Long> ids) {
        leafMenuRoleService.remove(ids);
    }

    private final LeafMenuRoleService leafMenuRoleService;

    public LeafMenuRoleController(LeafMenuRoleService leafMenuRoleService) {
        this.leafMenuRoleService = leafMenuRoleService;
    }
}

