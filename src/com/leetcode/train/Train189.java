package com.leetcode.train;

import java.util.Arrays;

public class Train189 {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6};
        rotate( numbers, 2);
        System.out.println(Arrays.toString(numbers));
    }

    public static void rotate(int[] numbers, int k) {
        k = k % numbers.length;
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp = numbers[numbers.length - 1];
            for (int j = numbers.length-1; j > 0; j--) {
                numbers[j] = numbers[j-1];
            }
            numbers[0] = temp;
        }
    }
}
