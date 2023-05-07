package controller;


import java.lang.Long;

import .entity.LeafMenu;
import .service.LeafMenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单表控制层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
@RestController
@RequestMapping("/leafMenu")
public class LeafMenuController {

    /**
     * 获取菜单表列表(分页)
     */
    @GetMapping
    public Page<LeafMenu> listPage(@RequestBody LeafMenu leafMenu,
                                   @PageableDefault(page = 0, size = 10) Pageable page) {
        return null;
    }

    /**
     * 获取菜单表
     */
    @GetMapping("/{id}")
    public LeafMenu queryById(@PathVariable Long id) {
        return leafMenuService.findById(id);
    }

    /**
     * 添加菜单表
     */
    @PostMapping
    public void add(@RequestBody LeafMenu leafMenu) {
        leafMenuService.save(leafMenu);
    }


    /**
     * 修改菜单表
     */
    @PutMapping
    public void edit(@RequestBody LeafMenu leafMenu) {
        leafMenuService.update(leafMenu);
    }

    /**
     * 删除菜单表
     */
    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Long> ids) {
        leafMenuService.remove(ids);
    }

    private final LeafMenuService leafMenuService;

    public LeafMenuController(LeafMenuService leafMenuService) {
        this.leafMenuService = leafMenuService;
    }
}

