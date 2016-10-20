package com.feizi; 

import com.feizi.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* Application Tester. 
* 测试spring boot操作redis数据库
* @author feizi
* @since 10/20/2016
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

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
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

        // 保存对象
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());
    } 
    
        
        
}
