package com.ruoyi.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
/*配置中心开启*/
@EnableConfigServer
public class ConfigServer17010 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer17010.class, args);
    }
}