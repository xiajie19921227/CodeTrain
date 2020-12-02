package com.leetcode.train;

public class Train122 {

    public static void main(String[] args) {
        System.out.println(Train122.maxProfitGreedy(new int[]{1, 2, 3, 4, 5}));
        System.out.println(Train122.maxProfitDP(new int[]{1, 2, 3, 4, 5}));
    }

    /**
     * 贪心
     *
     * @param prices
     * @return
     */
    public static int maxProfitGreedy(int[] prices) {
        int result = 0;
        int diff = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                result = result + diff;
            }
        }
        return result;
    }

    /**
     * 动态规划
     *
     * @return
     */
    public static int maxProfitDP(int[] prices) {
        int length = prices.length;
        /**
         * 0:持有现金
         * 1：持有股票
         */
        int[][] dp = new int[length][2];
        //第一天持有现金
        dp[0][0] = 0;
        //第一天买入股票
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            /**
             * 第i 天
             * 持有现金：1.前一天也持有现金，不动  2.前一天持有股票今天卖出
             */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            /**
             * 第i 天
             * 持有股票：1.前一天也持有股票，不动  2.前一天持有现金今天买入
             */
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //最后一天
        return dp[length - 1][0];
    }
}
