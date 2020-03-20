package com.ruoyi.feign.client;

import com.ruoyi.api.entity.Payment;
import com.ruoyi.api.entity.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("payment-server")
public interface PaymentClient {

    @PostMapping("/payment")
    ResponseData create(@RequestBody Payment payment);

    @GetMapping("/payment/{paymentId}")
    ResponseData findById(@PathVariable("paymentId") Integer paymentId);

}


