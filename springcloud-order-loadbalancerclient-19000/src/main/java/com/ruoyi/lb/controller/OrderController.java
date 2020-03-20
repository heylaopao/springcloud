package com.ruoyi.lb.controller;

import cn.hutool.core.util.IdUtil;
import com.ruoyi.api.entity.Payment;
import com.ruoyi.api.entity.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Api(tags = "订单中心")
@RestController
@RequestMapping("/order")
public class OrderController {

    //通过 LoadBalancerClient 实现  ip + port
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation("创建支付信息")
    @PostMapping("/payment/create")
    public ResponseData create() {
        //获取注册到注册中心的支付实例
        ServiceInstance instance = loadBalancerClient.choose("payment-server");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/payment";
        Payment payment = Payment.builder().serial(IdUtil.simpleUUID()).build();
        return restTemplate.postForObject(url, payment, ResponseData.class);
    }

    @ApiOperation("获取支付信息")
    @GetMapping("/payment/get/{paymentId}")
    public ResponseData getPayment(@PathVariable Integer paymentId) {
        //获取注册到注册中心的支付实例
        ServiceInstance instance = loadBalancerClient.choose("payment-server");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/payment/" + paymentId;
        return restTemplate.getForObject(url, ResponseData.class);
    }
}
