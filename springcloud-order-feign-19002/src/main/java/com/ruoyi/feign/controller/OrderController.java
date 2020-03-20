package com.ruoyi.feign.controller;

import cn.hutool.core.util.IdUtil;
import com.ruoyi.api.entity.Payment;
import com.ruoyi.api.entity.ResponseData;
import com.ruoyi.feign.client.PaymentClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "订单中心")
@RestController
@RequestMapping("/order")
public class OrderController {

    //使用feign客户端实现
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

}
