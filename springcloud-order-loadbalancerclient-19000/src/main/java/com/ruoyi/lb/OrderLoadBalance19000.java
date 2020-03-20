package com.ruoyi.lb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OrderLoadBalance19000 {
    public static void main(String[] args) {
        SpringApplication.run(OrderLoadBalance19000.class, args);
    }
}
