package com.laigeoffer.lokhub.project;

import com.laigeoffer.lokhub.base.security.annotation.EnableCustomConfig;
import com.laigeoffer.lokhub.base.security.annotation.EnablePmFeignClients;
import com.laigeoffer.lokhub.base.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fish
 * @description 项目管理模块
 * @create 2024-04-25-17:23
 */
@EnableCustomConfig
@EnablePmFeignClients
@EnableCustomSwagger2
@SpringBootApplication
public class lokhubProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(lokhubProjectApplication.class, args);
    }
}