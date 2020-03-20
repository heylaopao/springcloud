package com.ruoyi.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboard19005 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard19005.class, args);
    }
}