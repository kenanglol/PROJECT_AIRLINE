package com.airline.userinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.airline.userinfoservice.client")
public class UserInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserInfoServiceApplication.class, args);
    }
} 