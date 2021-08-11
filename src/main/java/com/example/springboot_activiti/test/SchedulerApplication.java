package com.example.springboot_activiti.test;

import com.example.springboot_activiti.common.utils.DateUtils;
import com.example.springboot_activiti.common.utils.mail.JavaMailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class SchedulerApplication {

    @Autowired
    JavaMailUtils javaMailUtils;
    //每隔20秒执行一次
    //每隔5分钟执行一次
    //@Scheduled(cron = "0/20 * * * * ?")
    public void Test() throws MessagingException {
        System.out.println("执行测试1"+ DateUtils.getTime());
        String subject = "SpringBoot1";
        String text="SpringBoot2";
        String from="643146450@qq.com";
        String to="643146450@qq.com";
        String jpg="1628649179.png";
        String url="D:\\xue\\1628649179.png";
        javaMailUtils.send(subject,text,from,to);
        javaMailUtils.sendMail(subject,text,from,to,jpg,url);
        System.out.println("执行测试2"+ DateUtils.getTime());
    }
}
