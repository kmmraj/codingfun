package com.test.queue;

public class AnimalQueue {

    enum AnimalType {CAT, DOG}

    ;

    class Node {
        String name;
        AnimalType type;

        Node next;

        public Node(String name, AnimalType type) {
            this.name = name;
            this.type = type;
        }
    }

    Node head;
    Node tail;

    public AnimalQueue() {
    }

    public AnimalQueue(String name, AnimalType type) {
        Node newNode = new Node(name, type);
        head = newNode;
        tail = newNode;
    }

    private void enQueue(String name, AnimalType animalType) {
        Node newNode  = new Node(name, animalType);
        tail.next = newNode;
        tail = newNode;
    }

    private void printAll() {
        Node currentNode = head;
        System.out.println("-------------------");
        while (currentNode != null){
            System.out.print("( "+ currentNode.name + " : " + currentNode.type + " ) -> ");
            currentNode = currentNode.next;
        }
        System.out.println();
        System.out.println("-------------------");
    }


    public static void main(String[] args) {
        AnimalQueue queue = new AnimalQueue("Meena", AnimalType.CAT);
        queue.enQueue("Tom", AnimalType.CAT);
        queue.enQueue("Spike", AnimalType.DOG);
        queue.enQueue("Felix", AnimalType.CAT);
        queue.enQueue("Pichhu", AnimalType.DOG);
        queue.printAll();
        System.out.println("Dequeued animal is " + queue.deQueue());
        System.out.println("Dequeued cat is " + queue.deQueueAny(AnimalType.CAT));
        System.out.println("Dequeued cat is " + queue.deQueueAny(AnimalType.CAT));
        System.out.println("Dequeued dog is " + queue.deQueueAny(AnimalType.DOG));
        System.out.println("Dequeued dog is " + queue.deQueueAny(AnimalType.DOG));
        System.out.println("Dequeued dog is " + queue.deQueueAny(AnimalType.DOG));
        System.out.println("Dequeued dog is " + queue.deQueueAny(AnimalType.CAT));
        queue = new AnimalQueue("Meena", AnimalType.CAT);
        queue.enQueue("Tom", AnimalType.CAT);
        queue.enQueue("Spike", AnimalType.DOG);
        queue.enQueue("Felix", AnimalType.CAT);
        queue.printAll();
        System.out.println("Dequeued cat is " + queue.deQueueAny(AnimalType.CAT));
        System.out.println("Dequeued cat is " + queue.deQueueAny(AnimalType.CAT));
        System.out.println("Dequeued dog is " + queue.deQueueAny(AnimalType.DOG));
    }

    private String deQueueAny(AnimalType animalType) {
        Node tempNode = head;
        Node prevNode = head;
        while (tempNode!=null && tempNode.type!= animalType){
            prevNode = tempNode;
            tempNode = tempNode.next;
        }

        if(tempNode!=null){
            if(prevNode != tempNode){
                prevNode.next = tempNode.next;
            } else {
                head = head.next;
            }
            return "( "+ tempNode.name + " : " + tempNode.type + " )";
        }

        return "No " + animalType.toString() +" found";

    }

    private String deQueue() {
        Node tempNode = head;
        head = head.next;
        return "( "+ tempNode.name + " : " + tempNode.type + " )";
    }


}
