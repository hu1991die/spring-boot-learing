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

/** 
* Application Tester. 
*  测试Mybatis操作数据库
* @author feizi
* @since 10/20/2016
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional //测试结束回滚数据，保证测试单元每次运行的数据环境独立
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
        userMapper.insert("ZZZ", 110);
        User u = userMapper.findByName("HHH");
        Assert.assertEquals(80, u.getAge().intValue());
    } 
    
        
        
}
