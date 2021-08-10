package com.example.springboot_activiti.test;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RarcApplication implements Runnable {

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + "休息" + i + "步");
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //判断是否有胜利者出现了
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    //判断比赛是否结束了
    public boolean gameOver(int step) {
        if (winner != null) {
            return true;
        }
        {
            if (step >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println(winner + " is winner!");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RarcApplication application = new RarcApplication();

        new Thread(application, "兔子").start();
        new Thread(application, "乌龟").start();

    }
}
