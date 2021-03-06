/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Desc HelloController控制器类
 * @Author feizi
 * @Date 2016/10/26 13:40
 * @Package_name com.feizi.controller
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String index(@RequestParam String name){
        return "Hello " + name;
    }
}
