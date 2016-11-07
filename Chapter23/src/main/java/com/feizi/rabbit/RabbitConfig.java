/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc RabbitMQ配置类，用来配置队列、交换器、路由等高级信息
 * @Author feizi
 * @Date 2016/11/7 13:22
 * @Package_name com.feizi.rabbit
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
}
