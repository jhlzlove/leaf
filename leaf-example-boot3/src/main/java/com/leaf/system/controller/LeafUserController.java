package controller;


import java.lang.Long;

import .entity.LeafUser;
import .service.LeafUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户登录信息表控制层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@RestController
@RequestMapping("/leafUser")
public class LeafUserController {

    /**
     * 获取用户登录信息表列表(分页)
     */
    @GetMapping
    public Page<LeafUser> listPage(@RequestBody LeafUser leafUser,
                                   @PageableDefault(page = 0, size = 10) Pageable page) {
        return null;
    }

    /**
     * 获取用户登录信息表
     */
    @GetMapping("/{id}")
    public LeafUser queryById(@PathVariable Long id) {
        return leafUserService.findById(id);
    }

    /**
     * 添加用户登录信息表
     */
    @PostMapping
    public void add(@RequestBody LeafUser leafUser) {
        leafUserService.save(leafUser);
    }


    /**
     * 修改用户登录信息表
     */
    @PutMapping
    public void edit(@RequestBody LeafUser leafUser) {
        leafUserService.update(leafUser);
    }

    /**
     * 删除用户登录信息表
     */
    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Long> ids) {
        leafUserService.remove(ids);
    }

    private final LeafUserService leafUserService;

    public LeafUserController(LeafUserService leafUserService) {
        this.leafUserService = leafUserService;
    }
}

