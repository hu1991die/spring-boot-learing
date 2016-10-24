package com.feizi; 

import com.feizi.async.AsyncCallBackTask;
import com.feizi.async.SyncTask;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/** 
* Application Tester. 
*  测试同步和异步操作，以及异步回调
* @author feizi
* @since 10/24/2016
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private SyncTask syncTask;

    @Autowired
    private AsyncCallBackTask asyncCallBackTask;

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
        long start = System.currentTimeMillis();
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    } 

    @Test
    public void testAsyncCallBackTask() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = asyncCallBackTask.doTaskOne();
        Future<String> task2 = asyncCallBackTask.doTaskTwo();
        Future<String> task3 = asyncCallBackTask.doTaskThree();

        while (true){
            if(task1.isDone() && task2.isDone() && task3.isDone()){
                //三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
        
}
