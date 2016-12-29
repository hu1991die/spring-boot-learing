/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * @Desc 判断属性
 * @Author feizi
 * @Date 2016/12/29 9:45
 * @Package_name com.feizi
 */
public class HelloService {
    private String msg;

    public String sayHello(){
        return "hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
