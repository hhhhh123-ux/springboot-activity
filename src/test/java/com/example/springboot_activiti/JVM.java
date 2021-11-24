package com.example.springboot_activiti;

import com.example.springboot_activiti.common.utils.RandomUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
//-Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
public class JVM {
    @Test
    public void Test(){
        String str="swdfefesdfgsdgvsdgv";
        while(true){
            str+=str+new RandomUtil().nextInt(888888888)+new RandomUtil().nextInt(888888888);
        }
    }

    @Test
    public void Test2(){
      long maxMemory=  Runtime.getRuntime().maxMemory();
      long totalMemory=Runtime.getRuntime().totalMemory();

      System.out.println("max="+maxMemory+"字节"+(maxMemory/(double)1024/1024)+"MB");
        System.out.println("totalMemory=="+totalMemory+"字节"+(totalMemory/(double)1024/1024)+"MB");
    }

    byte[] bytes=new byte[1*1024*1024];

    @Test
    public void Test3(){
        ArrayList<JVM> list=new ArrayList<>();
        int count=0;

        try{
            while(true){
                list.add(new JVM());//
                count=count+1;
            }
        }catch (Exception e){
            System.out.println("count="+count);
            e.printStackTrace();
        }
    }
}
