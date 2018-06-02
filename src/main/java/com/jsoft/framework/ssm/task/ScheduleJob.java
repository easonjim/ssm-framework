package com.jsoft.framework.ssm.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 定时任务
 *
 * @author jim
 * @date 2018/05/03
 */
@Service
@Slf4j
public class ScheduleJob {

    /**
     * 定时任务执行
     * XML方式
     */
    public void runJob(){
        log.info("XML定时任务执行：{}", System.currentTimeMillis());
    }

    /**
     * 定时任务执行
     * 注解方式
     * 每5秒执行一次
     */
    @Scheduled(cron = "0/5 * * * * *")
    public void runJob2(){
        log.info("注解定时任务执行：{}", System.currentTimeMillis());
    }
}
