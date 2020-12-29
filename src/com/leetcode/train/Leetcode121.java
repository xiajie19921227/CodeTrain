package com.leetcode.train;

public class Leetcode121 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4, 100,300};
        System.out.println(new Leetcode121().maxProfit_DP(prices));
    }


    public int maxProfit_DP(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //第i天持有现金，不持有股票： （1）第i-1已经持有现金，（2）第i-1持有股票在第i天卖出
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //第i天持有股票： （1）第i-1已经持有股票，（2）第i-1天没有股票，在第i 天买入，因为只能买卖一次
            dp[i][1] = Math.max(dp[i-1][1],0-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    /**
     * 方法1：暴力法
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {

        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length - 1; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 方法2
     * 小找出最小的，最小的和高的直接的差值
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }
        return maxProfit;
    }

}
