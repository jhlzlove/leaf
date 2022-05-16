package com.market.web.controller.system;

import com.market.common.annotation.Log;
import com.market.common.core.controller.BaseController;
import com.market.common.core.domain.AjaxResult;
import com.market.common.core.page.TableDataInfo;
import com.market.common.enums.BusinessType;
import com.market.common.utils.poi.ExcelUtil;
import com.market.system.domain.GoodsRecord;
import com.market.system.service.IGoodsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 记录Controller
 *
 * @author jhlz
 * @date 2022-04-13
 */
@RestController
@RequestMapping("/system/record")
public class GoodsRecordController extends BaseController {
    @Autowired
    private IGoodsRecordService tGoodsRecordService;

    /**
     * 查询记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(GoodsRecord tGoodsRecord) {
        startPage();
        List<GoodsRecord> list = tGoodsRecordService.selectTGoodsRecordList(tGoodsRecord);
        return getDataTable(list);
    }

    /**
     * 导出记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:export')")
    @Log(title = "记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsRecord tGoodsRecord) {
        List<GoodsRecord> list = tGoodsRecordService.selectTGoodsRecordList(tGoodsRecord);
        ExcelUtil<GoodsRecord> util = new ExcelUtil<GoodsRecord>(GoodsRecord.class);
        util.exportExcel(response, list, "记录数据");
    }

    /**
     * 获取记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(tGoodsRecordService.selectTGoodsRecordById(id));
    }

    /**
     * 新增记录
     */
    @PreAuthorize("@ss.hasPermi('system:record:add')")
    @Log(title = "记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsRecord tGoodsRecord) {
        return toAjax(tGoodsRecordService.insertTGoodsRecord(tGoodsRecord));
    }

    /**
     * 修改记录
     */
    @PreAuthorize("@ss.hasPermi('system:record:edit')")
    @Log(title = "记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsRecord tGoodsRecord) {
        return toAjax(tGoodsRecordService.updateTGoodsRecord(tGoodsRecord));
    }

    /**
     * 删除记录
     */
    @PreAuthorize("@ss.hasPermi('system:record:remove')")
    @Log(title = "记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tGoodsRecordService.deleteTGoodsRecordByIds(ids));
    }
}
