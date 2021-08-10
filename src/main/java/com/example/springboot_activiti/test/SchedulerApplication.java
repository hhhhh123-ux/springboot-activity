package com.example.springboot_activiti.test;

import com.example.springboot_activiti.common.utils.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerApplication {
    //每隔20秒执行一次
    @Scheduled(cron = "0/20 * * * * ?")
    public void Test()
    {
        System.out.println("执行测试"+ DateUtils.getTime());
    }
}
