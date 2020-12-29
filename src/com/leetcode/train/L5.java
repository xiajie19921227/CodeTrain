package com.leetcode.train;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class L5 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("a"));
        System.out.println(longestPalindrome("a"));
    }

    public  static String longestPalindrome(String s) {
        if (s == null || s == "") {
            return null;
        }
        char[] chars = s.toCharArray();
        if (chars.length == 2 && isPalindrome(s)) {
            return s;
        }
        if (chars.length == 1) {
            return s;
        }
        int point1 = 0;
        int point2 = 1;
        String result = s.substring(point1, point2);
        for (int i = 0; i < chars.length - 1; i++) {
            point1 = i;
            for (int j = i + 1; j < chars.length; j++) {
                point2 = j;
                String sub_str = s.substring(point1, point2 + 1);
                if (isPalindrome(sub_str)) {
                    result = result.length() < sub_str.length() ? sub_str : result;
                }
            }
        }

        return result;
    }

    public  static   boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        char[] s_char = s.toCharArray();
        int length = s_char.length;
        for (int i = 0; i < length - 1; i++) {
            if (s_char[i] != s_char[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
