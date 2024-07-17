package com.laigeoffer.lokhub.web.controller.tool;

import com.laigeoffer.lokhub.common.core.controller.BaseController;
import com.laigeoffer.lokhub.common.core.domain.AjaxResult;
import com.laigeoffer.lokhub.common.core.page.TableDataInfo;
import com.laigeoffer.lokhub.system.domain.lokhubAsync;
import com.laigeoffer.lokhub.system.service.IlokhubAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * swagger 接口
 *
 * @author fish
 */
@RestController
@RequestMapping("/tool/async")
public class AsyncController extends BaseController {

    @Autowired
    IlokhubAsyncService ilokhubAsyncService;


    /**
     * 查询异步任务
     * @param lokhubAsync
     * @return {@link TableDataInfo}
     */
    @GetMapping("/list")
    public TableDataInfo list(lokhubAsync lokhubAsync) {
        startPage();
        lokhubAsync.setCreateBy(getUsername());
        return getDataTable(ilokhubAsyncService.list(lokhubAsync));
    }

    /**
     * 删除异步任务
     * @param asyncIds
     * @return {@link TableDataInfo}
     */
    @DeleteMapping("/delete/{asyncIds}")
    public AjaxResult delete(@PathVariable String[] asyncIds) {
        ilokhubAsyncService.delete(asyncIds);
        return AjaxResult.success("success");
    }

    /**
     * 下载附件
     *
     * @param id       包含任务id
     * @param response HttpServletResponse
     */
    @PostMapping("/download")
    public void downloadPost(String id, HttpServletResponse response) {
        ilokhubAsyncService.downloadFile(id,getUsername(),response);
    }

}
