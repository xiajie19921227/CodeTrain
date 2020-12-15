package com.leetcode.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15 {


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums_0 = new int[]{0, 0, 0, 0, -1, -4};
        List<List<Integer>> lists = threeSum_2(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum_1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return result;
        }
        //对于这种需要去重的，都要先排队一下
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> numsList = new ArrayList<>();
                        numsList.add(nums[i]);
                        numsList.add(nums[j]);
                        numsList.add(nums[k]);
                        result.add(numsList);
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum_2(int[] nums) {
        List<List<Integer>> resultMap = new ArrayList<>();
        if (nums.length < 3) {
           //这种返回是List，如果为空也返回构造的类型
           return  resultMap;
        }
        //排序好
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //去除重复的，两个相邻相同的数，[-1,-1,2,3]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //定义双指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    resultMap.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去除重复的，两个相邻相同的数，[-1,-1,2,3,3]
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 每轮之后，再缩小范围
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right = right - 1;
                } else {
                    left = left + 1;
                }
            }
        }
        return resultMap;
    }

}
