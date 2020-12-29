package com.leetcode.train;

import java.util.ArrayList;

// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
public class L2 {
    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(8);

        l1_1.setNext(l1_2);
        l1_2.setNext(l1_3);

        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        ListNode l2_4 = new ListNode(5);

        l2_1.setNext(l2_2);
        l2_2.setNext(l2_3);
        l2_3.setNext(l2_4);
        ListNode num = addTwoNumbers(l1_1,l2_1);

        System.out.println(num);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = new ListNode(-1);
        ListNode currentNode = result;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum = sum + l1.getVal();
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.getVal();
                l2 = l2.next;
            }
            ListNode node = new ListNode((sum % 10));
            sum = sum / 10;
            currentNode.next = node;
            currentNode = currentNode.next;
        }

        //相加后如果进位还有1
        if (sum == 1) {
            currentNode.next = new ListNode(sum);
        }
        return result.next;
    }


    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;
        int length1 = 0;
        int length2 = 0;
        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();
        while (listNode1.next != null) {
            nums1.add(listNode1.getVal());
            length1++;
            listNode1 = listNode1.next;
        }
        while (listNode2.next != null) {
            nums2.add(listNode2.getVal());
            length2++;
            listNode2 = listNode2.next;
        }

        int nub1 = 0;
        for (int i = length1; length1 > 0; i--) {
            nub1 = getbeishu(length1) * nums1.get(i - length1) + nub1;
        }

        int nub2 = 0;
        for (int i = length2; length2 > 0; i--) {
            nub2 = getbeishu(length2) * nums1.get(i - length2) + nub2;
        }
        int sum = nub1 + nub2;

        return result;
    }

    public static int getbeishu(int length) {
        if (length == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < length - 1; i++) {
            result = result * 10;
        }
        return result;
    }
}
