package com.leetcode.train;

public class Leetcode121 {

    public static void main(String[] args) {
        int[] prices ={7,1,5,3,6,4,100};
        System.out.println(new Leetcode121().maxProfit2(prices));
    }


    /**
     * 方法1：暴力法
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {

        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length - 1; j++) {
               int profit =  prices[j] - prices[i];
               if(profit >maxProfit){
                    maxProfit = profit;
               }
            }
        }
        return maxProfit;
    }

    /**
     * 方法2
     * 小找出最小的，最小的和高的直接的差值
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for(int i=0; i < prices.length;i++){
            if(prices[i] < min){
              min = prices[i];
            }else {
                maxProfit = Math.max(maxProfit,prices[i] -min);
            }
        }
        return maxProfit;
    }

}
