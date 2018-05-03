package com.jsoft.framework.ssm.schedule;

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
     * 100秒=1000*100
     */
    @Scheduled(fixedDelay = 100000L)
    public void runJob(){
        log.info("定时任务执行：{}", System.currentTimeMillis());
    }
}
