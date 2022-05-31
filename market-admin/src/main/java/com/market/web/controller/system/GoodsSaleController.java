package com.market.web.controller.system;

import com.market.common.annotation.Log;
import com.market.common.core.controller.BaseController;
import com.market.common.core.domain.AjaxResult;
import com.market.common.core.page.TableDataInfo;
import com.market.common.enums.BusinessType;
import com.market.common.utils.poi.ExcelUtil;
import com.market.system.domain.GoodsSale;
import com.market.system.service.IGoodsSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品销售Controller
 *
 * @author jhlz
 * @date 2022-04-13
 */
@RestController
@RequestMapping("/system/sale")
public class GoodsSaleController extends BaseController {
    @Autowired
    private IGoodsSaleService goodsSaleService;

    /**
     * 查询商品销售列表
     */
    @PreAuthorize("@ss.hasPermi('system:sale:list')")
    @GetMapping("/list")
    public TableDataInfo list(GoodsSale goodsSale) {
        startPage();
        List<GoodsSale> list = goodsSaleService.selectTGoodsSaleList(goodsSale);
        return getDataTable(list);
    }

    /**
     * 导出商品销售列表
     */
    @PreAuthorize("@ss.hasPermi('system:sale:export')")
    @Log(title = "商品销售", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsSale tGoodsSale) {
        List<GoodsSale> list = goodsSaleService.selectTGoodsSaleList(tGoodsSale);
        ExcelUtil<GoodsSale> util = new ExcelUtil<GoodsSale>(GoodsSale.class);
        util.exportExcel(response, list, "商品销售数据");
    }

    /**
     * 获取商品销售详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sale:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(goodsSaleService.selectTGoodsSaleById(id));
    }

    /**
     * 新增商品销售
     */
    @PreAuthorize("@ss.hasPermi('system:sale:add')")
    @Log(title = "商品销售", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsSale tGoodsSale) {
        return toAjax(goodsSaleService.insertTGoodsSale(tGoodsSale));
    }

    /**
     * 修改商品销售
     */
    @PreAuthorize("@ss.hasPermi('system:sale:edit')")
    @Log(title = "商品销售", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsSale tGoodsSale) {
        return toAjax(goodsSaleService.updateTGoodsSale(tGoodsSale));
    }

    /**
     * 删除商品销售
     */
    @PreAuthorize("@ss.hasPermi('system:sale:remove')")
    @Log(title = "商品销售", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(goodsSaleService.deleteTGoodsSaleByIds(ids));
    }
}
