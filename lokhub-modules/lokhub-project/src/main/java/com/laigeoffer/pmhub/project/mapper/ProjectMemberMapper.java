package com.laigeoffer.lokhub.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laigeoffer.lokhub.project.domain.ProjectMember;
import com.laigeoffer.lokhub.project.domain.vo.project.member.ProjectMemberReqVO;
import com.laigeoffer.lokhub.project.domain.vo.project.member.ProjectMemberResVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fish
 * @date 2022-12-12 14:29
 */
public interface ProjectMemberMapper extends BaseMapper<ProjectMember> {

    List<ProjectMemberResVO> searchMember(@Param("data") ProjectMemberReqVO projectMemberReqVO);

    List<ProjectMemberResVO> queryExecutorList(@Param("projectId") String projectId);
    List<ProjectMemberResVO> queryTaskUserList(@Param("taskId") String taskId);
}
