package com.leetcode.train;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 4, 7, 5, 6};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(nums.toString());
    }


    public static void quickSort(int nums[], int left, int right) {
        if (left < right) {
            int middle = divison(nums, left, right);
            quickSort(nums, left, middle - 1);
            quickSort(nums, middle + 1, right);
        }
    }

    public static int divison(int nums[], int left, int right) {
        int base = nums[left];
        while (left < right) {
            //从右往左遍历，找到比base小的节点
            while (left < right && nums[right] >= base) {
                right--;
            }
            //从右往左遍历，找到比base小的节点后和互换
            nums[left] = nums[right];
            //从左往右 找到比base大的元素，将这元素
            while (left < right && nums[left] <= base) {
                left++;
            }
            //找到比base大的节点后 right 和 left 互换
            nums[right] = nums[left];
        }
        nums[left] = base;
        int middle = left;
        return middle;
    }


}
