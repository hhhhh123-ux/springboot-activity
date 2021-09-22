package com.example.springboot_activiti;

import org.apache.commons.compress.utils.Lists;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringDemo {


    @Test
    public void test() {
        lengthOfLongestSubstring2("ckilbkd");
    }

    public int lengthOfLongestSubstring(String s) {
        String result = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            String ss = String.valueOf(c);
            if (i > 0) {
                if (ss.equals(String.valueOf(s.charAt(i - 1)))) {
                    if(i<length/2){
                        result = result.replace(result,"");
                    }

                }

            }
            if (!result.contains(ss)) {
                if(!ss.equals(String.valueOf(s.charAt(i - 1)))){
                    result=result.concat("");
                }else {
                    result = result.concat(ss);
                }
            }

        }
        return result.length();
    }
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> maps = new HashMap<>();
        int n = s.length();
        int maxLen = 0;
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            int index = maps.getOrDefault(s.charAt(i), -1);
            if (index == -1) {
                //当前字符不出现在map中，直接比较长度
                maxLen = Math.max(i - startIndex + 1, maxLen);
            } else {
                //当前字符出现在map中，判断出现的位置是否大于等于开始计算的位置，如果是更新到出现位置+1
                if (index >= startIndex) {
                    startIndex = index + 1;
                }
                //更新了新的位置之后，这里要再计算一次
                maxLen = Math.max(i - startIndex + 1, maxLen);
            }
            maps.put(s.charAt(i), i);
        }
        return maxLen;
    }

}
