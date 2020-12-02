package com.leetcode.train;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。

 */
public class Leetcode20 {
    public static void main(String[] args) {
        System.out.println(isValid("[(()]"));

    }

   static   boolean isValid(String s){
         HashMap<Character,Character>   mapping = new  HashMap<Character,Character>();
         mapping.put(')','(');
         mapping.put('}','{');
         mapping.put(']','[');

         Stack<Character>  stack =   new Stack<Character>();
         for(int i=0;i<s.length();i++){
            char charNow = s.charAt(i);
            //如果是闭合
            if(mapping.containsKey(charNow)){
                char topElement = stack.isEmpty() ?'#':stack.pop();
                if(topElement  != mapping.get(charNow)){
                    return false;
                }
            }else{
                stack.push(charNow);
            }
         }
         return stack.isEmpty();
    }

}
