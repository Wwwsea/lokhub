package com.laigeoffer.lokhub.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author fish
 * @description 监控中心
 * @create 2024-05-16-16:22
 */
@EnableAdminServer
@SpringBootApplication
@RefreshScope
public class lokhubMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(lokhubMonitorApplication.class, args);
    }
}