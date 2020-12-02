package com.leetcode.train;

import java.util.HashMap;
import java.util.Map;

public class Train03 {
    public static void main(String[] args) {
        String s = "abbcd";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        int end = 0;

        Map<Character,Integer> map = new HashMap<>();
        for(;end<s.length();end++){
            char endPositonChar = s.charAt(end);
            if(map.containsKey(endPositonChar)){
                start = Math.max(start,map.get(endPositonChar)+1);
            }
            maxLength = Math.max(maxLength,end -start+1);
            map.put(endPositonChar,end);
        }
        return maxLength;

    }
}
