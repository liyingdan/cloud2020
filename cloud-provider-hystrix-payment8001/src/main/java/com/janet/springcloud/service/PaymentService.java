package com.janet.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
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
}