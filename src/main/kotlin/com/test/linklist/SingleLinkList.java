package com.test.linklist;

public class SingleLinkList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }


    Node head;
    Node tail;

    public SingleLinkList() {
        head = null;
        tail = null;
    }

    public SingleLinkList(int data) {
        head = new Node(data);
        tail = head;
    }

    public Node add(int data) {
        Node node = new Node(data);
        tail.next = node;
        tail = node;
        return node;
    }

    public Node insert(int data, Node prev, Node next) {
        Node node = new Node(data);
        prev.next = node;
        node.next = next;
        return node;
    }

    public Node insertAfterValue(int value, int data) {
        Node tempNode = head;
        Node newNode = null;
        while (tempNode != null) {
            if (tempNode.data == value) {
                // insert node
                newNode = new Node(data);
                newNode.next = tempNode.next;
                tempNode.next = newNode;
                return newNode;
            } else {
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Node addAtHead(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        return node;
    }

    public Node addAtTail(int data) {
        Node node = new Node(data);
        node.next = null;
        tail.next = node;
        tail = node;
        return node;
    }

    public boolean deleteValue(int value) {
        Node tempNode = head;
        Node prevNode = null;
        while (tempNode != null) {
            if (tempNode.data == value) {
                if (prevNode == null) {
                    // head
                    head = head.next;
                } else {
                    // rest of elements
                    prevNode.next = tempNode.next;
                }
                return true;
            } else {
                prevNode = tempNode;
                tempNode = tempNode.next;
            }
        }
        return false;
    }

    public void printAll() {
        System.out.println("-------");
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println();
        System.out.println("-------");
    }

    public boolean deleteLinkList() {
        if (head == null || tail == null) {
            return false;
        }
        head = null;
        tail = null;
        return true;
    }

    public boolean findValue(int value) {
        Node tempNode = head;
        while (tempNode != null) {
            if (tempNode.data == value) {
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    public Node pop() {
        Node currentNode = head;
        Node prevNode = head;
        while (currentNode != tail) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        tail = prevNode;
        prevNode.next = null;
        return currentNode;
    }

    public Node get(int index) {
        if(index < 0 ){
            return null;
        }
        Node currentNode = head;
        int counter = 0;
        while (currentNode != tail && counter < index) {
            currentNode = currentNode.next;
            counter++;
        }
        if(counter < index){
            return null;
        }
        return currentNode;
    }

    public boolean set(int index, int value) {
        Node currentNode = get(index);
        if(currentNode == null){
            return false;
        }
        currentNode.data = value;
        return true;
    }


    // 1 -> 2 -> 3 -> 4 -> 5 and you rotate by 2, the list should be modified to 3 -> 4 -> 5 -> 1 -> 2.
    public boolean rotate(int number) {
        Node currentNode = head;
        Node prevNode = head;
        int counter =0;
        while (currentNode != null && counter < number){
            prevNode = currentNode;
            currentNode = currentNode.next;
            counter++;
        }
        if(number > counter){
            return false;
        }
        Node oldHead = head;
        head = currentNode;
        tail.next = oldHead;
        if(prevNode != null){
            prevNode.next = null;
        }
        return true;
    }


    public static void main(String[] args) {
        SingleLinkList singleLinkList = new SingleLinkList(1);
        singleLinkList.add(2);
        singleLinkList.add(3);
        singleLinkList.add(4);
        Node node5 = singleLinkList.add(5);
        Node node7 = singleLinkList.add(7);
        singleLinkList.insert(6, node5, node7);
        singleLinkList.addAtHead(0);
        singleLinkList.addAtTail(8);


        for (Node node = singleLinkList.head; node != null; node = node.next) {
            System.out.println(node.data);
        }

        System.out.println("-------");
        singleLinkList.insertAfterValue(5, 5);

        Node node = singleLinkList.head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }


        singleLinkList.deleteValue(5);
        singleLinkList.printAll();

        System.out.println("11 is deleted ? " + singleLinkList.deleteValue(11));
        System.out.println("11 is found ? " + singleLinkList.findValue(11));
        System.out.println("7 is found ? " + singleLinkList.findValue(7));
        // System.out.println("delete LL ? " + singleLinkList.deleteLinkList());
        singleLinkList.printAll();
        System.out.println("8 is popped ? " + singleLinkList.pop().data);
        System.out.println("7 is popped ? " + singleLinkList.pop().data);
        singleLinkList.printAll();
        System.out.println("index at 5 is  ? " + singleLinkList.get(5).data);
        System.out.println("index at 2 is  ? " + singleLinkList.get(2).data);
        singleLinkList.printAll();
//        System.out.println("value set at index 2 is  ? " + singleLinkList.set(2,-3));
//        System.out.println("value set at index 2 is  ? " + singleLinkList.set(9,-3));
//        singleLinkList.printAll();

        System.out.println("Able to rotate for index 3  ? " +singleLinkList.rotate(3));
        singleLinkList.printAll();
        System.out.println("Able to rotate for index 8  ? " +singleLinkList.rotate(8));
        singleLinkList.printAll();
        System.out.println("Able to rotate for index 7  ? " +singleLinkList.rotate(7));
        singleLinkList.printAll();

    }
}
