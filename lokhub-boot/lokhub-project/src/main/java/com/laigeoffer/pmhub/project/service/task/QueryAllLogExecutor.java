package com.laigeoffer.lokhub.project.service.task;

import com.alibaba.fastjson2.JSON;
import com.laigeoffer.lokhub.common.enums.LogTypeEnum;
import com.laigeoffer.lokhub.project.domain.vo.project.log.LogContentVO;
import com.laigeoffer.lokhub.project.domain.vo.project.log.ProjectLogVO;
import com.laigeoffer.lokhub.project.mapper.ProjectLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author fish
 * @date 2023-01-09 16:28
 */
@Service("queryAllLogExecutor")
public class QueryAllLogExecutor extends QueryLogAbstractExecutor {
    @Autowired
    private ProjectLogMapper projectLogMapper;
    @Override
    public List<ProjectLogVO> query(String taskId) {
        List<ProjectLogVO> list = projectLogMapper.queryAllLog(taskId);
        list.forEach(projectLogVO -> {
            if (Objects.equals(LogTypeEnum.TRENDS.getStatus(), projectLogVO.getLogType())) {
                List<LogContentVO> contentVOList = JSON.parseArray(projectLogVO.getContent().toString(), LogContentVO.class);
                projectLogVO.setContent(contentVOList);
            }
            projectLogVO.setLogTypeName(LogTypeEnum.getStatusNameByStatus(projectLogVO.getLogType()));
        });
        return list;
    }
}
