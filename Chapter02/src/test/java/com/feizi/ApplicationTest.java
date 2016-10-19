package com.feizi; 

import com.feizi.service.BlogService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
* Application测试用例
* @author feizi
* @since 10/19/2016
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTest {

    private static final Log log = LogFactory.getLog(ApplicationTest.class);

    @Autowired
    private BlogService blogService;

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
        Assert.assertEquals("鬼脚飞", blogService.getName());
        Assert.assertEquals("Spring Boot教程", blogService.getTitle());
        Assert.assertEquals("鬼脚飞正在努力写《Spring Boot教程》", blogService.getDesc());

        log.info("随机数测试输出：");
        log.info("随机字符串 : " + blogService.getValue());
        log.info("随机int : " + blogService.getNumber());
        log.info("随机long : " + blogService.getBignumber());
        log.info("随机10以下 : " + blogService.getTest1());
        log.info("随机10-20 : " + blogService.getTest2());
    } 
}
