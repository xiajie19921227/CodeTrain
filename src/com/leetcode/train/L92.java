package com.leetcode.train;


import java.util.ArrayList;
import java.util.List;

/**
 *  翻转链表从M到N
 */
public class L92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        List<Integer> listNodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            listNodes.add(current.val);
            current = current.next;
        }
        int i = m - 1;
        int j = n - 1;
        while (i < j) {
            listNodes.set(i, listNodes.get(j));
            listNodes.set(j, listNodes.get(i));
            i++;
            j--;
        }
        ListNode pre = new ListNode(-1);
        for (int k = 0; k < listNodes.size(); k++) {
            ListNode node = new ListNode(listNodes.get(k));
            pre.next = node;
            pre = node;
        }
        return pre;
    }
}
