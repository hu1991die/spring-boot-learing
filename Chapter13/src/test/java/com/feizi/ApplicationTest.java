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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/** 
* Application Tester. 
*  测试Spring Boot事务
* @author feizi
* @since 10/21/2016
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
    @Transactional
    public void testMain() throws Exception {
        //TODO: Test goes here...

        //创建10条记录
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGGGGGGGGGGGGGGGGGGG", 70));
        userRepository.save(new User("HHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));

        // 测试findAll，查询所有记录条数
        Assert.assertEquals(10, userRepository.count());

        // 测试findByName, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findByName("FFF").getAge().intValue());

        // 测试findUser, 查询姓名为EEE的User
        Assert.assertEquals(50, userRepository.findUser("EEE").getAge().intValue());

        // 测试findByNameAndAge, 查询姓名为DDD并且年龄为40的User
        Assert.assertEquals("DDD", userRepository.findByNameAndAge("DDD", 40).getName());

        // 测试删除姓名为AAA的User
        userRepository.delete(userRepository.findByName("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(9, userRepository.findAll().size());
    }
    
        
        
}
