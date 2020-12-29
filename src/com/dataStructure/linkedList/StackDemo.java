package com.dataStructure.linkedList;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
       Stack<Integer> stack = new Stack<Integer>();
       stack.push(1);
       stack.push(2);
       stack.push(3);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.toString());
    }

}
