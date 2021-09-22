package com.example.springboot_activiti.test;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 *      排序算法
 *
 *
 *
 *
 */
public class ArrayApplication {
    public static void main(String[] args) {
        int[] array = {1,2,6,5,48,9};
        int[] a = sort(array);
        System.out.println(Arrays.toString(a));
    }

    public static int[] sort(int[] array) {
        int temp = 0;
        int j;
        for(j=0;j<array.length-1;j++){
            if(array[j]>array[j+1]){
                temp=array[j];
                array[j]=array[j+1];
                array[j+1]=temp;
            }
        }
        return array;
    }
}
