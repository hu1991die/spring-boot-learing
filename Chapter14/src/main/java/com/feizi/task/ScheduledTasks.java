/*
* Copyright (c) 2014 Javaranger.com. All Rights Reserved.
*/
package com.feizi.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc 任务调度器
 * @Author feizi
 * @Date 2016/10/24 9:45
 * @Package_name com.feizi.task
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "*/5 * * * * *")// 每隔5秒执行一次
    public void reportCurrentTime(){
        System.out.println("当前时间：" + SIMPLE_DATE_FORMAT.format(new Date()));
    }
}
