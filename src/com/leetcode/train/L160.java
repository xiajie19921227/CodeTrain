package com.leetcode.train;

import java.util.HashSet;

public class L160 {

    /**
     * [4,1,8,4,5]
     * [5,6,1,8,4,5]
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode headA = new ListNode(-1);
        ListNode headB = new ListNode(-1);

        ListNode node_common_8 = new ListNode(8);
        ListNode node_A_4 = new ListNode(4);
        ListNode node_A_1 = new ListNode(1);
        ListNode node_common_4 = new ListNode(4);
        ListNode node_common_5 = new ListNode(5);

        headA.setNext(node_A_4);
        node_A_4.setNext(node_A_1);
        node_A_1.setNext(node_common_8);

        node_common_8.setNext(node_common_4);
        node_common_4.setNext(node_common_5);

        ListNode node_B_5 = new ListNode(5);
        ListNode node_B_6 = new ListNode(6);
        ListNode node_B_1 = new ListNode(1);

        headB.setNext(node_B_5);
        node_B_5.setNext(node_B_6);
        node_B_6.setNext(node_B_1);
        node_B_1.setNext(node_common_8);
        System.out.println(getLinkedListLength(headB));
        ListNode insertionNode = getInsertionNode_method2(headA, headB);
        if (insertionNode != null) {
            System.out.println(insertionNode.getVal());
        } else {
            System.out.println("null");
        }

    }


    public static ListNode getInsertionNode_method1(ListNode headA, ListNode headB) {
        HashSet<ListNode> listNodes = new HashSet<>();
        if (headA == null || headB == null) {
            return null;
        }
        ListNode point_A = headA;
        ListNode point_B = headB;
        while (point_A != null) {
            listNodes.add(point_A);
            point_A = point_A.next;
        }

        while (point_B != null) {
            if (listNodes.contains(point_B)) {
                return point_B;
            }
            point_B = point_B.next;
        }
        return null;
    }

    public static ListNode getInsertionNode_method2(ListNode headA, ListNode headB) {
        int length_A = getLinkedListLength(headA);
        int length_B = getLinkedListLength(headB);
        if (length_A > length_B) {
            int diff = length_A - length_B;
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
        }

        if (length_B > length_A) {
            int diff = length_B - length_A;
            for (int i = 0; i < diff; i++) {
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

    public static int getLinkedListLength(ListNode head) {
        int length = 0;
        head = head.next;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }


}
