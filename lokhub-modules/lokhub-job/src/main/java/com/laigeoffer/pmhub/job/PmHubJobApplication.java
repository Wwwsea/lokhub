package com.laigeoffer.lokhub.job;

import com.laigeoffer.lokhub.base.security.annotation.EnableCustomConfig;
import com.laigeoffer.lokhub.base.security.annotation.EnablePmFeignClients;
import com.laigeoffer.lokhub.base.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fish
 * @description 定时任务
 * @create 2024-04-25-15:13
 */
@EnableCustomConfig
@EnablePmFeignClients
@EnableCustomSwagger2
@SpringBootApplication
public class lokhubJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(lokhubJobApplication.class, args);
    }
}