package com.laigeoffer.lokhub.api.system;

import com.laigeoffer.lokhub.api.system.factory.LogFeignFallbackFactory;
import com.laigeoffer.lokhub.base.core.constant.SecurityConstants;
import com.laigeoffer.lokhub.base.core.constant.ServiceNameConstants;
import com.laigeoffer.lokhub.base.core.core.domain.R;
import com.laigeoffer.lokhub.base.core.core.domain.entity.SysLogininfor;
import com.laigeoffer.lokhub.base.core.core.domain.entity.SysOperLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 日志服务
 * 
 * @author fish
 */
@FeignClient(contextId = "logFeignService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = LogFeignFallbackFactory.class)
public interface LogFeignService
{
    /**
     * 保存系统日志 todo 待优化后使用
     *
     * @param sysOperLog 日志实体
     * @param source 请求来源
     * @return 结果
     */
    @PostMapping("/system/monitor/operlog")
    R<Boolean> saveLog(@RequestBody SysOperLog sysOperLog, @RequestHeader(SecurityConstants.FROM_SOURCE) String source) throws Exception;

    /**
     * 保存访问记录
     *
     * @param sysLogininfor 访问实体
     * @param source 请求来源
     * @return 结果
     */
    @PostMapping("/system/monitor/logininfor")
    R<Boolean> saveLogininfor(@RequestBody SysLogininfor sysLogininfor, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
