package com.ruoyi.hystrix.controller;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ruoyi.api.entity.Payment;
import com.ruoyi.api.entity.ResponseData;
import com.ruoyi.hystrix.client.PaymentClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "订单中心")
@RestController
@RequestMapping("/order")
public class OrderController {

    //使用feign
    @Autowired
    private PaymentClient paymentClient;

    @ApiOperation("创建支付信息")
    @PostMapping("/payment/create")
    public ResponseData create() {
        Payment payment = Payment.builder().serial(IdUtil.simpleUUID()).build();
        return paymentClient.create(payment);
    }

    @ApiOperation("获取支付信息")
    @GetMapping("/payment/get/{paymentId}")
    public ResponseData getPayment(@PathVariable Integer paymentId) {

        return paymentClient.findById(paymentId);
    }

    @ApiOperation("降级测试")
    @GetMapping("/payment/timeout")
    public ResponseData timeout() {
        return paymentClient.timeout();
    }

    /**
     * 参数来源
     * HystrixCommandProperties
     */
    @ApiOperation("熔断测试")
    @GetMapping("/payment/circuitBreaker/{paymentId}")
    @HystrixCommand(fallbackMethod = "circuitBreaker", commandProperties = {
            /*是否开启断路器*/
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            /*请求次数*/
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            /*时间窗口期*/
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            /*失败率达到多少后熔断*/
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public ResponseData circuitBreaker(@PathVariable Integer paymentId) {
        return paymentClient.circuitBreaker(paymentId);
    }
}
