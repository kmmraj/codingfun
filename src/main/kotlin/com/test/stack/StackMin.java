package com.test.stack;

public class StackMin {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node top;
    Node min;

    private StackMin() {
    }

    public StackMin(int data) {
        Node newNode = new Node(data);
        Node currentNode = new Node(data);
        top = newNode;
        min = currentNode;
    }

    public static void main(String[] args) {
        StackMin minStack = new StackMin(7);
        minStack.push(3);
        minStack.push(8);
        minStack.push(1);
        minStack.push(11);
        minStack.printAll();
        minStack.printMinStackAll();
        System.out.println("Popped value is " + minStack.pop());
    }

    private int pop() {
        Node currentNode = top;
        top = top.next;
        min = min.next;
        return currentNode.data;
    }

    private void printAll() {
        System.out.println("---------------------");
        Node currentNode = top;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println();
        System.out.println("---------------------");
    }

    private void printMinStackAll() {
        System.out.println("---------------------");
        Node currentNode = min;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println();
        System.out.println("---------------------");
    }

    // 7 -> 3 -> 8 -> 1 -> 11
//    private void push(int data) {
//        Node newNode = new Node(data);
//        newNode.next = top;
//        top = newNode;
//
//        Node currentNode = new Node(data);
//        if (min.data > data) { // new data is less
//            currentNode.next = min;
//            min = currentNode;
//        } else { // new data is more
//            //Node tempNode = min;
//           // min.next = currentNode;
//            fixMin(min, currentNode);
//            //currentNode.next = tempNode;
//        }
//       // fixMin(min,currentNode);
//    }

    private void push(int value){
        if (min == null) {
            min = new Node(value, min);
        } else if (min.data < value) {
            min = new Node(min.data, min);
        } else {
            min = new Node(value, min);
        }
        top = new Node(value, top);
    }

    // 7 -> 3 -> 8 -> 1 -> 11
    private void fixMin(Node min, Node currentNode) {
        Node tempNode = min;
        Node prevNode = min;
        while (tempNode != null) {
            if(currentNode.data < tempNode.data){
                currentNode.next = tempNode;
                prevNode.next = currentNode;
            } else {
                Node nextNode = tempNode.next;
                tempNode.next = currentNode;
                currentNode.next = nextNode;
            }
            prevNode = tempNode;
            tempNode = tempNode.next;
        }
    }


}
