package com.laigeoffer.lokhub.project.controller;

import com.laigeoffer.lokhub.base.core.core.domain.AjaxResult;
import com.laigeoffer.lokhub.base.security.annotation.RequiresPermissions;
import com.laigeoffer.lokhub.project.domain.vo.project.ProjectVO;
import com.laigeoffer.lokhub.project.service.ProjectCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequiresPermissions("project:manage:collect")
    @PostMapping("/collect")
    public AjaxResult collectProject(@RequestBody ProjectVO projectVO) {

        return AjaxResult.success(projectCollectionService.collectProject(projectVO));
    }

    /**
     * 取消收藏项目
     * @param projectVO
     * @return
     */
    @RequiresPermissions("project:manage:cancelCollect")
    @PostMapping("/cancelCollect")
    public AjaxResult cancelCollectProject(@RequestBody ProjectVO projectVO) {

        return AjaxResult.success(projectCollectionService.cancelCollectProject(projectVO));
    }
}
