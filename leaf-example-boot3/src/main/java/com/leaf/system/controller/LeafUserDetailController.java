package controller;


import java.lang.Long;

import .entity.LeafUserDetail;
import .service.LeafUserDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息表控制层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:04
 */
@RestController
@RequestMapping("/leafUserDetail")
public class LeafUserDetailController {

    /**
     * 获取用户信息表列表(分页)
     */
    @GetMapping
    public Page<LeafUserDetail> listPage(@RequestBody LeafUserDetail leafUserDetail,
                                         @PageableDefault(page = 0, size = 10) Pageable page) {
        return null;
    }

    /**
     * 获取用户信息表
     */
    @GetMapping("/{id}")
    public LeafUserDetail queryById(@PathVariable Long id) {
        return leafUserDetailService.findById(id);
    }

    /**
     * 添加用户信息表
     */
    @PostMapping
    public void add(@RequestBody LeafUserDetail leafUserDetail) {
        leafUserDetailService.save(leafUserDetail);
    }


    /**
     * 修改用户信息表
     */
    @PutMapping
    public void edit(@RequestBody LeafUserDetail leafUserDetail) {
        leafUserDetailService.update(leafUserDetail);
    }

    /**
     * 删除用户信息表
     */
    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Long> ids) {
        leafUserDetailService.remove(ids);
    }

    private final LeafUserDetailService leafUserDetailService;

    public LeafUserDetailController(LeafUserDetailService leafUserDetailService) {
        this.leafUserDetailService = leafUserDetailService;
    }
}

