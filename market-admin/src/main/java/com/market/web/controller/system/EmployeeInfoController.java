package com.market.web.controller.system;

import com.market.common.annotation.Log;
import com.market.common.core.controller.BaseController;
import com.market.common.core.domain.AjaxResult;
import com.market.common.core.page.TableDataInfo;
import com.market.common.enums.BusinessType;
import com.market.common.utils.poi.ExcelUtil;
import com.market.system.domain.EmployeeInfo;
import com.market.system.service.IEmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 员工信息Controller
 *
 * @author jhlz
 * @date 2022-04-13
 */
@RestController
@RequestMapping("/system/employee")
public class EmployeeInfoController extends BaseController {
    @Autowired
    private IEmployeeInfoService tEmployeeInfoService;

    /**
     * 查询员工信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:employee:list')")
    @GetMapping("/list")
    public TableDataInfo list(EmployeeInfo tEmployeeInfo) {
        startPage();
        List<EmployeeInfo> list = tEmployeeInfoService.selectTEmployeeInfoList(tEmployeeInfo);
        return getDataTable(list);
    }

    /**
     * 导出员工信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:employee:export')")
    @Log(title = "员工信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EmployeeInfo tEmployeeInfo) {
        List<EmployeeInfo> list = tEmployeeInfoService.selectTEmployeeInfoList(tEmployeeInfo);
        ExcelUtil<EmployeeInfo> util = new ExcelUtil<EmployeeInfo>(EmployeeInfo.class);
        util.exportExcel(response, list, "员工信息数据");
    }

    /**
     * 获取员工信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:employee:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(tEmployeeInfoService.selectTEmployeeInfoById(id));
    }

    /**
     * 新增员工信息
     */
    @PreAuthorize("@ss.hasPermi('system:employee:add')")
    @Log(title = "员工信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EmployeeInfo tEmployeeInfo) {
        return toAjax(tEmployeeInfoService.insertTEmployeeInfo(tEmployeeInfo));
    }

    /**
     * 修改员工信息
     */
    @PreAuthorize("@ss.hasPermi('system:employee:edit')")
    @Log(title = "员工信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EmployeeInfo tEmployeeInfo) {
        return toAjax(tEmployeeInfoService.updateTEmployeeInfo(tEmployeeInfo));
    }

    /**
     * 删除员工信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "员工信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tEmployeeInfoService.deleteTEmployeeInfoByIds(ids));
    }
}
