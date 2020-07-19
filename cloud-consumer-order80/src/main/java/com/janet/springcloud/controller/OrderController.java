package com.janet.springcloud.controller;

import com.janet.springcloud.entities.CommonResult;
import com.janet.springcloud.entities.Payment;
import com.janet.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author Janet
 * @date 2020/4/29
 */
@RestController
@Slf4j
public class OrderController {
//    private final static String PAYMENT_URL = "http://localhost:8001"; //暂时写死，后面再改
    private final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; //这里写微服务注册的名称

    //引入手写 Ribbon 轮询接口类
    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")  //只能发 get 请求
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        if(forEntity.getStatusCode().is2xxSuccessful())
            return forEntity.getBody();
        else
            return new CommonResult<>(444,"操作失败");
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances == null || instances.size() <= 0)
            return null;
        ServiceInstance instanceInstance = loadBalancer.instances(instances);
        URI uri = instanceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb",String.class);
    }

    // 测试 zipkin + sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }
}