package com.dataStructure.linkedList;

public class LinedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNode(1);
        singleLinkedList.addNode(2);
        singleLinkedList.addNode(4);

       // insertNodeIndex(singleLinkedList.head,3,4);
        deleteNodeByIndex(singleLinkedList.head,1);
        singleLinkedList.printLinkedList();
    }

    public static void insertNodeIndex(Node head, int value, int index) {
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node node = new Node(value);
        node.setNext(current.next);
        current.setNext(node);
    }

    public static void deleteNodeByIndex(Node head, int index) {
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
             current = current.next;
        }
        current.next = current.next.next;
    }

}
