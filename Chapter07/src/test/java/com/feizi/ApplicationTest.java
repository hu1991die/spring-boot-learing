package com.feizi; 

import com.feizi.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* Application Tester. 
* 
* @author feizi
* @since 10/20/2016
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest { 

    @Autowired
    private UserService userService;

    @Before
    public void before() throws Exception { 
        //准备，首先清空user表
        userService.deleteAllUsers();
    } 

    @After
    public void after() throws Exception { 
        //TODO: Test goes here... 
    } 

        
    /** 
    * 
    * Method: main(String[] args) 
    * 
    */ 
    @Test
    public void testMain() throws Exception { 
        //插入5个用户
        userService.create(1L, "a", 1);
        userService.create(2L, "b", 2);
        userService.create(3L, "c", 3);
        userService.create(4L, "d", 4);
        userService.create(5L, "e", 5);

        //查询数据库，应该有5个用户
        Assert.assertEquals(5, userService.getAllUsers().intValue());

        //删除两个用户
        userService.deleteById(2L);
        userService.deleteById(4L);

        //查询数据库，应该有3个用户
        Assert.assertEquals(3, userService.getAllUsers().intValue());
    }
    
        
        
}
