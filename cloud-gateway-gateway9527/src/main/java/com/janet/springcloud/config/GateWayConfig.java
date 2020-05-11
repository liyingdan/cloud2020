package com.janet.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 这个类是自己用代码配置路由的 config 类
 * @Date 2020/5/11
 * @Author Janet
 */
@Configuration
public class GateWayConfig {
    /*
     *  配置了一个 id 为 rout-name 的路由规则，
     * 当访问地址 http://localhost:9527/guonei 时会自动转发到地址：https://news.baidu.com/guonei
     *
     * */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //
        routes.route("path_rout_janet", r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();

        return routes.build();
    }
}