package com.lxy.spring_boot_hello_01.schedule;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class AsyncScheduledTask {
	
	private Logger logger = LoggerFactory.getLogger(AsyncScheduledTask.class);

	@Scheduled(cron = "0/7 * * * * ?")
    @Async
    public void scheduledTaskV1() {
		logger.info("定时任务V3，定时任务1开始：" + new Date());
        scheduledTask();
        logger.info("定时任务V3，定时任务1结束：" + new Date());
    }

    @Scheduled(cron = "0/10 * * * * ?")
    @Async
    public void scheduledTaskV2() {
    	logger.info("定时任务V3，定时任务2开始：" + new Date());
        scheduledTask();
        logger.info("定时任务V3，定时任务2结束：" + new Date());
    }

    @Scheduled(cron = "0/22 * * * * ?")
    @Async
    public void scheduledTaskV3() {
    	logger.info("定时任务V3，定时任务3开始：" + new Date());
        scheduledTask();
        logger.info("定时任务V3，定时任务3结束：" + new Date());
    }

    private void scheduledTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
