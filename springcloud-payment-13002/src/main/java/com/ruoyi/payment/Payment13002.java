package com.ruoyi.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@MapperScan("com.ruoyi.payment.mapper")
@SpringBootApplication
public class Payment13002 {
    public static void main(String[] args) {
        SpringApplication.run(Payment13002.class, args);
    }
}
