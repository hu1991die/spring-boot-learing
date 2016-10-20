/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc 主程序入口
 * @Author feizi
 * @Date 2016/10/20 13:57
 * @Package_name com.feizi
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
