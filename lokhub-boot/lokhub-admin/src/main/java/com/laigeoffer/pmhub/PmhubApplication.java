package com.laigeoffer.lokhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

;

/**
 * 启动程序
 *
 * @author fish
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
@EnableAspectJAutoProxy // 开启 AspectJ 自动代理
@EnableAsync
public class lokhubApplication {
    public static void main(String[] args) {
        SpringApplication.run(lokhubApplication.class, args);
    }
}
