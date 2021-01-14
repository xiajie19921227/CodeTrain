package com.leetcode.train;

public class offer10 {
    public static void main(String[] args) {
        System.out.println(numbWays(4));
    }

    public  static int numbWays(int n){
        return ways(n);
    }

    public  static int ways(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return ways(n - 1) + ways(n - 2);
    }

}
