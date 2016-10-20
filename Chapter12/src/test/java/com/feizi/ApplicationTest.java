package com.feizi; 

import com.feizi.domain.User;
import com.feizi.domain.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* Application Tester. 
* Mybatis注解配置测试用例
* @author feizi
* @since 10/20/2016
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class ApplicationTest {

    @Autowired
    private UserMapper userMapper;

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
    @Rollback
    public void testMain() throws Exception { 
        //TODO: Test goes here...
        //insert 一条数据，并且select出来验证
        userMapper.insert("AAA",20);
        User u = userMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge().intValue());

        //update 一条数据，并且select出来验证
        u.setAge(30);
        userMapper.update(u);
        u = userMapper.findByName("AAA");
        Assert.assertEquals(30, u.getAge().intValue());

        //删除这条数据，并且select验证
        userMapper.delete(u.getId());
        u = userMapper.findByName("AAA");
        Assert.assertEquals(null, u);

        u = new User("BBB", 30);
        userMapper.insertByUser(u);
        Assert.assertEquals(30, userMapper.findByName("BBB").getAge().intValue());

        Map<String, Object> map = new HashMap<>();
        map.put("name", "CCC");
        map.put("age", 40);
        userMapper.insertByMap(map);
        Assert.assertEquals(40, userMapper.findByName("CCC").getAge().intValue());

        List<User> users = userMapper.findAll();
        for (User user : users){
            Assert.assertEquals(null, user.getId());
            Assert.assertNotEquals(null, user.getAge());
            Assert.assertNotEquals(null, user.getName());
        }
    } 
    
        
        
}
