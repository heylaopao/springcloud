package com.ruoyi.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableEurekaClient
@RefreshScope
public class ConfigClient17011 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient17011.class, args);
    }

    @Value("${env}")
    private String env;

    @GetMapping
    public String index() {
        return env;
    }
}