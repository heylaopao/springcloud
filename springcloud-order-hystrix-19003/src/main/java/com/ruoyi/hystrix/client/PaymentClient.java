package com.ruoyi.hystrix.client;

import com.ruoyi.api.entity.Payment;
import com.ruoyi.api.entity.ResponseData;
import com.ruoyi.hystrix.client.fallback.PaymentFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "payment-server", fallback = PaymentFallback.class)
public interface PaymentClient {

    @PostMapping("/payment")
    ResponseData create(@RequestBody Payment payment);

    @GetMapping("/payment/timeout")
    ResponseData timeout();

    @GetMapping("/payment/circuitBreaker/{paymentId}")
    ResponseData circuitBreaker(@PathVariable("paymentId") Integer paymentId);

    @GetMapping("/payment/{paymentId}")
    ResponseData findById(@PathVariable("paymentId") Integer paymentId);

}


