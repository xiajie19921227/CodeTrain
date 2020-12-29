package com.leetcode.train;

public class L25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 0){
            return head;
        }
        ListNode hair = new ListNode(-1);
        hair.next = head;
        ListNode pre = hair;
        int n =k;
        while (pre.next!=null){
            ListNode temp = pre;
            //遍历得到K长度的链表
            while (temp.next!=null && n>0){
                temp = temp.next;
                n--;
            }

            //有满足K个一组的元素，K有大于K个元素
            //  1->2->3->4->5
            //           temp
            //  1->2->3->4 ->5
            //  kNodehead
            //  4->3->2->1
            //           kNodehead
            if(n==0){
                ListNode nextNode = temp.next;
                nextNode.next = null;
                ListNode kNodeHead = pre.next;
                pre.next = reverse(kNodeHead);
                kNodeHead.next = nextNode;
                pre = kNodeHead;
                n = k;
            }else {
                //不足K个元素
                break;
            }
        }
        return hair.next;
    }

    public ListNode reverse(ListNode  head){
        ListNode pre = null;
        ListNode current = head;
        ListNode temp = null;
        while (current!=null){
            pre = current;
            temp = current.next;
            current.next = pre;
            current = temp;
        }
        return pre;
    }
}
