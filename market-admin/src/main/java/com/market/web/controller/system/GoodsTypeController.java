package com.market.web.controller.system;

import com.market.common.annotation.Log;
import com.market.common.core.controller.BaseController;
import com.market.common.core.domain.AjaxResult;
import com.market.common.core.domain.entity.SysDictType;
import com.market.common.core.page.TableDataInfo;
import com.market.common.enums.BusinessType;
import com.market.system.domain.GoodsType;
import com.market.system.mapper.GoodsTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/type")
public class GoodsTypeController extends BaseController {

    @Autowired(required = false)
    private GoodsTypeMapper goodsTypeMapper;

    @PreAuthorize("@ss.hasPermi('system:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDictType dictType) {
        startPage();
        List<GoodsType> list = goodsTypeMapper.list();
        return getDataTable(list);
    }

    /**
     * 获取类型的详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id) {
        return AjaxResult.success(goodsTypeMapper.selectByPrimaryKey(id));
    }

    /**
     * 新增类型
     */
    @PreAuthorize("@ss.hasPermi('system:type:add')")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsType goodsType) {
        return toAjax(goodsTypeMapper.insertSelective(goodsType));
    }

    /**
     * 修改类型信息
     */
    @PreAuthorize("@ss.hasPermi('system:type:edit')")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsType goodsType) {
        return toAjax(goodsTypeMapper.updateByPrimaryKeySelective(goodsType));
    }

    /**
     * 删除类型信息
     */
    @PreAuthorize("@ss.hasPermi('system:type:remove')")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(goodsTypeMapper.deleteTypeByIds(ids));
    }

    /**
     * 查询商品类型
     */
    @PreAuthorize("@ss.hasPermi('system:type:list')")
    @GetMapping("/type/list")
    public AjaxResult getType() {
        return AjaxResult.success(goodsTypeMapper.list());
    }
}
