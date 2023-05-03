package com.test.linklist;

public class DoubleLinkedList {
    Node head;
    Node tail;

    public DoubleLinkedList(int data) {
        Node node = new Node(data);
        node.next = null;
        node.prev = null;
        head = node;
        tail = node;
    }


    class Node {
        int data;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private void printAll() {

        if (head == null || tail == null) {
            return;
        }
        Node tempNode = head;
        System.out.println("---------------");
        while (tempNode != null) {
            System.out.print(tempNode.data + " ,");
            tempNode = tempNode.next;
        }
        System.out.println();
        System.out.println("---------------");
    }

    private void printReverse() {
        if (head == null || tail == null) {
            return;
        }
        Node tempNode = tail;
        System.out.println("---------------");
        while (tempNode != null) {
            System.out.print(tempNode.data + " ,");
            tempNode = tempNode.prev;
        }
        System.out.println();
        System.out.println("---------------");
    }


    private void addAtTail(final int data) {
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = null;
        tail = newNode;
    }

    private void addAtHead(final int data) {

        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;
        head.prev = newNode;
        head = newNode;
    }

    private boolean addAfterValue(final int value, final int data) {
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.data == value) {
                Node newNode = new Node(data);
                newNode.next = tempNode.next;
                newNode.prev = tempNode;
                if (tempNode.next != null) {
                    tempNode.next.prev = newNode;
                } else {
                    tail = newNode;
                }
                tempNode.next = newNode;

                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    private boolean find(int value) {
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.data == value) {
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    private boolean deleteValue(final int value) {
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.data == value) {
                if (tempNode.prev != null) {
                    tempNode.prev.next = tempNode.next;
                } else { // We are at head
                    head = tempNode.next;
                }
                if (tempNode.next != null) {
                    tempNode.next.prev = tempNode.prev;
                } else { // At Tail
                    tail = tempNode.prev;
                }

                tempNode.next = null;
                tempNode.prev = null;
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    private void deleteAll() {
        Node tempNode = head;
        while (tempNode != null) {
            tempNode.prev = null;
        }
        head = null;
        tail = null;
    }


    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList(1);
        dll.printAll();
        dll.addAtTail(2);
        dll.printAll();
        dll.addAfterValue(2, 3);
        dll.addAfterValue(3, 5);
        dll.addAfterValue(3, 4);
        dll.printAll();
        dll.printReverse();
        dll.addAtHead(0);
        dll.addAtHead(-1);
        dll.printAll();
        dll.printReverse();
        System.out.println("Is value 3 found ? " + dll.find(3));
        System.out.println("Is value -2 found ? " + dll.find(-2));
        dll.addAtHead(-2);
        System.out.println("Is value -2 found ? " + dll.find(-2));
        System.out.println("Is value 3 deleted ? " + dll.deleteValue(3));
        dll.printAll();
        dll.printReverse();
        System.out.println("Is value -2 deleted ? " + dll.deleteValue(-2));
        dll.printAll();
        dll.printReverse();
        System.out.println("Is value 5 deleted ? " + dll.deleteValue(5));
        dll.printAll();
        dll.printReverse();

        System.out.println("Is value 7 deleted ? " + dll.deleteValue(7));
        dll.printAll();
        dll.printReverse();

        System.out.println("Is value 3 added ? " + dll.addAfterValue(2, 3));
        dll.printAll();
        dll.printReverse();

        System.out.println("Is value 5 added ? " + dll.addAfterValue(4, 5));
        dll.printAll();
        dll.printReverse();

        dll.deleteAll();
        dll.printAll();
        dll.printReverse();

    }


}
