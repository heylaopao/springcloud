package com.ruoyi.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*开启监控*/
@EnableAdminServer
@EnableEurekaClient
@SpringBootApplication
public class Monitor12001 {
    public static void main(String[] args) {
        SpringApplication.run(Monitor12001.class, args);
    }

}