package com.feizi; 

import com.feizi.domain.User;
import com.feizi.domain.UserRepository;
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
* 测试用例操作MongoDB数据库
* @author feizi
* @since 10/20/2016
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void before() throws Exception { 
        //TODO: Test goes here...
        //首先清空数据库表数据
        userRepository.deleteAll();
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

        //创建三个User，并且验证User总数
        userRepository.save(new User(1L, "A1", 30));
        userRepository.save(new User(2L, "B1", 40));
        userRepository.save(new User(3L, "C1", 50));

        Assert.assertEquals(3, userRepository.findAll().size());

        //删除一个User，再次验证User集合总数
        User u = userRepository.findOne(1L);
        userRepository.delete(u);
        Assert.assertEquals(2,userRepository.count());

        //删除一个User，再验证User集合总数
        u = userRepository.findByUsername("C1");
        userRepository.delete(u);
        Assert.assertEquals(1, userRepository.findAll().size());

        //删除一个User，再验证User集合总数,直接根据Id删除
        userRepository.delete(2L);
        Assert.assertEquals(0,userRepository.count());
    }
    
        
        
}
