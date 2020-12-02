package com.leetcode.train;

import java.util.HashMap;
import java.util.Stack;

public class Train20 {
    public static void main(String[] args) {
        System.out.println(isVaildKuoHao("[]{}[]"));
    }

    public static boolean  isVaildKuoHao(String str){
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> characterMap = new HashMap<>();
        characterMap.put(')','(');
        characterMap.put(']','[');
        characterMap.put('}','{');
        for(int i =0;i<str.length();i++){
            if(characterMap.containsKey(str.charAt(i))){
                Character popChar = stack.isEmpty() ? '#' : stack.pop();
                if (!popChar.equals(characterMap.get(str.charAt(i)))) {
                    return false;
                }
            }else{
                stack.push(str.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
