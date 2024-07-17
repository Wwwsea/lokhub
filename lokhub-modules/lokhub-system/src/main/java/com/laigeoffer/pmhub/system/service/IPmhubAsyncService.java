package com.laigeoffer.lokhub.system.service;

import com.laigeoffer.lokhub.system.domain.lokhubAsync;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 异步任务管理 服务层
 *
 * @author fish
 */
public interface IlokhubAsyncService {

    /**
     * 创建异步任务记录
     *
     * @param asyncName 异步任务名
     * @param asyncType 异步任务类型
     * @param createBy  创建者
     * @return id
     */
    lokhubAsync addAsyncJob(String asyncName, String asyncType, String createBy);

    /**
     * 更新任务状态
     * @param lokhubAsync 任务信息
     */
    void updateAsyncJob(lokhubAsync lokhubAsync);


    /**
     * 查询异步任务信息
     * @param lokhubAsync
     * @return {@link List}<{@link lokhubAsync}>
     */
    List<lokhubAsync> list(lokhubAsync lokhubAsync);

    /**
     * 查询单条异步任务信息
     * @param id id
     * @return {@link List}<{@link lokhubAsync}>
     */
    lokhubAsync load(String id);

    /**
     * 删除
     * @param ids ids
     */
    void delete(String[] ids);



    void downloadFile(String id, String user, HttpServletResponse response);
}
