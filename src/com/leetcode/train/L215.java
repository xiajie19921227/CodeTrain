package com.leetcode.train;

public class L215 {

    public static void main(String[] args) {
        System.out.println(getTopKindex(new int[]{3,1,2,4,5,6},1));
    }

    public static int getTopKindex(int[] nums,int K ){
      int left = 0;
      int right = nums.length-1;
      int index = parttion(nums,left,right);
      while (K-1 != index){
          if(K-1 >index){
             index = parttion(nums,index+1,right);
          }else {
              index = parttion(nums,left,index-1);
          }
      }
      return  nums[index];
    }

    public static int parttion(int[] nums, int left, int right) {
        int base = nums[left];
        while (left < right) {
           while (left <right && nums[right]<base){
             right--;
           }
           nums[left]= nums[right];
           while (left<right && nums[left] >base){
               left++;
           }
           nums[right] = nums[left];
        }
        nums[left]=base;
        int middle = left;
        return middle;
    }
}
