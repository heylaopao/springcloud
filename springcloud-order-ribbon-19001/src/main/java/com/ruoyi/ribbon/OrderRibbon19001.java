package com.ruoyi.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
@EnableEurekaClient
@RibbonClient(name = "payment-server")
@SpringBootApplication
public class OrderRibbon19001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderRibbon19001.class, args);
    }
}
