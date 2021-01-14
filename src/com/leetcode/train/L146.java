package com.leetcode.train;

import java.util.HashMap;

public class L146 {
    class LRUCache {

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        //最大的容量
        int capacity;
        //目前已经有的
        int size;
        private DLinkedNode head;
        private DLinkedNode tail;

        HashMap<Integer, DLinkedNode> cacheMap = new HashMap<Integer, DLinkedNode>();

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode dLinkedNode = cacheMap.get(key);
            if (dLinkedNode == null) {
                return -1;
            } else {
                moveToHead(dLinkedNode);
                return dLinkedNode.value;
            }
        }

        public void put(int key, int value) {
            DLinkedNode node = cacheMap.get(key);
            if (node == null) {
                DLinkedNode dnode = new DLinkedNode(key, value);
                cacheMap.put(key, dnode);
                //添加到双向链表头部
                addToHead(dnode);
                //判断是否超出容量如果超出了删除尾节点最后一个
                size++;
                if (size > capacity) {
                    //删除尾节点最后一个
                    removeNode(tail.prev);
                    size--;
                }
            } else {
                //已经存在把修改节点的值
                node.value = value;
                moveToHead(node);
            }
        }

        public void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next = node;
        }

        public void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void moveToHead(DLinkedNode node) {
            addToHead(node);
            removeNode(node);
        }

    }
}
