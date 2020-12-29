package com.leetcode.train;

import java.util.HashSet;
import java.util.Set;

public class L3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubString("babcdeb"));
    }

    public static int lengthOfLongestSubString(String s) {
        Set<Character> charSet = new HashSet<>();
        int right = -1;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                charSet.remove(s.charAt(i - 1));
            }
            while (right + 1 < s.length() && !charSet.contains(s.charAt(right + 1))) {
                charSet.add(s.charAt(right + 1));
                right++;
            }
            //比较从当前最左边开始的最长的字串长度和之前其他位置最长的大小
            result = Math.max(result, right - i + 1);
        }
        return result;
    }
}
