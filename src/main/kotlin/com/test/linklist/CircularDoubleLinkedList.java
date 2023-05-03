package com.test.linklist;

public class CircularDoubleLinkedList {
    Node head;
    Node tail;


    private class Node {
        int data;

        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public CircularDoubleLinkedList(int data) {
        Node newNode = new Node(data);
        newNode.next = newNode;
        newNode.prev = newNode;
        head = newNode;
        tail = newNode;
    }

    private boolean addAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = tail;
        tail.next = newNode;
        head.prev = newNode;
        head = newNode;
        return true;
    }

    private boolean addAtTail(int data) {
        Node newNode = new Node(data);
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
        tail.next = newNode;
        tail = newNode;
        return true;
    }

    private boolean deleteValue(final int value) {
        Node tempNode = head;

        // Tail
        if (tail.data == value) {
            tail.prev.next = head;
            assert head != null;
            head.prev = tail.prev;
            tail = tail.prev;
            return true;
        }

        // Head
        if (head.data == value) {
            tail.next = head.next;
            head.next.prev = tail;
            head = head.next;
            return true;
        }
        // Middle
        while (tempNode != null && tempNode.next != head) {
            if (tempNode.data == value) {

                tempNode.prev.next = tempNode.next;
                tempNode.next.prev = tempNode.prev;

                return true;
            }
            tempNode = tempNode.next;
        }


        return false;
    }

    private void printAll() {

        if (head == null || tail == null) {
            System.out.println("-----Empty LL------");
            return;
        }
        Node tempNode = head;
        System.out.println("---------------");
        System.out.print(tempNode.data + ", ");
        while (tempNode != null && tempNode.next != tempNode && tempNode.next != head) {
            tempNode = tempNode.next;
            System.out.print(tempNode.data + ", ");
        }
        System.out.println();
        System.out.println("---------------");


        tempNode = tail;
        System.out.println("------R--------");
        System.out.print(tempNode.data + ", ");
        while (tempNode != null && tempNode.prev != tempNode && tempNode.prev != tail) {
            tempNode = tempNode.prev;
            System.out.print(tempNode.data + ", ");
        }
        System.out.println();
        System.out.println("------R--------");
    }


    public static void main(String[] args) {
        CircularDoubleLinkedList circularDoubleLinkedList = new CircularDoubleLinkedList(1);
        circularDoubleLinkedList.printAll();
        circularDoubleLinkedList.addAtTail(2);
        circularDoubleLinkedList.printAll();
        circularDoubleLinkedList.addAtHead(0);
        circularDoubleLinkedList.printAll();
        System.out.println("Added value 4 after 2 ? " + circularDoubleLinkedList.addAfterValue(2, 4));
        circularDoubleLinkedList.printAll();
        System.out.println("Added value 3 after 2 ? " + circularDoubleLinkedList.addAfterValue(2, 3));
        System.out.println("Added value 3 after 2 ? " + circularDoubleLinkedList.addAfterValue(4, 5));
        circularDoubleLinkedList.printAll();

        System.out.println("deleted value 3 ? " + circularDoubleLinkedList.deleteValue(3));
        circularDoubleLinkedList.printAll();

        System.out.println("deleted value 5 ? " + circularDoubleLinkedList.deleteValue(5));
        circularDoubleLinkedList.printAll();

        System.out.println("deleted value 0 ? " + circularDoubleLinkedList.deleteValue(0));
        circularDoubleLinkedList.printAll();

        System.out.println("deletedAll ? " + circularDoubleLinkedList.deleteAll());
        circularDoubleLinkedList.printAll();

    }

    private boolean deleteAll() {
        Node tempNode = head;
        while (tempNode != null && tempNode.next != head) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        assert head != null;
        head.prev = null;
        tail.next = null;
        head = null;
        tail = null;
        return true;
    }


    private boolean addAfterValue(final int value, final int data) {
        Node tempNode = head;

        while (tempNode != null && tempNode.next != head) {
            if (tempNode.data == value) {
                Node newNode = new Node(data);
                newNode.prev = tempNode;
                newNode.next = tempNode.next;
                tempNode.next.prev = newNode;
                tempNode.next = newNode;
                return true;
            }
            tempNode = tempNode.next;
        }

        if (tail.data == value) {
            Node newNode = new Node(data);
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            if (head != null) {
                head.prev = newNode;
            }
            tail = newNode;
            return true;
        }

        return false;
    }


}
