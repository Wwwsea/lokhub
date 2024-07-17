package com.laigeoffer.lokhub.web.controller.workflow;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.laigeoffer.lokhub.common.annotation.Log;
import com.laigeoffer.lokhub.common.core.controller.BaseController;
import com.laigeoffer.lokhub.common.core.domain.PageQuery;
import com.laigeoffer.lokhub.common.core.domain.R;
import com.laigeoffer.lokhub.common.core.page.Table2DataInfo;
import com.laigeoffer.lokhub.common.enums.BusinessType;
import com.laigeoffer.lokhub.common.utils.JsonUtils;
import com.laigeoffer.lokhub.common.utils.poi.ExcelUtil;
import com.laigeoffer.lokhub.workflow.core.domain.ProcessQuery;
import com.laigeoffer.lokhub.workflow.domain.bo.WfCopyBo;
import com.laigeoffer.lokhub.workflow.domain.vo.*;
import com.laigeoffer.lokhub.workflow.service.IWfCopyService;
import com.laigeoffer.lokhub.workflow.service.IWfProcessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 工作流流程管理
 *
 * @author fish
 * @createTime 2022/3/24 18:54
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/workflow/process")
public class WfProcessController extends BaseController {

    private final IWfProcessService processService;
    private final IWfCopyService copyService;

    /**
     * 查询可发起流程列表
     *
     * @param pageQuery 分页参数
     */
    @GetMapping(value = "/list")
    @PreAuthorize("@ss.hasPermi('workflow:process:startList')")
    public Table2DataInfo<WfDefinitionVo> startProcessList(ProcessQuery processQuery, PageQuery pageQuery) {
        return processService.selectPageStartProcessList(processQuery, pageQuery);
    }

    /**
     * 我拥有的流程
     */
    @PreAuthorize("@ss.hasPermi('workflow:process:ownList')")
    @GetMapping(value = "/ownList")
    public Table2DataInfo<WfTaskVo> ownProcessList(ProcessQuery processQuery, PageQuery pageQuery) {
        return processService.selectPageOwnProcessList(processQuery, pageQuery);
    }

    /**
     * 获取待办列表
     */
    @PreAuthorize("@ss.hasPermi('workflow:process:todoList')")
    @GetMapping(value = "/todoList")
    public Table2DataInfo<WfTaskVo> todoProcessList(ProcessQuery processQuery, PageQuery pageQuery) {
        return processService.selectPageTodoProcessList(processQuery, pageQuery);
    }

    /**
     * 获取待签列表
     *
     * @param processQuery 流程业务对象
     * @param pageQuery 分页参数
     */
    @PreAuthorize("@ss.hasPermi('workflow:process:claimList')")
    @GetMapping(value = "/claimList")
    public Table2DataInfo<WfTaskVo> claimProcessList(ProcessQuery processQuery, PageQuery pageQuery) {
        return processService.selectPageClaimProcessList(processQuery, pageQuery);
    }

    /**
     * 获取已办列表
     *
     * @param pageQuery 分页参数
     */
    @PreAuthorize("@ss.hasPermi('workflow:process:finishedList')")
    @GetMapping(value = "/finishedList")
    public Table2DataInfo<WfTaskVo> finishedProcessList(ProcessQuery processQuery, PageQuery pageQuery) {
        return processService.selectPageFinishedProcessList(processQuery, pageQuery);
    }

    /**
     * 获取抄送列表
     *
     * @param copyBo 流程抄送对象
     * @param pageQuery 分页参数
     */
    @PreAuthorize("@ss.hasPermi('workflow:process:copyList')")
    @GetMapping(value = "/copyList")
    public Table2DataInfo<WfCopyVo> copyProcessList(WfCopyBo copyBo, PageQuery pageQuery) {
        copyBo.setUserId(getUserId());
        return copyService.selectPageList(copyBo, pageQuery);
    }

    /**
     * 导出可发起流程列表
     */
    @PreAuthorize("@ss.hasPermi('workflow:process:startExport')")
    @Log(title = "可发起流程", businessType = BusinessType.EXPORT)
    @PostMapping("/startExport")
    public void startExport(@Validated ProcessQuery processQuery, HttpServletResponse response) {
        List<WfDefinitionVo> list = processService.selectStartProcessList(processQuery);
        ExcelUtil.exportExcel2(list, "可发起流程", WfDefinitionVo.class, response);
    }

    /**
     * 导出我拥有流程列表
     */
    @PreAuthorize("@ss.hasPermi('workflow:process:ownExport')")
    @Log(title = "我拥有流程", businessType = BusinessType.EXPORT)
    @PostMapping("/ownExport")
    public void ownExport(@Validated ProcessQuery processQuery, HttpServletResponse response) {
        List<WfTaskVo> list = processService.selectOwnProcessList(processQuery);
        List<WfOwnTaskExportVo> listVo = BeanUtil.copyToList(list, WfOwnTaskExportVo.class);
        for (WfOwnTaskExportVo exportVo : listVo) {
            exportVo.setStatus(ObjectUtil.isNull(exportVo.getFinishTime()) ? "进行中" : "已完成");
        }
        ExcelUtil.exportExcel2(listVo, "我拥有流程", WfOwnTaskExportVo.class, response);
    }

