package com.ruoyi.ribbon.controller;

import cn.hutool.core.util.IdUtil;
import com.ruoyi.api.entity.Payment;
import com.ruoyi.api.entity.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Api(tags = "订单中心")
@RestController
@RequestMapping("/order")
public class OrderController {

    //通过 ribbon实现负载均衡 服务名称
    @Autowired
    private RestTemplate restTemplate;
    //通过服务名 不再是端口号+ip的方式
    public final String url = "http://payment-server/payment/";

    @ApiOperation("获取支付信息")
    @GetMapping("/payment/get/{paymentId}")
    public ResponseData getPayment(@PathVariable Integer paymentId) {

        return restTemplate.getForObject(url + paymentId, ResponseData.class);
    }

    @ApiOperation("创建支付信息")
    @PostMapping("/payment/create")
    public ResponseData create() {
        Payment payment = Payment.builder().serial(IdUtil.simpleUUID()).build();
        return restTemplate.postForObject(url, payment, ResponseData.class);
    }
}
