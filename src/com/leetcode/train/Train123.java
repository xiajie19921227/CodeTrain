package com.leetcode.train;

public class Train123 {
    public static void main(String[] args) {
        System.out.println(Train123.maxProfitDP(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    public static int maxProfitDP(int[] prices) {

        int length = prices.length;
        /**
         * 三维数组
         * 1.时间
         * 2.状态 0 现金；1 股票
         * 3.卖出次数 0 没有 1，2
         */
        int[][][] dp = new int[length][2][3];
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = -prices[0];
        dp[0][1][2] = -prices[0];
        for (int i = 1; i < length; i++) {
            /**
             * 现金，卖出0次
             */
            dp[i][0][0] = 0;

            /**
             * 现金，卖出1次
             * 1.之前持有现金，不动
             * 2.之前持有股票，今天卖掉
             */
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);

            /**
             * 现金，卖出2次
             * 1.之前持有现金，不动
             * 2.之前持有股票，今天卖掉
             */
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);

            /**
             * 持有股票，卖出0次
             *1.昨天持有股票，之前卖出0次
             *2.昨天持有现金，今天买入股票
             */
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);

            /**
             * 持有股票，卖出1次
             * 1.昨天持有股票，但之前已经卖出1次 dp[i-1][1][1]
             * 2.昨天持有现金，但是之前已经卖出一次，今天买入股票 dp[i-1][0][1]-prices[i]
             */
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);

            /**
             * 持有股票，卖出2次
             * 1.昨天持有股票，但之前已经卖出2次，dp[i-1][1][1]
             * 2.昨天持有现金，但是之前已经卖出2次，今天买入股票
             */
            dp[i][1][2] = Math.max(dp[i - 1][1][2], dp[i - 1][0][2] - prices[i]);
        }
        return Math.max(dp[length - 1][0][1], dp[length - 1][0][2]);
    }
}
