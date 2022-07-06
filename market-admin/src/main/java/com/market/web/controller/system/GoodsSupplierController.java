package com.market.web.controller.system;

import com.market.common.annotation.Log;
import com.market.common.core.controller.BaseController;
import com.market.common.core.domain.AjaxResult;
import com.market.common.core.page.TableDataInfo;
import com.market.common.enums.BusinessType;
import com.market.common.utils.poi.ExcelUtil;
import com.market.system.domain.GoodsSupplier;
import com.market.system.service.IGoodsSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 供应商信息表Controller
 *
 * @author jhlz
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/system/supplier")
public class GoodsSupplierController extends BaseController {
    @Autowired
    private IGoodsSupplierService goodsSupplierService;

    /**
     * 查询供应商信息表列表
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(GoodsSupplier goodsSupplier) {
        startPage();
        List<GoodsSupplier> list = goodsSupplierService.selectGoodsSupplierList(goodsSupplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商信息表列表
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:export')")
    @Log(title = "供应商信息表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsSupplier goodsSupplier) {
        List<GoodsSupplier> list = goodsSupplierService.selectGoodsSupplierList(goodsSupplier);
        ExcelUtil<GoodsSupplier> util = new ExcelUtil<GoodsSupplier>(GoodsSupplier.class);
        util.exportExcel(response, list, "供应商信息表数据");
    }

    /**
     * 获取供应商信息表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(goodsSupplierService.selectGoodsSupplierById(id));
    }

    /**
     * 新增供应商信息表
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:add')")
    @Log(title = "供应商信息表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsSupplier goodsSupplier) {
        return toAjax(goodsSupplierService.insertGoodsSupplier(goodsSupplier));
    }

    /**
     * 修改供应商信息表
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:edit')")
    @Log(title = "供应商信息表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsSupplier goodsSupplier) {
        return toAjax(goodsSupplierService.updateGoodsSupplier(goodsSupplier));
    }

    /**
     * 删除供应商信息表
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:remove')")
    @Log(title = "供应商信息表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(goodsSupplierService.deleteGoodsSupplierByIds(ids));
    }
}
