package com.laigeoffer.lokhub.web.controller.project;

import com.laigeoffer.lokhub.common.core.domain.AjaxResult;
import com.laigeoffer.lokhub.project.domain.vo.project.ProjectVO;
import com.laigeoffer.lokhub.project.service.ProjectCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fish
 * @date 2022-12-15 16:32
 */

@RestController
@RequestMapping("/project")
public class ProjectCollectionController {

    @Autowired
    private ProjectCollectionService projectCollectionService;

    /**
     * 收藏项目
     * @param projectVO
     * @return
     */
    @PreAuthorize("@ss.hasPermi('project:manage:collect')")
    @PostMapping("/collect")
    public AjaxResult collectProject(@RequestBody ProjectVO projectVO) {

        return AjaxResult.success(projectCollectionService.collectProject(projectVO));
    }

    /**
     * 取消收藏项目
     * @param projectVO
     * @return
     */
    @PreAuthorize("@ss.hasPermi('project:manage:cancelCollect')")
    @PostMapping("/cancelCollect")
    public AjaxResult cancelCollectProject(@RequestBody ProjectVO projectVO) {

        return AjaxResult.success(projectCollectionService.cancelCollectProject(projectVO));
    }
}
