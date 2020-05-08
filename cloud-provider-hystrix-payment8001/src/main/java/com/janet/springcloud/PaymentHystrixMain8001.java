package com.janet.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description 测试 Hystrix 的主启动类
 * @Date 2020/5/6
 * @Author Janet
 */
@SpringBootApplication
@EnableEurekaClient //注册进 Eureka
@EnableCircuitBreaker //激活Hystrix服务降级
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}