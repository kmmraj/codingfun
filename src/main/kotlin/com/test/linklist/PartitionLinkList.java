package com.test.linklist;

public class PartitionLinkList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    public PartitionLinkList(int data) {
        head = new Node(data);
        tail = head;
    }

    public Node add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        return node;
    }

    public void printAll() {
        Node tempNode = head;
        System.out.println("---------------");
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println();
        System.out.println("---------------");
    }


    public static void main(String[] args) {

        PartitionLinkList partitionLinkList = new PartitionLinkList(1);
        partitionLinkList.add(21);
        partitionLinkList.add(3);
        partitionLinkList.add(10);
        partitionLinkList.add(14);
        partitionLinkList.add(5);
        partitionLinkList.add(15);
        partitionLinkList.add(7);
        partitionLinkList.add(2);
        partitionLinkList.add(4);
        partitionLinkList.add(11);

        partitionLinkList.printAll();

//        partitionLinkList.partition(5);
//        partitionLinkList.printAll();

//        partitionLinkList.partition(10);
//        partitionLinkList.printAll();
//
//        partitionLinkList.partition(4);
//        partitionLinkList.printAll();
//        partitionLinkList.partition(11);
//        partitionLinkList.printAll();

//        partitionLinkList.partitionWithValueAtCenter(10);
//        partitionLinkList.printAll();

//        partitionLinkList.partitionWithValueAtCenter(11);
//        partitionLinkList.printAll();

        PartitionLinkList.partitionWithTwoPtrs(partitionLinkList,11);
        partitionLinkList.printAll();


    }

    private void partition(int value) {
        Node tempNode = head;
        Node newHead = null;
        Node newTail = null;
        Node firstTail = null;
        Node firstHead = null;
        // 1 -> 21 -> 3 -> 10 -> 14 -> 5 -> 15 -> 7 -> 2 -> 4 ->
        while (tempNode != null) {
            if (tempNode.data < value) {
                if (newHead == null) {
                    newHead = tempNode;
                    firstHead = newHead;
                } else {
                    newHead.next = tempNode;
                    newHead = newHead.next;
                }
            } else {
                if (newTail == null) {
                    newTail = tempNode;
                    firstTail = newTail;
                } else {
                    newTail.next = tempNode;
                    newTail = newTail.next;
                }
            }

            tempNode = tempNode.next;
        }

        assert newHead != null;
        newHead.next = firstTail;
        assert newTail != null;
        newTail.next = null;

        head = firstHead;
        tail = newTail;
    }

    private void partitionWithValueAtCenter(int value) {
        Node tempNode = head;
        Node newHead = null;
        Node newTail = null;
        Node firstTail = null;
        Node firstHead = null;
        Node centerNode = null;
        // 1 -> 21 -> 3 -> 10 -> 14 -> 5 -> 15 -> 7 -> 2 -> 4 ->
        while (tempNode != null) {
            if (tempNode.data < value) {
                if (newHead == null) {
                    newHead = tempNode;
                    firstHead = newHead;
                } else {
                    newHead.next = tempNode;
                    newHead = newHead.next;
                }
            } else if (tempNode.data == value) {
                centerNode = new Node(value);
            } else {
                if (newTail == null) {
                    newTail = tempNode;
                    firstTail = newTail;
                } else {
                    newTail.next = tempNode;
                    newTail = newTail.next;
                }
            }

            tempNode = tempNode.next;
        }

        assert newHead != null;
        newHead.next = centerNode;
        assert centerNode != null;
        centerNode.next = firstTail;
        assert newTail != null;
        newTail.next = null;

        head = firstHead;
        tail = newTail;
    }


    static void partitionWithTwoPtrs(PartitionLinkList ll, int value) {
        Node tempNode = ll.head;
        ll.tail = ll.head;

        while (tempNode != null){
            Node nextNode = tempNode.next;
            if(tempNode.data < value){
                tempNode.next = ll.head;
                ll.head = tempNode;
            } else {
                ll.tail.next = tempNode;
                ll.tail = tempNode;
            }
            tempNode = nextNode;
        }
        ll.tail.next = null;

    }

    PartitionLinkList partition(PartitionLinkList ll, int x) {
        Node currentNode = ll.head;
        ll.tail = ll.head;
        while (currentNode != null) {
            Node next = currentNode.next;

            if (currentNode.data < x) {
                // Move the node to the beginning of the head
                currentNode.next = ll.head;
                ll.head = currentNode;
            } else {
                // Move the node to the end of the tail
                ll.tail.next = currentNode;
                ll.tail = currentNode;
            }
            currentNode = next;
        }
        ll.tail.next = null;
        return ll;
    }


}
