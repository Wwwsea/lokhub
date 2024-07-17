package com.laigeoffer.lokhub.system.service.impl;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.laigeoffer.lokhub.common.utils.file.FileUtils;
import com.laigeoffer.lokhub.system.domain.lokhubAsync;
import com.laigeoffer.lokhub.system.mapper.lokhubAsyncMapper;
import com.laigeoffer.lokhub.system.service.IlokhubAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Service
public class lokhubAsyncServiceImpl implements IlokhubAsyncService {

    @Autowired
    lokhubAsyncMapper lokhubAsyncMapper;

    /**
     * 创建异步任务记录
     *
     * @param asyncName 异步任务名
     * @param asyncType 异步任务类型
     * @param createBy  创建者
     */
    @Override
    public lokhubAsync addAsyncJob(String asyncName, String asyncType, String createBy) {
        lokhubAsync lokhubAsync = new lokhubAsync(asyncName,asyncType,createBy);
        lokhubAsyncMapper.insert(lokhubAsync);
        return lokhubAsync;
    }

    /**
     * 更新任务状态
     *
     * @param lokhubAsync 任务信息
     */
    @Override
    public void updateAsyncJob(lokhubAsync lokhubAsync) {
        lokhubAsync.setUpdateTime(new Date());
        lokhubAsyncMapper.updateById(lokhubAsync);
    }

    /**
     * 查询异步任务信息
     *
     * @param lokhubAsync
     * @return {@link List}<{@link lokhubAsync}>
     */
    @Override
    public List<lokhubAsync> list(lokhubAsync lokhubAsync) {
        lokhubAsync.setAsyncLog(null);
        QueryWrapper<lokhubAsync> queryWrapper = new QueryWrapper<>();
        // 如果 asyncName 字段不为空，则添加模糊查询条件
        if (lokhubAsync.getAsyncName() != null && !lokhubAsync.getAsyncName().isEmpty()) {
            // 添加模糊查询条件
            queryWrapper.like("async_name", "%"+ lokhubAsync.getAsyncName()+"%");
        }
        if (lokhubAsync.getAsyncType() != null && !lokhubAsync.getAsyncType().isEmpty()) {
            // 添加精确查询条件
            queryWrapper.eq("async_type", lokhubAsync.getAsyncType());
        }
        if (lokhubAsync.getAsyncStatus() != null) {
            // 添加精确查询条件
            queryWrapper.eq("async_status", lokhubAsync.getAsyncStatus());
        }
        if (lokhubAsync.getCreateBy() != null && !lokhubAsync.getCreateBy().isEmpty()) {
            // 添加精确查询条件
            queryWrapper.eq("create_by", lokhubAsync.getCreateBy());
        }
        if (lokhubAsync.getId() != null && !lokhubAsync.getId().isEmpty()) {
            // 添加精确查询条件
            queryWrapper.eq("id", lokhubAsync.getId());
        }
        queryWrapper.orderByDesc("update_time"); // 添加根据 updateTime 字段的倒序排序
        // 查询所有记录
        return lokhubAsyncMapper.selectList(queryWrapper);
    }

    /**
     * 查询单条异步任务信息
     *
     * @param id id
     * @return {@link List}<{@link lokhubAsync}>
     */
    @Override
    public lokhubAsync load(String id) {
        lokhubAsync lokhubAsync = new lokhubAsync();
        lokhubAsync.setId(id);
        List<lokhubAsync> lokhubAsyncs = list(lokhubAsync);
        if (!lokhubAsyncs.isEmpty()){
            return lokhubAsyncs.get(0);
        }else {
            return null;
        }
    }


    /**
     * 删除
     * @param ids ids
     */
    @Transactional
    @Override
    public void delete(String[] ids) {
        for (String id:ids){
            lokhubAsync lokhubAsync = new lokhubAsync();
            lokhubAsync.setId(id);
            delete(lokhubAsync);
        }
    }

    /**
     * 下载附件
     *
     * @param id       任务id
     * @param response Http
     */
    @Override
    public void downloadFile(String id, String user, HttpServletResponse response) {
        lokhubAsync lokhubAsync = load(id);
        if (lokhubAsync ==null){
            throw new RuntimeException("不存在的任务");
        }else if (lokhubAsync.getFile()==null|| lokhubAsync.getFile().isEmpty()){
            throw new RuntimeException("不存在的附件");
        }else if (!lokhubAsync.getCreateBy().equals(user)){
            throw new RuntimeException("非法操作");
        }else {
            // 单文件下载
            try {
                FileUtils.setAttachmentResponseHeader(response, lokhubAsync.getFile());
                FileUtils.writeBytes(lokhubAsync.getFile(), response);
            } catch (UnsupportedEncodingException e) {
                LogFactory.get().error(e);
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void delete(lokhubAsync lokhubAsync) {
        lokhubAsync = lokhubAsyncMapper.selectById(lokhubAsync.getId());

        if (lokhubAsync ==null){
            return;
        }

        if (lokhubAsync.getAsyncStatus()==0){
            throw new RuntimeException("任务进行中禁止删除");
        }

        // 文件路径
        String filePath = lokhubAsync.getFile();
        if (ObjectUtil.isNotEmpty(filePath)){
            // 删除文件
            boolean result = new File(filePath).delete();

            if (result) {
                LogFactory.get().info("任务["+ lokhubAsync.getId()+"]文件已被成功删除");
            } else {
                LogFactory.get().warn("任务["+ lokhubAsync.getId()+"]文件删除失败，可能文件不存在或无法删除");
            }
        }
        lokhubAsyncMapper.deleteById(lokhubAsync);
    }

}
