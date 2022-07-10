package com.market.web.controller.system;

import com.market.common.annotation.Log;
import com.market.common.core.controller.BaseController;
import com.market.common.core.domain.AjaxResult;
import com.market.common.enums.BusinessType;
import com.market.common.utils.poi.ExcelUtil;
import com.market.system.domain.GoodsType;
import com.market.system.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品类型表Controller
 *
 * @author jhlz
 * @date 2022-07-08
 */
@RestController
@RequestMapping("/system/type")
public class GoodsTypeController extends BaseController {
    @Autowired
    private IGoodsTypeService goodsTypeService;

    /**
     * 查询商品类型表列表
     */
    @PreAuthorize("@ss.hasPermi('system:type:list')")
    @GetMapping("/list")
    public AjaxResult list(GoodsType goodsType) {
        List<GoodsType> list = goodsTypeService.selectGoodsTypeList(goodsType);
        return AjaxResult.success(list);
    }

    /**
     * 导出商品类型表列表
     */
    @PreAuthorize("@ss.hasPermi('system:type:export')")
    @Log(title = "商品类型表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsType goodsType) {
        List<GoodsType> list = goodsTypeService.selectGoodsTypeList(goodsType);
        ExcelUtil<GoodsType> util = new ExcelUtil<GoodsType>(GoodsType.class);
        util.exportExcel(response, list, "商品类型表数据");
    }

    /**
     * 获取商品类型表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(goodsTypeService.selectGoodsTypeById(id));
    }

    /**
     * 新增商品类型表
     */
    @PreAuthorize("@ss.hasPermi('system:type:add')")
    @Log(title = "商品类型表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsType goodsType) {
        return toAjax(goodsTypeService.insertGoodsType(goodsType));
    }

    /**
     * 修改商品类型表
     */
    @PreAuthorize("@ss.hasPermi('system:type:edit')")
    @Log(title = "商品类型表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsType goodsType) {
        return toAjax(goodsTypeService.updateGoodsType(goodsType));
    }

    /**
     * 删除商品类型表
     */
    @PreAuthorize("@ss.hasPermi('system:type:remove')")
    @Log(title = "商品类型表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(goodsTypeService.deleteGoodsTypeByIds(ids));
    }
}
