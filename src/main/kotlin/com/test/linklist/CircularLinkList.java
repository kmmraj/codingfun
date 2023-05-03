package com.test.linklist;

public class CircularLinkList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
        }
    }


    Node head;
    Node tail;

    public CircularLinkList(int data) {
        Node node = new Node(data);
        this.head = node;
        this.tail = node;
        node.next = node;
    }
//    public CircularLinkList(Node head,Node tail){
//        this.tail = tail;
//        this.head = head;
//    }

    public Node add(int data) {
        if (this.tail == null || this.head == null) {
            System.out.println("CLL is not created yet");
            return null;
        }
        Node node = new Node(data);
        tail.next = node;
        node.next = head;
        tail = node;
        return node;
    }


    private boolean addAtValue(final int value, final int data) {
        Node tempNode = head;
        while ((tempNode != null && tempNode.next != head)) { //|| (tail.data == value)){
            if (tempNode.data == value) {
                Node newNode = new Node(data);
                newNode.next = tempNode.next;
                tempNode.next = newNode;
                return true;
            }
            tempNode = tempNode.next;
        }

        if (tail.data == value) {
            Node newNode = new Node(data);
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
            return true;
        }
        return false;
    }

    public void printAll() {
        if (head == null || tail == null) {
            return;
        }
        System.out.println("---------------------------");

        Node tempNode = head;
        System.out.println(tempNode.data);
        while (tempNode != null && tempNode.next != head) {
            tempNode = tempNode.next;
            System.out.println(tempNode.data);
        }
        System.out.println("---------------------------");
    }

    private boolean find(final int value) {
        Node tempNode = head;
        while ((tempNode != null && tempNode.next != head)) {
            if (tempNode.data == value) {
                return true;
            }
            tempNode = tempNode.next;
        }

        if (tail.data == value) {
            return true;
        }
        return false;
    }

    private boolean deleteValue(int value) {
        Node tempNode = head;
        Node prevNode = head;
        while ((tempNode != null && tempNode.next != head)) {
            if (tempNode.data == value) {
                if (prevNode == head && tempNode == head && tempNode.next != null) {
                    head = tempNode.next;
                    tail.next = tempNode.next;
                }
                prevNode.next = tempNode.next;
                return true;
            }
            prevNode = tempNode;
            tempNode = tempNode.next;
        }

        if (head.data == value && tail.data == value) {
            head = null;
            tail = null;
            return true;
        }

        if (tail.data == value && prevNode != null) {
            prevNode.next = head;
            tail = prevNode;
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        CircularLinkList circularLinkList = new CircularLinkList(1);
        circularLinkList.printAll();
        circularLinkList.add(2);
        circularLinkList.add(4);
        circularLinkList.printAll();
        circularLinkList.addAtValue(2, 3);
        circularLinkList.printAll();
        circularLinkList.add(6);
        circularLinkList.add(7);
        circularLinkList.printAll();
        circularLinkList.addAtValue(4, 5);
        circularLinkList.printAll();
        circularLinkList.addAtValue(7, 8);
        circularLinkList.printAll();
        System.out.println("Is value 7 found? " + circularLinkList.find(7));
        System.out.println("Is value 9 found? " + circularLinkList.find(9));
        System.out.println("Is value 8 found? " + circularLinkList.find(8));

        System.out.println("Is value 7 deleted? " + circularLinkList.deleteValue(7));
        circularLinkList.printAll();
        System.out.println("Is value 8 deleted? " + circularLinkList.deleteValue(8));
        circularLinkList.printAll();
        System.out.println("Is value 6 deleted? " + circularLinkList.deleteValue(6));
        circularLinkList.printAll();

        System.out.println("Is value 1 deleted? " + circularLinkList.deleteValue(1));
        circularLinkList.printAll();

        System.out.println("Is value 2 deleted? " + circularLinkList.deleteValue(2));
        circularLinkList.printAll();

        System.out.println("Is value 3 deleted? " + circularLinkList.deleteValue(3));
        circularLinkList.printAll();

        System.out.println("Is value 4 deleted? " + circularLinkList.deleteValue(4));
        circularLinkList.printAll();

        System.out.println("Is value 6 deleted? " + circularLinkList.deleteValue(6));
        circularLinkList.printAll();

        System.out.println("Is value 5 deleted? " + circularLinkList.deleteValue(5));
        circularLinkList.printAll();


        circularLinkList = new CircularLinkList(1);
        circularLinkList.add(2);
        circularLinkList.add(4);
        circularLinkList.addAtValue(2, 3);
        circularLinkList.add(6);
        circularLinkList.add(7);
        circularLinkList.printAll();

        System.out.println("Is CLL deleted? " + circularLinkList.deleteAll());
        circularLinkList.printAll();

    }

    private boolean deleteAll() {
        if (head == null || tail == null) {
            return false;
        }

        head.next = null;
        head = null;
        tail = null;
        return true;
    }


}
