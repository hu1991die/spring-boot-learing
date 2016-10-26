package com.feizi; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* Application Tester. 
* 测试使用log4j将http请求日志信息写入mongodb数据库
* @author feizi
* @since 10/26/2016
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest { 

    @Before
    public void before() throws Exception { 
        //TODO: Test goes here... 
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
        //TODO: Test goes here... 
    } 
    
        
        
}
