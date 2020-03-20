package com.ruoyi.hystrix.client.fallback;

import com.ruoyi.api.entity.Payment;
import com.ruoyi.api.entity.ResponseData;
import com.ruoyi.hystrix.client.PaymentClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentFallback implements PaymentClient {

    @Override
    public ResponseData create(Payment payment) {
        return ResponseData.failure("payment not created");
    }

    /*服务降级*/
    @Override
    public ResponseData timeout() {
        log.info("-----------  time out ---------------");
        return ResponseData.failure("超时测试", "超时啦，哈哈哈哈");
    }

    /*服务熔断*/
    @Override
    public ResponseData circuitBreaker(Integer paymentId) {
        log.info("-----------  circuitBreaker ---------------");
        return ResponseData.failure("熔断", "熔断啦，哈哈哈哈");
    }

    @Override
    public ResponseData findById(Integer paymentId) {
        return ResponseData.failure("payment is not found");
    }
}
