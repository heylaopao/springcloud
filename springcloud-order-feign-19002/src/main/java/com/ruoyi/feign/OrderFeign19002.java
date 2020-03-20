package com.ruoyi.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
/*open feign*/
@EnableFeignClients(basePackages = {"com.ruoyi.feign.client"})
@EnableEurekaClient
public class OrderFeign19002 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeign19002.class, args);
    }
}
