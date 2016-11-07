/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Desc 消息生产者Sender
 * @Author feizi
 * @Date 2016/11/7 13:25
 * @Package_name com.feizi.rabbit
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbAmqpTemplate;

    public void send(){
        String context = "hello " + new Date();
        System.out.println("Sender :" + context);
        //产生一个字符串，并发送到名为hello的队列中
        this.rabbAmqpTemplate.convertAndSend("hello", context);
    }
}
