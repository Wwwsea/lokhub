package com.laigeoffer.lokhub.project.service.task;

import com.laigeoffer.lokhub.common.enums.LogTypeEnum;
import com.laigeoffer.lokhub.project.domain.vo.project.log.ProjectLogVO;
import com.laigeoffer.lokhub.project.mapper.ProjectLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fish
 * @date 2023-01-09 16:33
 */
@Service("queryCommentLogExecutor")
public class QueryCommentLogExecutor extends QueryLogAbstractExecutor {
    @Autowired
    private ProjectLogMapper projectLogMapper;
    @Override
    public List<ProjectLogVO> query(String taskId) {
        List<ProjectLogVO> list = projectLogMapper.queryCommentLog(taskId);
        list.forEach(projectLogVO -> projectLogVO.setLogTypeName(LogTypeEnum.getStatusNameByStatus(projectLogVO.getLogType())));
        return list;
    }
}
