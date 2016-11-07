/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Desc 消息消费者Receiver
 * @Author feizi
 * @Date 2016/11/7 13:23
 * @Package_name com.feizi.rabbit
 */
@Component
@RabbitListener(queues = "hello") //通过RabbitListener注解实现对hello队列的监听
public class Receiver {

    @RabbitHandler //通过RabbitHandler注解来指定方法对消息的消费
    public void process(String hello){
        System.out.println("Receiver:" + hello);
    }
}
