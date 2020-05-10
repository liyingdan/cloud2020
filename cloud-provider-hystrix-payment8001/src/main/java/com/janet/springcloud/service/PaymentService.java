package com.janet.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.concurrent.TimeUnit;

/**
 * TODO 这里为了更快捷调试 Hystrix，先不写接口了，直接写 Service 类
 * @Description 这个类为了调试 Hystrix，模拟两个方法，一个正常的，一个错误的
 * @Date 2020/5/6
 * @Author Janet
 */
@Service
public class PaymentService {
    /*
     * 这个方法是没问题的
     * */
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK，id："+id+"\t"+"(*^▽^*)哈哈";
    }

    /*
     * 这个方法是有问题的 ----超时
     * */
    @HystrixCommand(fallbackMethod = "payment_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){
        // 故意制造超时，看看是否会降级，走下面的方法
        int timeNumber = 3;
//        int age = 10 / 0;

        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_Timeout，id："+id+"\t"+"(*^▽^*) 耗时 "+timeNumber+"秒钟";
    }

    /*
     * 这是一个给 paymentInfo_Timeout 方法做服务降级的方法
     * */
    public String payment_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"系统繁忙或运行错误，请稍后再试，id："+id+"\t"+"┭┮﹏┭┮ ";
    }

    /*
     * 上面是服务降级，以下测试服务熔断------------------------------------------------------------------------------------
     * */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0)
            throw new RuntimeException("-----------id 不能为负数");
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+ "\t" + "调用成功，流水号"+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试，id："+id;
    }

}