package com.laigeoffer.lokhub.web.controller.workflow;

import com.laigeoffer.lokhub.common.annotation.Log;
import com.laigeoffer.lokhub.common.core.controller.BaseController;
import com.laigeoffer.lokhub.common.core.domain.PageQuery;
import com.laigeoffer.lokhub.common.core.domain.R;
import com.laigeoffer.lokhub.common.core.page.Table2DataInfo;
import com.laigeoffer.lokhub.common.core.validate.QueryGroup;
import com.laigeoffer.lokhub.common.enums.BusinessType;
import com.laigeoffer.lokhub.common.utils.poi.ExcelUtil;
import com.laigeoffer.lokhub.workflow.domain.WfDeployForm;
import com.laigeoffer.lokhub.workflow.domain.bo.WfFormBo;
import com.laigeoffer.lokhub.workflow.domain.vo.WfFormVo;
import com.laigeoffer.lokhub.workflow.service.IWfDeployFormService;
import com.laigeoffer.lokhub.workflow.service.IWfFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * 流程表单Controller
 *
 * @author fish
 * @createTime 2022/3/7 22:07
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/workflow/form")
public class WfFormController extends BaseController {

    private final IWfFormService formService;

    private final IWfDeployFormService deployFormService;

    /**
     * 查询流程表单列表
     */
    @PreAuthorize("@ss.hasPermi('workflow:form:list')")
    @GetMapping("/list")
    public Table2DataInfo<WfFormVo> list(@Validated(QueryGroup.class) WfFormBo bo, PageQuery pageQuery) {
        return formService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出流程表单列表
     */
    @PreAuthorize("@ss.hasPermi('workflow:form:export')")
    @Log(title = "流程表单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(@Validated WfFormBo bo, HttpServletResponse response) {
        List<WfFormVo> list = formService.queryList(bo);
        ExcelUtil.exportExcel2(list, "流程表单", WfFormVo.class, response);
    }

    /**
     * 获取流程表单详细信息
     * @param formId 主键
     */
    @PreAuthorize("@ss.hasPermi('workflow:form:query')")
    @GetMapping(value = "/{formId}")
    public R<WfFormVo> getInfo(@NotNull(message = "主键不能为空") @PathVariable("formId") Long formId) {
        return R.ok(formService.queryById(formId));
    }

    /**
     * 新增流程表单
     */
    @PreAuthorize("@ss.hasPermi('workflow:form:add')")
    @Log(title = "流程表单", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody WfFormBo bo) {
        return toAjax2(formService.insertForm(bo));
    }

    /**
     * 修改流程表单
     */
    @PreAuthorize("@ss.hasPermi('workflow:form:edit')")
    @Log(title = "流程表单", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody WfFormBo bo) {
        return toAjax2(formService.updateForm(bo));
    }

    /**
     * 删除流程表单
     * @param formIds 主键串
     */
    @PreAuthorize("@ss.hasPermi('workflow:form:remove')")
    @Log(title = "流程表单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{formIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空") @PathVariable Long[] formIds) {
        return toAjax2(formService.deleteWithValidByIds(Arrays.asList(formIds)) ? 1 : 0);
    }


    /**
     * 挂载流程表单
     */
    @Log(title = "流程表单", businessType = BusinessType.INSERT)
    @PostMapping("/addDeployForm")
    public R<Void> addDeployForm(@RequestBody WfDeployForm deployForm) {
        return toAjax2(deployFormService.insertWfDeployForm(deployForm));
    }
}
