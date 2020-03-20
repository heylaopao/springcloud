package com.ruoyi.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.ruoyi.payment.mapper")
public class Payment13001 {
    public static void main(String[] args) {
        SpringApplication.run(Payment13001.class, args);
    }

}
