/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Desc HelloController业务控制
 * @Author feizi
 * @Date 2016/10/19 18:19
 * @Package_name com.feizi.controller
 */
@RestController
public class HelloController {

    @ApiIgnore
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index(){
        return "Hello World!";
    }
}
