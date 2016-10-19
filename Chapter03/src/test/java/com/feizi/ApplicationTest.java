package com.feizi; 

import com.feizi.controller.HelloController;
import com.feizi.controller.UserController;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/** 
* Application Tester. 
* Application测试用例，测试RESTFul API 接口
* @author feizi
* @since 10/19/2016
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ApplicationTest {

    private MockMvc mockMvc;

    @Before
    public void before() throws Exception { 
        mockMvc = MockMvcBuilders.standaloneSetup(
                new HelloController(),
                new UserController()
        ).build();
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
    public void testGetHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Hello World!")));
    }

    /**
     * @Desc 测试UserController
     * @Author feizi
     * @Date 2016/10/19 15:27
     * @param
     * @return
     */
    @Test
    public void testUserController() throws Exception{
        RequestBuilder request = null;

        //1、get查询一下user列表集合，默认应该为空
        request = MockMvcRequestBuilders.get("/users/");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[]")));

        // 2、post提交一个user
        request = MockMvcRequestBuilders.post("/users/")
                .param("id", "1")
                .param("name", "飞子")
                .param("age", "20");
        mockMvc.perform(request)
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("success")));

        // 3、get获取user列表，获取刚刚插入的数据
        request = MockMvcRequestBuilders.get("/users/");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[{\"id\":1,\"name\":\"飞子\",\"age\":20}]")));

        // 4、put修改id为1的user
        request = MockMvcRequestBuilders.put("/users/1")
                .param("name", "鬼脚飞")
                .param("age", "30");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("success")));

        //5、get一个id为1的user
        request = MockMvcRequestBuilders.get("/users/1");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("{\"id\":1,\"name\":\"鬼脚飞\",\"age\":30}")));

        // 6、del删除id为1的user
        request = MockMvcRequestBuilders.delete("/users/1");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("success")));

        // 7、get查询一下user列表集合，应该为空
        request = MockMvcRequestBuilders.get("/users/");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[]")));
    }
}
