package controller;


import java.lang.Long;

import .entity.LeafDict;
import .service.LeafDictService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典表控制层
 *
 * @author jhlz
 * @since 2023-05-07 14:29:03
 */
@RestController
@RequestMapping("/leafDict")
public class LeafDictController {

    /**
     * 获取字典表列表(分页)
     */
    @GetMapping
    public Page<LeafDict> listPage(@RequestBody LeafDict leafDict,
                                   @PageableDefault(page = 0, size = 10) Pageable page) {
        return null;
    }

    /**
     * 获取字典表
     */
    @GetMapping("/{id}")
    public LeafDict queryById(@PathVariable Long id) {
        return leafDictService.findById(id);
    }

    /**
     * 添加字典表
     */
    @PostMapping
    public void add(@RequestBody LeafDict leafDict) {
        leafDictService.save(leafDict);
    }


    /**
     * 修改字典表
     */
    @PutMapping
    public void edit(@RequestBody LeafDict leafDict) {
        leafDictService.update(leafDict);
    }

    /**
     * 删除字典表
     */
    @DeleteMapping("/{ids}")
    public void delete(@PathVariable List<Long> ids) {
        leafDictService.remove(ids);
    }

    private final LeafDictService leafDictService;

    public LeafDictController(LeafDictService leafDictService) {
        this.leafDictService = leafDictService;
    }
}

