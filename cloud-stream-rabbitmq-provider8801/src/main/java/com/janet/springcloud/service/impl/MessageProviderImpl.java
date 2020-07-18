package com.janet.springcloud.service.impl;

import com.janet.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description 发送消息接口实现类
 * @Date 2020/5/19
 * @Author Janet
 */
@EnableBinding(Source.class) //定义消息的推送管道，指信道channel和exchange绑定到一起
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("------serial:"+serial);
        return null;
    }
}
