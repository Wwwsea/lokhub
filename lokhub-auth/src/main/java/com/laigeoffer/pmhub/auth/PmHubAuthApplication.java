package com.laigeoffer.lokhub.auth;

import com.laigeoffer.lokhub.base.security.annotation.EnablePmFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author fish
 * @description 认证授权中心
 * @create 2024-04-23-15:00
 */
@EnablePmFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class lokhubAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(lokhubAuthApplication.class, args);
    }
}