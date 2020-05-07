package com.janet.springcloud.service;

import com.janet.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description TODO
 * @Date 2020/4/29
 * @Author Janet
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}