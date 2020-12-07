package com.leetcode.train;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class L21 {
    public static void main(String[] args) {


        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(4);

        l1_1.setNext(l1_2);
        l1_2.setNext(l1_3);

        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        ListNode l2_4 = new ListNode(5);

        l2_1.setNext(l2_2);
        l2_2.setNext(l2_3);
        l2_3.setNext(l2_4);
       printLinkedList(mergeTwoList_3(l1_1 ,l2_1));
    }

    public static  void printLinkedList(ListNode head) {
        if (head.next == null) {
            System.out.println("没有节点");
            return;
        }
        while (head.next != null) {
            System.out.println(head.next.getVal());
            head.next = head.next.next;
        }
    }

    public  static  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head = null;

        if(l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }else {
            head = l2;
            head.next =  mergeTwoLists(l1,l2.next);
        }
        return  head;
    }

    public static ListNode mergeTwoList_2(ListNode l1,ListNode l2){

        ListNode mergeHead = new ListNode(-1);
        ListNode temp = mergeHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }

        if (l1 !=null){
            temp.next = l1;
        }

        if (l2 !=null){
            temp.next = l2;
        }
        return  mergeHead.next;
    }

    public  static  ListNode mergeTwoList_3(ListNode l1 , ListNode l2){
        List<Integer> nodeValues= new ArrayList<Integer>();
      while (l1!=null){
          nodeValues.add(l1.getVal());
          l1 = l1.next;
      }
      while (l2!=null){
          nodeValues.add(l2.getVal());
          l2 = l2.next;
      }
      ListNode mergeList = new ListNode(-1);
      ListNode current = mergeList;
      Collections.sort(nodeValues);
      for(int value:nodeValues){
         ListNode newNode =  new ListNode(value);
          current.next = newNode;
          current = current.next;
      }
      return  mergeList.next;

    }



}
