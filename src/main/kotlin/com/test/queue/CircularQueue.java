package com.test.queue;

public class CircularQueue {

    private int start = -1, end = -1, size;

    private Integer[] intArray;


    public CircularQueue(int size) {
        intArray = new Integer[size];
        this.size = intArray.length;
    }

    public void enQueue(int item) {

        if(start == -1 && end == -1){
            start = end =  0;
            intArray[end] = item;
        } else if( ((end+1) %  size) == start) {
            System.out.println("Queue is full");
            throw new IllegalStateException("Queue is full");
        } else {
            end = (end + 1) % size;
            intArray[end] = item;
        }

    }

    public int deQueue(){
        int value;
        if(start == -1 && end == -1) {
            System.out.println("Queue is empty");
            throw new IllegalStateException("Queue is empty");
        } else if(start == end) {
            value = intArray[start];
            start = end = -1;
            return value;
        } else {
            value = intArray[start];
            start = (start + 1) % size;
            return value;
        }
    }

    public int size() {
        return intArray.length;
    }

    public boolean isEmpty() {
        if(start == -1 && end == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if((end+1)%size == start){
            return true;
        }
        return false;
    }

    public int Front() {
        if(!isEmpty()){
            return intArray[start];
        }
        return -1;
    }

    public int Rear() {
        if(!isEmpty()){
            return intArray[end];
        }
        return -1;
    }

    void display(){
        int indx = start;
        System.out.println("Display");
        System.out.println("");
        if(!isEmpty()){
           do {
                System.out.println(intArray[indx]);
                indx = (indx+1) % size;
            } while(indx != end);
        }
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        System.out.println("Size is: "+ cq.size());
        cq.enQueue(1);
        cq.enQueue(2);
        cq.enQueue(3);
        System.out.println("End Value is: "+ cq.Rear());
        System.out.println("Front Value is: "+ cq.Front());
        System.out.println("Value is: "+ cq.deQueue());
        System.out.println("Value is: "+ cq.deQueue());

        cq.enQueue(4);
        cq.enQueue(5);
        cq.enQueue(6);
        cq.enQueue(7);
        System.out.printf("Queue is: %s%n", cq.isFull() ? "full": "empty");
        cq.display();
        try {
        cq.enQueue(8);
        } catch (IllegalStateException ise) {

        }

        System.out.println("Value is: "+ cq.deQueue());
        System.out.println("Value is: "+ cq.deQueue());
        System.out.println("Value is: "+ cq.deQueue());
        System.out.println("Value is: "+ cq.deQueue());
        System.out.println("Value is: "+ cq.deQueue());

        System.out.printf("Queue is: %s%n", cq.isEmpty() ? "empty": "not empty");

        try {
            System.out.println("Value is: "+ cq.deQueue());
        } catch (IllegalStateException ise) {

        }

    }
}
