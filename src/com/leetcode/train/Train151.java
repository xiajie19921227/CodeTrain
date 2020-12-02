package com.leetcode.train;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Train151 {
    public static void main(String[] args) {
        System.out.println(Train151.reverse(" hello nihao"));
    }

    public static String reverse(String s) {
        String[] strs = s.trim().split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals("")) {
                continue;
            }
            stringBuffer.append(strs[i]+" ");
        }
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        return stringBuffer.toString().trim();
    }
}
