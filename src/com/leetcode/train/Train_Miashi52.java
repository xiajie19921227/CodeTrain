package com.leetcode.train;

import java.util.List;

public class Train_Miashi52 {


    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        int aLength = 0;
        int bLength = 0;
        while (headA.next != null) {
            aLength++;
            headA = headA.next;
        }
        while (headB.next != null) {
            bLength++;
            headB = headB.next;
        }
        if (aLength > bLength) {
            for (int i = 0; i < aLength - bLength; i++) {
                headA = headA.next;
            }
        }
        if (bLength > aLength) {
            for (int i = 0; i < bLength - aLength; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
