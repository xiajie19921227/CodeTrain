package com.leetcode.train;

/**
 * 最长回文子串
 */
public class Train05 {
    public static void main(String[] args) {
        System.out.println(getTwoSadeSameString("abba"));
    }

    public static String getTwoSadeSameString(String str) {
        char[] charArray = str.toCharArray();
        int begin = 0;
        int maxLength = 1;
        for (int i = 0; i < charArray.length-1; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (validateTwoSadeSameString(charArray, i, j)) {
                    maxLength = Math.max(maxLength,j-i+1);
                }

            }
        }
        return str.substring(begin,begin+maxLength);
    }


    /**
     * 判断是否是回文串
     */
    public static boolean validateTwoSadeSameString(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
