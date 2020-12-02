package com.leetcode.train;

public class Train309 {
    public static void main(String[] args) {
        System.out.println(new Train309().maxProfit(new int[]{1,2,3,0,2}));
    }

    public int maxProfit(int[] prices){
        /**
         *日期
         * 0 持有股票
         * 1  不持股票，在冷冻期内
         * 2  不持有股票，不在冷冻期
         */
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        return  Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }
}
