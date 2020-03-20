package com.ruoyi.ribbon.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @LoadBalanced //ribbon负载均衡必须
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
