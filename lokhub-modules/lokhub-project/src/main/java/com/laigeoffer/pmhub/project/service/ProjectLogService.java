package com.laigeoffer.lokhub.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.laigeoffer.lokhub.project.domain.vo.project.ProjectVO;
import com.laigeoffer.lokhub.project.domain.vo.project.log.LogVO;
import com.laigeoffer.lokhub.project.domain.vo.project.log.ProjectLogVO;
import com.laigeoffer.lokhub.project.domain.ProjectLog;

/**
 * @author fish
 * @date 2022-12-21 11:40
 */
public interface ProjectLogService extends IService<ProjectLog> {
    void run(LogVO logVO);

    PageInfo<ProjectLogVO> list(ProjectVO projectVO);
}
