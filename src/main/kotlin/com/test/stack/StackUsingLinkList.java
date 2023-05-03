package com.test.stack;

public class StackUsingLinkList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    public StackUsingLinkList(int data) {
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }


    private void push(final int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    private void printAll() {
        System.out.println("-----------------------");
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println();
        System.out.println("-----------------------");
    }


    public static void main(String[] args) {
        StackUsingLinkList stack = new StackUsingLinkList(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printAll();
        System.out.println("Popped the value " + stack.pop().data);
        System.out.println("Popped the value " + stack.pop().data);
        System.out.println("Popped the value " + stack.pop().data);
        System.out.println("Popped the value " + stack.pop().data);
        System.out.println("Popped the value " + stack.pop());
        System.out.println("is Stack Empty " + stack.isEmpty());


        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("After inserting -- is Stack Empty " + stack.isEmpty());
        System.out.println("Peeked the value " + stack.peek().data);
        System.out.println("Popped the value " + stack.pop().data);
        System.out.println("Peeked the value " + stack.peek().data);
        System.out.println("Popped the value " + stack.pop().data);


    }

    private boolean isEmpty() {
        return head == null || tail == null;
    }

    private Node pop() {
        if (head == null) {
            return null;
        }
        Node currentNode = head;
        head = head.next;
        return currentNode;
    }

    private Node peek() {
        if (head == null) {
            return null;
        }
        return head;
    }
}
