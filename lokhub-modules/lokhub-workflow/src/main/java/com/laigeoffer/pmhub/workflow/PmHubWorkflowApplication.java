package com.laigeoffer.lokhub.workflow;

import com.laigeoffer.lokhub.base.security.annotation.EnableCustomConfig;
import com.laigeoffer.lokhub.base.security.annotation.EnableDistributedLock;
import com.laigeoffer.lokhub.base.security.annotation.EnablePmFeignClients;
import com.laigeoffer.lokhub.base.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fish
 * @description 工作流服务
 * @create 2024-04-25-17:45
 */
@EnableCustomConfig
@EnablePmFeignClients
@EnableCustomSwagger2
@EnableDistributedLock // 启用Redisson分布式锁
@SpringBootApplication
public class lokhubWorkflowApplication {
    public static void main(String[] args) {
        SpringApplication.run(lokhubWorkflowApplication.class, args);
    }
}