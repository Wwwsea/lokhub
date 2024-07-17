package com.laigeoffer.lokhub.system;

import com.laigeoffer.lokhub.base.security.annotation.EnableCustomConfig;
import com.laigeoffer.lokhub.base.security.annotation.EnablePmFeignClients;
import com.laigeoffer.lokhub.base.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fish
 * @description 系统模块
 * @create 2024-04-24-15:29
 */
@EnableCustomConfig
@EnablePmFeignClients
@EnableCustomSwagger2
@SpringBootApplication
public class lokhubSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(lokhubSystemApplication.class, args);
    }
}