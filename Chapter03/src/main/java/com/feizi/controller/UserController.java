/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.controller;

import com.feizi.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Desc
 * @Author feizi
 * @Date 2016/10/19 14:04
 * @Package_name com.feizi.controller
 */
@RestController
@RequestMapping(value = "/users")   //通过在这里配置使得下面的映射路径都在/users下面，可以去除,主要用作分层处理,层次清晰
public class UserController {

    //创建线程安全的Map
    static Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<Long, User>());

    /**
     * @Desc 查询User列表集合
     * @Author feizi
     * @Date 2016/10/19 14:41
     * @param
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList(){
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件获取翻页信息的传递
        List<User> userList = new ArrayList<>(userMap.values());
        return userList;
    }

    /**
     * @Desc 新增User信息
     * @Author feizi
     * @Date 2016/10/19 14:41
     * @param
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        userMap.put(user.getId(), user);
        return "success";
    }

    /**
     * @Desc 根据id查询User信息
     * @Author feizi
     * @Date 2016/10/19 14:40
     * @param
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return userMap.get(id);
    }

    /**
     * @Desc 更新User信息
     * @Author feizi
     * @Date 2016/10/19 14:40
     * @param
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user){
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = userMap.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        userMap.put(id, u);
        return "success";
    }

    /**
     * @Desc 删除User信息
     * @Author feizi
     * @Date 2016/10/19 14:40
     * @param
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        // 处理"/users/{id}"的DELETE请求，用来删除User
        userMap.remove(id);
        return "success";
    }
}
