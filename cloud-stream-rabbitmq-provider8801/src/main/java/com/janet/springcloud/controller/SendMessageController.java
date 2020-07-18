package com.janet.springcloud.controller;

import com.janet.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @discription: Stream 消息驱动之生产者
 * @author Janet
 * @Date 2020/6/11
*/
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String SendMessage(){
        return messageProvider.send();
    }
}
