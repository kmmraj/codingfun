package com.test.linklist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupsInUnsortedLinkedList {

    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    public RemoveDupsInUnsortedLinkedList(int data) {
        Node node = new Node(data);
        node.next = node;
        node.prev = node;
        head = node;
        tail = node;
    }

    private void printAll() {

        if (head == null || tail == null) {
            return;
        }
        Node tempNode = head;
        System.out.println("---------------");
        System.out.print(tempNode.data + " -> ");
        while (tempNode.next != head) {
            tempNode = tempNode.next;
            System.out.print(tempNode.data + " -> ");
        }
        System.out.println();
        System.out.println("---------------");
        printReverse();
    }

    private void printReverse() {
        if (head == null || tail == null) {
            return;
        }
        Node tempNode = tail;
        System.out.println("-------R--------");
        System.out.print(tempNode.data + " -> ");
        while (tempNode.prev != tail) {
            tempNode = tempNode.prev;
            System.out.print(tempNode.data + " -> ");
        }
        System.out.println();
        System.out.println("-------R--------");
    }


    public static void main(String[] args) {

        RemoveDupsInUnsortedLinkedList unsortedLinkedList = new RemoveDupsInUnsortedLinkedList(1);
        unsortedLinkedList.printAll();
        unsortedLinkedList.addAtEnd(2);
        unsortedLinkedList.addAtEnd(5);
        unsortedLinkedList.addAtEnd(3);
        unsortedLinkedList.addAtEnd(3);
        unsortedLinkedList.addAtEnd(4);
        unsortedLinkedList.printAll();

        System.out.println("Remove Duplicate");
        unsortedLinkedList.removeDups(unsortedLinkedList);
        unsortedLinkedList.printAll();


    }

    private void removeDups(RemoveDupsInUnsortedLinkedList unsortedLinkedList) {

        if (unsortedLinkedList.head == null || unsortedLinkedList.tail == null) {
            return;
        }
        Node tempNode = unsortedLinkedList.head;

        Set<Integer> uniqueSet = new HashSet<>();

        while (tempNode.next != head) {
            if (!uniqueSet.add(tempNode.data)) {
                // Dups
                tempNode.prev.next = tempNode.next;
                tempNode.next.prev = tempNode.prev;
            }
            tempNode = tempNode.next;
        }
    }

    private boolean addAtEnd(int data) {

        if (head == null || tail == null) {
            return false;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head.prev = newNode;
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        return true;
    }
}
