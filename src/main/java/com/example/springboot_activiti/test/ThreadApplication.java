package com.example.springboot_activiti.test;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ThreadApplication extends Thread {
    @Override
    public void run() {         //重写run方法
        for (int i = 0; i <= 10; i++) {
            System.out.println(i+"在学习多线程");
        }
    }
    public static void main(String[] args) {
        ThreadApplication threadApplication=new ThreadApplication();
        threadApplication.start();
        for (int i = 0; i <= 10; i++) {
            System.out.println("主方法"+i+"也在学习多线程");
        }
    }
}
