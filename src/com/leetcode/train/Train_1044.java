package com.leetcode.train;

import java.util.Arrays;

public class Train_1044 {
    public static void main(String[] args) {
        String banana = new Train_1044().longestSub("banana");
        System.out.println("=====");
        System.out.println(banana);
    }

    public  String longestSub(String S){
        int len = S.length();
        /**
         * 求出后缀数组
         */
        String[] strs = new String[len];
        for(int i=0;i<len;i++){
            strs[i] = S.substring(i,len);
            System.out.println(strs[i]);
        }
        Arrays.sort(strs);
        String result = "";
        int maxLength = 0;
        /**
         * 两个相邻子串的最长公共前缀
         */
        for(int i =0;i<len-1;i++){
            int temp = lenTwoStr(strs[i],strs[i+1]);
            if(temp >maxLength){
                maxLength = temp;
                result = strs[i].substring(0,maxLength);
            }
        }

        return result;
    }


    /**
     * 两个后缀子串的最长公共子串
     * @param str1
     * @param str2
     * @return
     */
    public int lenTwoStr(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int i = 0;
        while (i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return i;
    }


}
