package com.example.springboot_activiti;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.ast.OpAnd;

import java.util.Optional;

public class ReverseDemo {
    @Test
    public void Test() {
        int x = -2147483648;
       int m= reverse(x);
       System.out.println(m);
    }

    public int reverse(int x) {
        boolean b=true;
        int m=0;
        if((x<=-2147483648) || (x>=2147483647)){
            return 0;
        } else if (x ==0) {
            return m;
        } else if(x>0){
            x=x;
        } else if (x < 0) {
            b=false;
            x=-x;
        }
        StringBuilder stringBuilder=new StringBuilder(String.valueOf(x));
        String key =stringBuilder.reverse().toString();
        double rev = Double.parseDouble(key);
        if(rev > Integer.MAX_VALUE){
            return 0; // 大于int范围输出0
        }
        m=Integer.valueOf(key);
        if(b){
          m=m;
        }else{
            m=-m;
        }

        return m;
    }

    public int reverse1(int x) {
        boolean b=true;
        int m=0;
        if((x<=-2147483648) || (x>=2147483647)){
            return 0;
        } else if (x ==0) {
            return m;
        } else if(x>0){
            x=x;
        } else if (x < 0) {
            b=false;
            x=-x;
        }



        StringBuilder stringBuilder=new StringBuilder(String.valueOf(x));
        String key =stringBuilder.reverse().toString();
        double rev = Double.parseDouble(key);
        if(rev > Integer.MAX_VALUE){
            return 0; // 大于int范围输出0
        }
        m=Integer.valueOf(key);
        if(b){
            m=m;
        }else{
            m=-m;
        }

        return m;
    }
}
