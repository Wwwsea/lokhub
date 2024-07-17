package com.laigeoffer.lokhub.web.controller.project;

import com.laigeoffer.lokhub.common.core.domain.AjaxResult;
import com.laigeoffer.lokhub.project.domain.vo.project.ProjectVO;
import com.laigeoffer.lokhub.project.service.ProjectLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fish
 * @date 2022-12-21 14:28
 */

@RestController
@RequestMapping("/project/log")
public class ProjectLogController {

    @Autowired
    private ProjectLogService projectLogService;

    /**
     * 项目动态
     * @param projectVO
     * @return
     */
    @PostMapping("/list")
    @PreAuthorize("@ss.hasPermi('project:log:list')")
    public AjaxResult list(@RequestBody ProjectVO projectVO) {
        return AjaxResult.success(projectLogService.list(projectVO));
    }

}
