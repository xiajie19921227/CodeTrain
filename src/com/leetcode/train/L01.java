package com.leetcode.train;

import java.util.HashMap;

public class L01 {
    public static void main(String[] args) {
        int[] result =  twoSum_2(new int []{2,5,5,11},10);
        System.out.println(result);
    }

    public static int[] twoSum_1(int[] nums, int target) {
        if (nums.length < 1) {
            return null;
        }
        int[] targerNums = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    targerNums[0] = i;
                    targerNums[1] = j;
                }
            }
        }
        return targerNums;
    }

    public static int[] twoSum_2(int[] nums, int target) {
        if (nums.length < 0) {
            return null;
        }
        HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length ; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            numsMap.put(nums[i], i);
        }
        return null;
    }
}
