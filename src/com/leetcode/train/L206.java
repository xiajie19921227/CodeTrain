package com.leetcode.train;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;

/**
 *   翻转链表
 */
public class L206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4);
        ListNode l1_5 = new ListNode(5);
        head.setNext(l1_1);
        l1_1.setNext(l1_2);
        l1_2.setNext(l1_3);
        l1_3.setNext(l1_4);
        l1_4.setNext(l1_5);
        l1_5.setNext(null);
        ListNode revertList = reverseList_twoProint(head);
        printLinkedList(revertList);

    }

    public  static ListNode reverseList_twoProint(ListNode head){
        ListNode preNode = null;
        ListNode current = head;
        while (current!=null){
            ListNode temp = current.next;
            current.next = preNode;
            preNode = current;
            current = temp;
        }
        return preNode;
    }



    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newList = new ListNode(-1);
        ListNode current = newList;

        while (head.next != null) {
            addNode(current, head.next.val);
            head = head.next;
        }
        return newList;
    }

    public static void addNode(ListNode head, int value) {
        if (head.next == null) {
            head.next = new ListNode(value);
            return;
        }
        ListNode temp = head.next;
        ListNode insertNode = new ListNode(value);
        insertNode.next = temp;
        head.next = insertNode;
        //Collections.reverse();

    }

    public static void printLinkedList(ListNode head) {
        if (head.next == null) {
            System.out.println("没有节点");
            return;
        }
        while (head.next != null) {
            System.out.println(head.next.getVal());
            head.next = head.next.next;
        }
    }


}
