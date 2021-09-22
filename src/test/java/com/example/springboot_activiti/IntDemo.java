package com.example.springboot_activiti;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

public class IntDemo {
    @Test
    public void test() {
          int[] nums1={2};
          int[] nums2={};
        double b=  findMedianSortedArrays(nums1,nums2);
        System.out.println(b);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1=nums1.length;
        int num2=nums2.length;
        int[] c=new int[num1+num2];
        int cl=c.length;
        double d=0.00000;
        for(int i=0;i<num1;i++){
            c[i]=nums1[i];
        }
        for(int i=0;i<num2;i++){
            c[num1+i]=nums2[i];
        }
        Arrays.sort(c);
        if(cl%2==0){
            d=(c[cl/2]+c[(cl/2)-1])/2.00000;
        }else if(cl%2==1) {
            d = c[cl / 2] / 1.00000;
        }
        return d;
    }
}
