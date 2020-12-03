package com.dataStructure.linkedList;

public class SingleLinkedList {

    public Node head = new Node(-1);

    public void  addNode (int value){
        Node newNode = new Node(value);
        Node temp = head;
        if(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void printLinkedList() {
        if (head.next == null) {
            System.out.println("没有节点");
            return;
        }
        while (head.next != null) {
            System.out.println(head.next.getData());
            head.next = head.next.next;
        }
    }

}
