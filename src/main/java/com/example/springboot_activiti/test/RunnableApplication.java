package com.example.springboot_activiti.test;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RunnableApplication implements Runnable {
    private int ticketNum = 10;
    @Override
    public void run() {
        while (true){
            if (ticketNum<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "拿走了第"+ ticketNum + "票。");
            ticketNum--;
        }
    }

    public static void main(String[] args) {
        RunnableApplication  runnableApplication1=new RunnableApplication();
        RunnableApplication  runnableApplication2=new RunnableApplication();
        RunnableApplication  runnableApplication3=new RunnableApplication();

        new Thread(runnableApplication1,"1").start();
        new Thread(runnableApplication2,"2").start();
        new Thread(runnableApplication3,"3").start();
    }
}
