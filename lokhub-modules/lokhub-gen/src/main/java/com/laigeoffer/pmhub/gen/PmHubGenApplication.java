package com.laigeoffer.lokhub.gen;

import com.laigeoffer.lokhub.base.security.annotation.EnableCustomConfig;
import com.laigeoffer.lokhub.base.security.annotation.EnablePmFeignClients;
import com.laigeoffer.lokhub.base.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fish
 * @description 代码生成
 * @create 2024-04-25-14:18
 */
@EnableCustomConfig
@EnablePmFeignClients
@EnableCustomSwagger2
@SpringBootApplication
public class lokhubGenApplication {
    public static void main(String[] args) {
        SpringApplication.run(lokhubGenApplication.class, args);
    }
}