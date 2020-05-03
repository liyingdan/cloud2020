package com.janet.springcloud.controller;

import com.janet.springcloud.entities.CommonResult;
import com.janet.springcloud.entities.Payment;
import com.janet.springcloud.service.PaymentService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Date 2020/4/29
 * @Author Janet
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

//    @Resource
//    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果----"+result);
        if(result > 0)
            return new CommonResult(200,"插入数据成功，端口号："+serverPort,result);
        else
            return new CommonResult(444,"插入数据失败",null);

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果----"+payment);
        if(payment != null)
            return new CommonResult(200,"查询成功，端口号："+serverPort,payment);
        else
            return new CommonResult(444,"没有对应字段，查询ID"+id,null);

    }
}