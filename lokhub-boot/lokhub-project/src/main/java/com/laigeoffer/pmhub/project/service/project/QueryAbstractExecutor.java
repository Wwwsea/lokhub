package com.laigeoffer.lokhub.project.service.project;

import com.laigeoffer.lokhub.project.domain.vo.project.ProjectReqVO;
import com.laigeoffer.lokhub.project.domain.vo.project.ProjectResVO;

import java.util.List;

/**
 * @author fish
 * @date 2023-01-09 11:41
 */
public abstract class QueryAbstractExecutor {
    public abstract List<ProjectResVO> query(ProjectReqVO projectReqVO);
}
