package com.feizi; 

import com.feizi.rabbit.Sender;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* Application Tester. 
*  RabbitMQ消息队列测试用例，调用消息生产
* @author feizi
* @since 11/07/2016
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private Sender sender;

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
        sender.send();
    } 
    
        
        
}
