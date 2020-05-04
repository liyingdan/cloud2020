package com.janet.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Janet
 * @date 2020/5/4
 */
@RestController
@Slf4j
public class PaymentConsolController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "springcloud with consul : "+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
