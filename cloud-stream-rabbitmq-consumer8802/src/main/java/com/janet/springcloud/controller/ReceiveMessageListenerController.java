package com.janet.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author Janet
 * @Date 2020/6/27
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        // 用 withPayload 发送，用 getPayload 接收
        System.out.println("消费者 1 号，------------> 接收到的消息"+message.getPayload()+"\t port: "+serverPort);
    }
}
