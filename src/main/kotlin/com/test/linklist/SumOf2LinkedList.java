package com.test.linklist;

public class SumOf2LinkedList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    public SumOf2LinkedList(int data) {
        Node node = new Node(data);
        node.next = null;
        head = node;
        tail = node;
    }

    public void add(int data) {
        Node node = new Node(data);
        tail.next = node;
        tail = node;
    }

    public void printAll() {
        if (head == null || tail == null) {
            return;
        }
        Node tempNode = head;
        System.out.println("---------------");
        while (tempNode != null) {
            System.out.print(tempNode.data + " ->");
            tempNode = tempNode.next;
        }
        System.out.println();
        System.out.println("---------------");
    }


    public static void main(String[] args) {

        SumOf2LinkedList sumOf2LinkedList1 = new SumOf2LinkedList(7);
        sumOf2LinkedList1.add(9);
        sumOf2LinkedList1.add(4);
        sumOf2LinkedList1.printAll();

        SumOf2LinkedList sumOf2LinkedList2 = new SumOf2LinkedList(5);
        sumOf2LinkedList2.add(2);
        sumOf2LinkedList2.add(6);
        sumOf2LinkedList2.printAll();

       // SumOf2LinkedList.sum(sumOf2LinkedList1, sumOf2LinkedList2).printAll();


        sumOf2LinkedList1 = new SumOf2LinkedList(7);
        sumOf2LinkedList1.add(1);
//        sumOf2LinkedList1.add(6);
        sumOf2LinkedList1.printAll();

        sumOf2LinkedList2 = new SumOf2LinkedList(5);
        sumOf2LinkedList2.add(9);
        sumOf2LinkedList2.add(2);
//        sumOf2LinkedList2.add(2);
        sumOf2LinkedList2.printAll();
        SumOf2LinkedList.sum(sumOf2LinkedList1, sumOf2LinkedList2).printAll();


    }

    private static SumOf2LinkedList sum(SumOf2LinkedList linkedList1, SumOf2LinkedList linkedList2) {

        Node currentNode1 = linkedList1.head;
        Node currentNode2 = linkedList2.head;
        int carry = 0;
        SumOf2LinkedList resultLinkedList = null;
        while (currentNode1 != null || currentNode2 != null || carry > 0) {

            int value1 = currentNode1 == null ? 0 : currentNode1.data;
            int value2 = currentNode2 == null ? 0 : currentNode2.data;
            int sum = value1 + value2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            if (resultLinkedList == null) {
                resultLinkedList = new SumOf2LinkedList(sum);
            } else {
                resultLinkedList.add(sum);
            }

            currentNode1 = currentNode1 == null ? null : currentNode1.next;
            currentNode2 = currentNode2 == null ? null : currentNode2.next;
        }

        return resultLinkedList;
    }

}
