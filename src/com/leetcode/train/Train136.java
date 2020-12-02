package com.leetcode.train;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Train136 {
    public static void main(String[] args) {
        int[]   numbers = {1,2,2,3,3,1,7};
        System.out.println( Train136.singleNumber(numbers));
    }

    public static int singleNumber(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<numbers.length;i++){
            if(set.contains(numbers[i])){
                set.remove(numbers[i]);
            }else{
                set.add(numbers[i]);
        }
    }
        return set.iterator().next();
    }

}
