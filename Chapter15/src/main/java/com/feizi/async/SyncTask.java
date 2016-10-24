/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Desc 测试同步任务调度
 * @Author feizi
 * @Date 2016/10/24 15:48
 * @Package_name com.feizi.async
 */
@Component
public class SyncTask {
    private static Random random = new Random();

    @Async //异步函数，将原来的同步调用变为异步调用
    public void doTaskOne() throws Exception{
        System.out.println("开始执行任务一...");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();

        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒!");
    }

    @Async
    public void doTaskTwo() throws Exception{
        System.out.println("开始执行任务二...");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();

        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒!");
    }

    @Async
    public void doTaskThree() throws Exception{
        System.out.println("开始执行任务三...");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();

        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒!");
    }
}
