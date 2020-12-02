package com.leetcode.train;

public class Train1143 {
    public static void main(String[] args) {
        System.out.println(Train1143.lengthestCommonSubSequence("abce","abcde"));
    }

    public static int lengthestCommonSubSequence(String text1,String text2){
        if(text1 == null || text2 == null){
          return 0;
        }
        int length1 = text1.length();
        int length2 = text2.length();
        char[] chars1 = text1.toCharArray();
        char[] chars2= text2.toCharArray();
        int[][] dp = new int[length1+1][length2+1];
        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
               if(chars1[i-1] == chars2[j-1]){
                  dp[i][j] = dp[i-1][j-1]+1;
               }else{
                   dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
               }
            }
        }
        return dp[length1][length2];
    }
}
