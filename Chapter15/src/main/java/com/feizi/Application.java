/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Desc
 * @Author feizi
 * @Date 2016/10/24 15:38
 * @Package_name com.feizi
 */
@SpringBootApplication
@EnableAsync //启用异步调用，使@Async注解能够生效
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
