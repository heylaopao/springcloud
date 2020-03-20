package com.ruoyi.ribbon;

import com.ruoyi.ribbon.conf.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(name = "payment-server", configuration = RibbonRuleConfig.class)
@SpringBootApplication
public class OrderRibbon19001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderRibbon19001.class, args);
    }
}
