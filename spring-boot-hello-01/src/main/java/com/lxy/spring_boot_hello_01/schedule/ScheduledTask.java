package com.lxy.spring_boot_hello_01.schedule;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Scheduled默认是不并发执行的
 * @author lxy
 *
 */
@Component
public class ScheduledTask {
	
	private Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    @Scheduled(cron = "0/10 * * * * ?") //每10秒执行一次
    public void scheduledTaskByCorn() {
    	logger.info("定时任务开始 ByCorn：" + new Date());
        scheduledTask();
        logger.info("定时任务结束 ByCorn：" + new Date());
    }

    @Scheduled(fixedRate = 10000) //每10秒执行一次
    public void scheduledTaskByFixedRate() {
    	logger.info("定时任务开始 ByFixedRate：" + new Date());
        scheduledTask();
        logger.info("定时任务结束 ByFixedRate：" + new Date());
    }

    @Scheduled(fixedDelay = 10000) //每10秒执行一次
    public void scheduledTaskByFixedDelay() {
    	logger.info("定时任务开始 ByFixedDelay：" + new Date());
        scheduledTask();
        logger.info("定时任务结束 ByFixedDelay：" + new Date());
    }

    private void scheduledTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
