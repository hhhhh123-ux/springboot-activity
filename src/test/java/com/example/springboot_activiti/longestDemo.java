package com.example.springboot_activiti;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class longestDemo {
    @Test
    public void Test() {
        String s = "cbbd";
        longestPalindrome(s);
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int charslength = chars.length;
        int start = 0;
        int end = 0;
        int m = 0;
        List<Integer> list = new ArrayList<>();
        List<String> listString = new ArrayList<>();
        for (int i = 1; i < charslength - 1; i++) {

            int c = i - start;
            int d = charslength - i - 1;
            if (c > d) {
                m = d;
            } else if (c < d) {
                m = c;
            } else if (c == d) {
                m = c;
            }
            int h = 0;
            int k=0;
            for (int j = i; j > 0; j--) {
                int o = j - 1;
                int p = i - j + i + 1;
                if (p < charslength) {
                    if (chars[o] == chars[p]) {
                        h = ++h;
                        listString.add(s.substring(o,p+1));
                    }
                }
            }
            k = 2 * h + 1;
            list.add(k);
        }
        System.out.println(list);
        System.out.println(listString);
        String ssss = String.valueOf(Collections.max(list));
        return ssss;
    }
}