    /**
     * 导出待办流程列表
     */
    @PreAuthorize("@ss.hasPermi('workflow:process:todoExport')")
    @Log(title = "待办流程", businessType = BusinessType.EXPORT)
    @PostMapping("/todoExport")
    public void todoExport(@Validated ProcessQuery processQuery, HttpServletResponse response) {
        List<WfTaskVo> list = processService.selectTodoProcessList(processQuery);
        List<WfTodoTaskExportVo> listVo = BeanUtil.copyToList(list, WfTodoTaskExportVo.class);
        ExcelUtil.exportExcel2(listVo, "待办流程", WfTodoTaskExportVo.class, response);
    }

    /**
     * 导出待签流程列表
     */
    @PreAuthorize("@ss.hasPermi('workflow:process:claimExport')")
    @Log(title = "待签流程", businessType = BusinessType.EXPORT)
    @PostMapping("/claimExport")
    public void claimExport(@Validated ProcessQuery processQuery, HttpServletResponse response) {
        List<WfTaskVo> list = processService.selectClaimProcessList(processQuery);
        List<WfClaimTaskExportVo> listVo = BeanUtil.copyToList(list, WfClaimTaskExportVo.class);
        ExcelUtil.exportExcel2(listVo, "待签流程", WfClaimTaskExportVo.class, response);
    }

    /**
     * 导出已办流程列表
     */
    @PreAuthorize("@ss.hasPermi('workflow:process:finishedExport')")
    @Log(title = "已办流程", businessType = BusinessType.EXPORT)
    @PostMapping("/finishedExport")
    public void finishedExport(@Validated ProcessQuery processQuery, HttpServletResponse response) {
        List<WfTaskVo> list = processService.selectFinishedProcessList(processQuery);
        List<WfFinishedTaskExportVo> listVo = BeanUtil.copyToList(list, WfFinishedTaskExportVo.class);
        ExcelUtil.exportExcel2(listVo, "已办流程", WfFinishedTaskExportVo.class, response);
    }

    /**
     * 导出抄送流程列表
     */
    @PreAuthorize("@ss.hasPermi('workflow:process:copyExport')")
    @Log(title = "抄送流程", businessType = BusinessType.EXPORT)
    @PostMapping("/copyExport")
    public void copyExport(WfCopyBo copyBo, HttpServletResponse response) {
        copyBo.setUserId(getUserId());
        List<WfCopyVo> list = copyService.selectList(copyBo);
        ExcelUtil.exportExcel2(list, "抄送流程", WfCopyVo.class, response);
    }

    /**
     * 查询流程部署关联表单信息
     *
     * @param definitionId 流程定义id
     * @param deployId 流程部署id
     */
    @GetMapping("/getProcessForm")
    @PreAuthorize("@ss.hasPermi('workflow:process:start')")
    public R<?> getForm(@RequestParam(value = "definitionId") String definitionId,
                        @RequestParam(value = "deployId") String deployId) {
        String formContent = processService.selectFormContent(definitionId, deployId);
        return R.ok(JsonUtils.parseObject(formContent, Map.class));
    }

    /**
     * 根据流程定义id启动流程实例
     *
     * @param processDefId 流程定义id
     * @param variables 变量集合,json对象
     */
    @PreAuthorize("@ss.hasPermi('workflow:process:start')")
    @PostMapping("/start/{processDefId}")
    public R<Void> start(@PathVariable(value = "processDefId") String processDefId, @RequestBody Map<String, Object> variables) {
        processService.startProcessByDefId(processDefId, variables);
        return R.ok("流程启动成功");

    }

    /**
     * 根据流程定义id启动流程实例
     *
     * @param processDefId 流程定义id
     * @param variables 变量集合,json对象
     */
    @PreAuthorize("@ss.hasPermi('workflow:process:start')")
    @PostMapping("/startTaskApprove/{taskId}/{processDefId}")
    public R<Void> startTaskProcessDefId(@PathVariable(value = "taskId") String taskId, @PathVariable(value = "processDefId") String processDefId, @RequestParam("url") String url, @RequestBody Map<String, Object> variables) {
        processService.startTaskProcessByDefId(taskId, processDefId, url, variables);
        return R.ok("流程启动成功");

    }

    /**
     * 读取xml文件
     * @param processDefId 流程定义ID
     */
    @GetMapping("/bpmnXml/{processDefId}")
    public R<String> getBpmnXml(@PathVariable(value = "processDefId") String processDefId) {
        return R.ok(null, processService.queryBpmnXmlById(processDefId));
    }

    /**
     * 查询流程详情信息
     *
     * @param procInsId 流程实例ID
     * @param deployId 部署ID
     * @param taskId 任务ID
     */
    @GetMapping("/detail")
    public R<WfDetailVo> detail(String procInsId, String deployId, String taskId) {
        return R.ok(processService.queryProcessDetail(procInsId, deployId, taskId));
    }
}
