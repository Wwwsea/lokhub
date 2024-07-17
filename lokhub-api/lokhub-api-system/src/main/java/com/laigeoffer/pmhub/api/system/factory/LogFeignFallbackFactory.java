package com.laigeoffer.lokhub.api.system.factory;

import com.laigeoffer.lokhub.api.system.LogFeignService;
import com.laigeoffer.lokhub.base.core.core.domain.R;
import com.laigeoffer.lokhub.base.core.core.domain.entity.SysLogininfor;
import com.laigeoffer.lokhub.base.core.core.domain.entity.SysOperLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 日志服务降级处理
 * 
 * @author fish
 */
@Component
public class LogFeignFallbackFactory implements FallbackFactory<LogFeignService>
{
    private static final Logger log = LoggerFactory.getLogger(LogFeignFallbackFactory.class);

    @Override
    public LogFeignService create(Throwable throwable)
    {
        log.error("日志服务调用失败:{}", throwable.getMessage());
        return new LogFeignService()
        {
            @Override
            public R<Boolean> saveLog(SysOperLog sysOperLog, String source)
            {
                return R.fail("保存操作日志失败:" + throwable.getMessage());
            }

            @Override
            public R<Boolean> saveLogininfor(SysLogininfor sysLogininfor, String source)
            {
                return R.fail("保存登录日志失败:" + throwable.getMessage());
            }
        };

    }
}
