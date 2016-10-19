/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.controller;

import com.feizi.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Desc HelloController业务控制
 * @Author feizi
 * @Date 2016/10/19 19:23
 * @Package_name com.feizi.controller
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() throws Exception{
        throw new Exception("程序内部错误");
    }

    @RequestMapping("/json")
    public String json() throws Exception{
        throw new MyException("系统繁忙");
    }

    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("host", "http://hu1991die.com");
        return "index";
    }
}
