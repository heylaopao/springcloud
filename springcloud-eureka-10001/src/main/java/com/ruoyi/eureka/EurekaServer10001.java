package com.ruoyi.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/*开启注册*/
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer10001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer10001.class, args);
    }

}