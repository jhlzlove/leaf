package com.market.web.controller.system;

import com.market.common.annotation.Log;
import com.market.common.core.controller.BaseController;
import com.market.common.core.domain.AjaxResult;
import com.market.common.core.page.TableDataInfo;
import com.market.common.enums.BusinessType;
import com.market.common.utils.poi.ExcelUtil;
import com.market.system.domain.GoodsInfo;
import com.market.system.service.IGoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品信息Controller
 *
 * @author jhlz
 * @date 2022-04-13
 */
@RestController
@RequestMapping("/system/goods")
public class GoodsInfoController extends BaseController {
    @Autowired
    private IGoodsInfoService tGoodsInfoService;

    /**
     * 查询商品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(GoodsInfo tGoodsInfo) {
        startPage();
        List<GoodsInfo> list = tGoodsInfoService.selectTGoodsInfoList(tGoodsInfo);
        return getDataTable(list);
    }

    /**
     * 导出商品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:goods:export')")
    @Log(title = "商品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsInfo tGoodsInfo) {
        List<GoodsInfo> list = tGoodsInfoService.selectTGoodsInfoList(tGoodsInfo);
        ExcelUtil<GoodsInfo> util = new ExcelUtil<GoodsInfo>(GoodsInfo.class);
        util.exportExcel(response, list, "商品信息数据");
    }

    /**
     * 获取商品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:goods:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(tGoodsInfoService.selectTGoodsInfoById(id));
    }

    /**
     * 新增商品信息
     */
    @PreAuthorize("@ss.hasPermi('system:goods:add')")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsInfo tGoodsInfo) {
        return toAjax(tGoodsInfoService.insertTGoodsInfo(tGoodsInfo));
    }

    /**
     * 修改商品信息
     */
    @PreAuthorize("@ss.hasPermi('system:goods:edit')")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsInfo tGoodsInfo) {
        return toAjax(tGoodsInfoService.updateTGoodsInfo(tGoodsInfo));
    }

    /**
     * 删除商品信息
     */
    @PreAuthorize("@ss.hasPermi('system:goods:remove')")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tGoodsInfoService.deleteTGoodsInfoByIds(ids));
    }
}
