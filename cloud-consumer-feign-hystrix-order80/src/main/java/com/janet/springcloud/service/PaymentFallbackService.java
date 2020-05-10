package com.janet.springcloud.service;

/**
 * @Description 这个类统一处理 PaymentHystrixService 接口中的服务降级
 * @author Janet
 * @date 2020/5/9
 */
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----------------PaymentFallbackService fallback paymentInfo_OK o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-----------------PaymentFallbackService fallback paymentInfo_Timeout o(╥﹏╥)o";
    }
}
