package com.example.springboot_activiti;

import org.junit.jupiter.api.Test;

import java.util.Optional;


public class NDemo {
    @Test
    public void Test() {

        //String s = "hjouvsuyoypayulyeimuotehzriicfskpggkbbipzzrzucxamludfykgruowzgiooobppleqlwphapjnadqhdcnvwdtxjbmyppphauxnspusgdhiixqmbfjxjcvudjsuyibyebmwsiqyoygyxymzevypzvjegebeocfuftsxdixtigsieehkchzdflilrjqfnxztqrsvbspkyhsenbppkqtpddbuotbbqcwivrfxjujjddntgeiqvdgaijvwcyaubwewpjvygehljxepbpiwuqzdzubdubzvafspqpqwuzifwovyddwyvvburczmgyjgfdxvtnunneslsplwuiupfxlzbknhkwppanltcfirjcddsozoyvegurfwcsfmoxeqmrjowrghwlkobmeahkgccnaehhsveymqpxhlrnunyfdzrhbasjeuygafoubutpnimuwfjqsjxvkqdorxxvrwctdsneogvbpkxlpgdirbfcriqifpgynkrrefx";
        String s="ABC";
        int numRows = 2;
        String str = convert3(s, numRows);
        System.out.println(str);
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int l = s.length();
        int m = 0;
        char[][] ints = new char[numRows][l];
        for (int i = 0; i < l; i++) {
            int size = numRows * 2 - 2;
            int z=m%size;

            for (int j = 0; j < numRows; j++) {
                int b=size-j;
                if (m >= l) {
                    break;
                }
                if (z == j || z== b) {
                    ints[j][i] = s.charAt(m);
                    m = ++m;
                }
            }
        }
        String str = "";
        for (char[] num : ints) {
            str=str.concat(String.valueOf(num));
        }
        return str.replaceAll("\u0000", "");
    }


    public String convert2(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++)
            rows[i] = new StringBuilder();//StringBuilder数组使用前必须初始化
        char[] sArray = s.toCharArray();
        boolean reverse = true;//行号是否逆序(下面第一次会将其变为false)
        int row = 0;
        for(int i = 0; i < s.length(); i++){
            rows[row].append(sArray[i]);
            if(row == 0 || row == numRows-1) reverse = !reverse;
            if(reverse) row--;
            else if(!reverse) row++;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++) res.append(rows[i]);
        return res.toString();
    }


    public String convert3(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int l = s.length();
        int m = 0;
        int size = numRows * 2 - 2;
        StringBuilder[][] ints = new StringBuilder[numRows][l];
        for (int i = 0; i < l; i++) {
            int z=m%size;
            for (int j = 0; j < numRows; j++) {
                int b=size-j;
                if (m >= l) {
                    break;
                }
                if (z == j || z== b) {
                    System.out.println(s.charAt(m));
                   ints[j][i]= ints[j][i].append(s.charAt(m));
                    m = ++m;
                }
            }
        }
        String str = "";
        for (StringBuilder[] num : ints) {
            str=str.concat(String.valueOf(num));
        }
        return str.replaceAll("\u0000", "");

    }
}
