package com.leetcode.train;

public class L309 {
    public  static int maxProfit(int[] prices){
        // 0 冷冻，1 买入，2 卖出
        int[][] dp = new int[prices.length][3];
        int maxProfit =0;

        /**
         * dp[i][0] 表示持有股票
         * dp[i][1]         不持有股票，在冷冻期（前一天把股票卖了）
         * dp[i][2]         不持有股票，不在冷冻期（前一天没有卖股票）
         */
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        maxProfit = Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
        return  maxProfit;
    }
}
