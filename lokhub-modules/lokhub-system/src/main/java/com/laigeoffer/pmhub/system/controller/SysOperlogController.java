package com.laigeoffer.lokhub.system.controller;

import com.laigeoffer.lokhub.base.core.annotation.Log;
import com.laigeoffer.lokhub.base.core.core.controller.BaseController;
import com.laigeoffer.lokhub.base.core.core.domain.AjaxResult;
import com.laigeoffer.lokhub.base.core.core.domain.entity.SysOperLog;
import com.laigeoffer.lokhub.base.core.core.page.TableDataInfo;
import com.laigeoffer.lokhub.base.core.enums.BusinessType;
import com.laigeoffer.lokhub.base.core.utils.poi.ExcelUtil;
import com.laigeoffer.lokhub.base.security.annotation.RequiresPermissions;
import com.laigeoffer.lokhub.system.service.ISysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 操作日志记录
 *
 * @author fish
 */
@RestController
@RequestMapping("/system/monitor/operlog")
public class SysOperlogController extends BaseController {
    @Autowired
    private ISysOperLogService operLogService;

    @RequiresPermissions("monitor:operlog:list")
    @GetMapping("/list")
    public TableDataInfo list(SysOperLog operLog) {
        startPage();
        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
        return getDataTable(list);
    }

    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @RequiresPermissions("monitor:operlog:export")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysOperLog operLog) {
        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
        ExcelUtil<SysOperLog> util = new ExcelUtil<SysOperLog>(SysOperLog.class);
        util.exportExcel(response, list, "操作日志");
    }

    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    @RequiresPermissions("monitor:operlog:remove")
    @DeleteMapping("/{operIds}")
    public AjaxResult remove(@PathVariable Long[] operIds) {
        return toAjax(operLogService.deleteOperLogByIds(operIds));
    }

    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @RequiresPermissions("monitor:operlog:remove")
    @DeleteMapping("/clean")
    public AjaxResult clean() {
        operLogService.cleanOperLog();
        return success();
    }
}
