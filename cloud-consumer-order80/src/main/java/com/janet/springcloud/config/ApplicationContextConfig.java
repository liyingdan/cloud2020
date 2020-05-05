package com.janet.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Janet
 * @date 2020/4/29
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
//    @LoadBalanced   //手写轮询的时候注释掉
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
