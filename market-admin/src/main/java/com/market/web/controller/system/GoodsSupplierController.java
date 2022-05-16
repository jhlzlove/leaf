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
 * 供货商信息Controller
 *
 * @author jhlz
 * @date 2022-04-13
 */
@RestController
@RequestMapping("/system/supplier")
public class GoodsSupplierController extends BaseController {
    @Autowired
    private IGoodsSupplierService tGoodsSupplierService;

    /**
     * 查询供货商信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(GoodsSupplier tGoodsSupplier) {
        startPage();
        List<GoodsSupplier> list = tGoodsSupplierService.selectTGoodsSupplierList(tGoodsSupplier);
        return getDataTable(list);
    }

    /**
     * 导出供货商信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:export')")
    @Log(title = "供货商信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsSupplier tGoodsSupplier) {
        List<GoodsSupplier> list = tGoodsSupplierService.selectTGoodsSupplierList(tGoodsSupplier);
        ExcelUtil<GoodsSupplier> util = new ExcelUtil<GoodsSupplier>(GoodsSupplier.class);
        util.exportExcel(response, list, "供货商信息数据");
    }

    /**
     * 获取供货商信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(tGoodsSupplierService.selectTGoodsSupplierById(id));
    }

    /**
     * 新增供货商信息
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:add')")
    @Log(title = "供货商信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsSupplier tGoodsSupplier) {
        return toAjax(tGoodsSupplierService.insertTGoodsSupplier(tGoodsSupplier));
    }

    /**
     * 修改供货商信息
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:edit')")
    @Log(title = "供货商信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsSupplier tGoodsSupplier) {
        return toAjax(tGoodsSupplierService.updateTGoodsSupplier(tGoodsSupplier));
    }

    /**
     * 删除供货商信息
     */
    @PreAuthorize("@ss.hasPermi('system:supplier:remove')")
    @Log(title = "供货商信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tGoodsSupplierService.deleteTGoodsSupplierByIds(ids));
    }
}
