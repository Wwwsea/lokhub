package com.laigeoffer.lokhub.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laigeoffer.lokhub.project.domain.vo.project.ProjectVO;
import com.laigeoffer.lokhub.project.domain.ProjectStage;
import com.laigeoffer.lokhub.project.domain.vo.project.stage.ProjectStageVO;

import java.util.List;

/**
 * @author fish
 * @date 2022-12-19 16:37
 */
public interface ProjectStageService extends IService<ProjectStage> {
    List<ProjectStageVO> list(ProjectVO projectVO);
    void delete(ProjectStageVO projectStageVO);
    void add(ProjectStageVO projectStageVO);
    void edit(ProjectStageVO projectStageVO);
    boolean selectTaskByStageId(String stageId);
}
