package com.janet.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Janet
 * @date 2020/5/6
 *
 * OpenFeignClient配置
 */
@Configuration
public class FeignConfig {
    /**
     * feignClient配置日志级别
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        // 请求和响应的头信息,请求和响应的正文及元数据
        return Logger.Level.FULL;
    }
}
