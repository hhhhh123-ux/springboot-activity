package com.example.springboot_activiti;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ThreadDemo extends Thread {
    @Override
    public void run() {
       for(int i=0;i<10;i++){
           System.out.println(Thread.currentThread().getName()+"-"+i);
       }
    }


    @Test
    public void Test(){
        ThreadDemo threadDemo=new ThreadDemo();
        threadDemo.start();
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"-"+i);
        }
    }
}
