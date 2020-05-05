package com.janet.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Janet
 * @date 2020/5/5
 *
 * 手写 Ribbon 轮询实现类
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //获取 rest 接口第几次请求数
    public final int getAndIncrement(){
        int current;
        int next;  //代表是第几次访问
        do {
            // 第一次current 等于当前的初始值0
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
            // current 是期望值，next 是修改值.this.atomicInteger.compareAndSet(current,next) 表示当前值与期望值一样，
            // 就修改，返回 true。那整体就返回 false，跳出循环。如果不行，就一直自旋，直到取到要要的值
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("-----第几次访问------次数：next："+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        //getAndIncrement()代表第几次访问，serviceInstances.size() 代表集群数量
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
