package com.leetcode.train;

import java.util.Stack;

public class M09 {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);

        System.out.println(cQueue.deleteHead());
    }

    static class CQueue {
        private  Stack<Integer> stack1 ;
        private  Stack<Integer> stack2 ;
        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
           if (!stack2.isEmpty()){
              return stack2.pop();
           }
           if(!stack1.isEmpty()&&stack2.isEmpty()){
              while (!stack1.isEmpty()){
                  Integer pop = stack1.pop();
                  stack2.push(pop);
              }
              return stack2.pop();
           }else {
               return -1;
           }
        }
    }
}
