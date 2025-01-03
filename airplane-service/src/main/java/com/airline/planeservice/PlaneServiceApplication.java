package com.airline.planeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EntityScan(basePackages = "com.airline.commons.entity")
@EnableJpaRepositories(basePackages = "com.airline.planeservice.repository")
public class PlaneServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlaneServiceApplication.class, args);
    }
} 