package com.leetcode.train;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class LeetCode142 {

    public ListNode findCycle(ListNode head){
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode currentNode = head;
        while (currentNode!=null){
            if(visited.contains(currentNode)){
                return currentNode;
            }
            visited.add(currentNode);
            currentNode = currentNode.next;
        }
        return null;
    }
}


