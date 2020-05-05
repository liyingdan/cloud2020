package com.janet.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import java.util.List;

/**
 * @author Janet
 * @date 2020/5/5
 *
 * 手写 Ribbon 轮询接口类
 */
public interface LoadBalancer {
    // 收集现在服务器集群上总共有多少台提供服务的机器
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
