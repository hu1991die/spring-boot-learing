/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @Desc
 * @Author feizi
 * @Date 2016/10/24 16:08
 * @Package_name com.feizi.async
 */
@Component
public class AsyncCallBackTask {
    private static Random random = new Random();

    @Async
    public Future<String> doTaskOne() throws Exception{
        System.out.println("开始执行任务一...");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();

        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒!");
        return new AsyncResult<>("任务一完成");
    }

    @Async
    public Future<String> doTaskTwo() throws Exception{
        System.out.println("开始执行任务二...");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();

        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒!");
        return new AsyncResult<>("任务二完成");
    }

    @Async
    public Future<String> doTaskThree() throws Exception{
        System.out.println("开始执行任务三...");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();

        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒!");
        return new AsyncResult<>("任务三完成");
    }
}
