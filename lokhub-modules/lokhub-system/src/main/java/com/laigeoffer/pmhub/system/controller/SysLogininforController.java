package com.laigeoffer.lokhub.system.controller;

import com.laigeoffer.lokhub.base.core.annotation.Log;
import com.laigeoffer.lokhub.base.core.config.redis.RedisService;
import com.laigeoffer.lokhub.base.core.constant.CacheConstants;
import com.laigeoffer.lokhub.base.core.core.controller.BaseController;
import com.laigeoffer.lokhub.base.core.core.domain.AjaxResult;
import com.laigeoffer.lokhub.base.core.core.domain.entity.SysLogininfor;
import com.laigeoffer.lokhub.base.core.core.page.TableDataInfo;
import com.laigeoffer.lokhub.base.core.enums.BusinessType;
import com.laigeoffer.lokhub.base.core.utils.poi.ExcelUtil;
import com.laigeoffer.lokhub.base.security.annotation.InnerAuth;
import com.laigeoffer.lokhub.base.security.annotation.RequiresPermissions;
import com.laigeoffer.lokhub.system.service.ISysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 系统访问记录
 *
 * @author fish
 */
@RestController
@RequestMapping("/system/monitor/logininfor")
public class SysLogininforController extends BaseController {
    @Autowired
    private ISysLogininforService logininforService;

    @Autowired
    private RedisService redisService;

    @RequiresPermissions("@ss.hasPermi('monitor:logininfor:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysLogininfor logininfor) {
        startPage();
        List<SysLogininfor> list = logininforService.selectLogininforList(logininfor);
        return getDataTable(list);
    }

    @Log(title = "登录日志", businessType = BusinessType.EXPORT)
    @RequiresPermissions("monitor:logininfor:export")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysLogininfor logininfor) {
        List<SysLogininfor> list = logininforService.selectLogininforList(logininfor);
        ExcelUtil<SysLogininfor> util = new ExcelUtil<SysLogininfor>(SysLogininfor.class);
        util.exportExcel(response, list, "登录日志");
    }

    @RequiresPermissions("monitor:logininfor:remove")
    @Log(title = "登录日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{infoIds}")
    public AjaxResult remove(@PathVariable Long[] infoIds) {
        return toAjax(logininforService.deleteLogininforByIds(infoIds));
    }

    @RequiresPermissions("monitor:logininfor:remove")
    @Log(title = "登录日志", businessType = BusinessType.CLEAN)
    @DeleteMapping("/clean")
    public AjaxResult clean() {
        logininforService.cleanLogininfor();
        return success();
    }

    @RequiresPermissions("onitor:logininfor:unlock")
    @Log(title = "账户解锁", businessType = BusinessType.OTHER)
    @GetMapping("/unlock/{userName}")
    public AjaxResult unlock(@PathVariable("userName") String userName) {
        redisService.deleteObject(CacheConstants.PWD_ERR_CNT_KEY + userName);
        return success();
    }

    /**
     * 插入访问记录-内部微服务调用
     * @param logininfor
     * @return
     */
    @InnerAuth
    @PostMapping
    public AjaxResult add(@RequestBody SysLogininfor logininfor)
    {
        return toAjax(logininforService.insertLogininfor(logininfor));
    }
}
