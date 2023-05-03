package com.test.queue;

public class LinkedListQueue {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    private LinkedListQueue() {
    }

    public LinkedListQueue(int data) {
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue(0);
        System.out.println("Added 1 ? " + queue.enQueue(1));
        System.out.println("Added 2 ? " + queue.enQueue(2));
        System.out.println("Added 3 ? " + queue.enQueue(3));
        System.out.println("Added 4 ? " + queue.enQueue(4));
        queue.printAll();
        System.out.println("Dequeued 0 ? " + queue.deQueue());
        System.out.println("Peek 1 ? " + queue.peek());

        System.out.println("Dequeued 1 ? " + queue.deQueue());
        System.out.println("Peek 2 ? " + queue.peek());

        System.out.println("Dequeued 2 ? " + queue.deQueue());
        System.out.println("Dequeued 3 ? " + queue.deQueue());
        System.out.println("Dequeued 4 ? " + queue.deQueue());
        System.out.println("Dequeued 4 ? " + queue.deQueue());
        queue.printAll();

    }

    private int peek() {
        if(head == null || tail == null){
            return Integer.MIN_VALUE;
        }
        return head.data;
    }

    private int deQueue() {
        if(head == null || tail == null){
            return Integer.MIN_VALUE;
        }
        Node currentNode = head;
        head = head.next;
        return currentNode.data;
    }

    private void printAll() {
        Node tempNode = head;
        System.out.println("----------------------");
        while (tempNode != null){
           System.out.print(tempNode.data + " -> ");
           tempNode = tempNode.next;
        }
        System.out.println();
        System.out.println("----------------------");
    }

    private boolean enQueue(final int data) {

        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
        return true;
    }
}
