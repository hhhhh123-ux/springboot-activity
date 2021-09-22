package com.example.springboot_activiti;

import com.example.springboot_activiti.project.test.domain.ListNode;
import com.sun.javafx.scene.control.behavior.TreeTableCellBehavior;
import org.junit.jupiter.api.Test;

import java.util.*;

public class HashMapDemo {

    @Test
    public void test(){
//        HashMap<String,String> map=new HashMap<>();
//        map.put("null",null);
//        map.put("1,","1");
//        map.put("2","2");
//
//        TreeMap<String,String> treeMap=new TreeMap<>();
//
//        Hashtable<String,String> hashtable=new Hashtable<>();
//        List<String> list=new ArrayList<>();
//        list.add("1");
//        Map<String,String> map1=new HashMap<>();
//        map1.put("3","3");



//        Map<String,Object> params=new HashMap<>();
//
//        params.put("1","成功");
//        params.put("2","成功");

       int[] nums = {3,2,4};
       int target = 6;
       int [] a= twoSum2(nums,target);
       System.out.println(a);


    }

    public int[] twoSum(int[] nums, int target) {
        int sum;
        int [] a=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
             sum= nums[i]+nums[j];
             if(sum==target){
                 a[0]=i;
                 a[1]=j;
               return a;
             }
            }
        }
        return a;
    }

    public int[] twoSum2(int[] nums, int target) {
        int [] a=new int[2];
        Map<Integer,Integer> params=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int sum=target-nums[i];
            if(params.containsKey(sum)){
                 System.out.println("log");
                a[0]=params.get(sum);
                a[1]=i;

            }
            params.put(nums[i],i);
        }
        return a;
    }

    @Test
    public void ListNodetest(){

    }


}




