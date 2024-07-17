package com.laigeoffer.lokhub.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laigeoffer.lokhub.project.domain.vo.project.ProjectVO;
import com.laigeoffer.lokhub.project.domain.ProjectCollection;

/**
 * @author fish
 * @date 2022-12-15 16:34
 */
public interface ProjectCollectionService extends IService<ProjectCollection> {

    /**
     * 收藏项目
     * @param projectVO
     * @return
     */
    int collectProject(ProjectVO projectVO);
    /**
     * 取消收藏项目
     * @param projectVO
     * @return
     */
    int cancelCollectProject(ProjectVO projectVO);

}
