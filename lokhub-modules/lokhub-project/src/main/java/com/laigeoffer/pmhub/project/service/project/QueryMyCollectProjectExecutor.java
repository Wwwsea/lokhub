package com.laigeoffer.lokhub.project.service.project;

import com.alibaba.fastjson2.JSON;
import com.laigeoffer.lokhub.base.security.utils.SecurityUtils;
import com.laigeoffer.lokhub.project.domain.vo.project.ProjectReqVO;
import com.laigeoffer.lokhub.project.domain.vo.project.ProjectResVO;
import com.laigeoffer.lokhub.project.mapper.ProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fish
 * @date 2023-01-09 11:47
 */
@Slf4j
@Service("queryMyCollectProjectExecutor")
public class QueryMyCollectProjectExecutor extends QueryAbstractExecutor {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<ProjectResVO> query(ProjectReqVO projectReqVO) {
        log.info("查询我收藏的项目入参:{}", JSON.toJSONString(projectReqVO));
        return projectMapper.selectMyCollectProjectList(projectReqVO, SecurityUtils.getUserId());
    }
}
