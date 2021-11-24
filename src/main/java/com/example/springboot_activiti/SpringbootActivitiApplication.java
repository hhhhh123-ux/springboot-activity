package com.example.springboot_activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(basePackages = {"com.example.springboot_activiti.**.mapper"})
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableScheduling
@EnableAsync
public class SpringbootActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootActivitiApplication.class, args);
        System.out.println("springBoot-activiti1 启动成功");
    }

}
