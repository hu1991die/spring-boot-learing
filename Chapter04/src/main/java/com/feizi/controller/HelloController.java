/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Desc HelloController业务控制类
 * @Author feizi
 * @Date 2016/10/19 16:45
 * @Package_name com.feizi.controller
 * 这里需要注意了：前面的示例中都是通过@RestController来处理请求，所以返回的内容为json对象
 * 如果需要渲染html页面，则直接使用@Controller来处理请求
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping("/")
    public String index(ModelMap map){
        // 加入一个属性，用于在模板中进行读取
        map.addAttribute("host", "http://hu1991die.com");
        // return模板文件的名称，对应src/main/resources/templates/home.html
        return "home";
    }
}
