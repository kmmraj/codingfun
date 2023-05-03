package com.test.queue;

public class ArrayCircularQueue {

    int[] array;
    int startOfQueue = -1;
    int endOfQueue = -1;

    public ArrayCircularQueue(int size) {
        this.array = new int[size];
    }

    public boolean enQueue(int data) {

        if (isFull()) {
            System.out.println("Queue is full - enqueue failed");
            return false;
        }

        if (isEmpty()) {
            array[startOfQueue + 1] = data;
            startOfQueue++;
            endOfQueue++;
            return true;
        } else {
            if(endOfQueue+1 == array.length){
                endOfQueue = 0;
            }
            array[endOfQueue+1] = data;
            endOfQueue++;
            return true;
        }
    }

    private boolean isFull() {

        if (endOfQueue+1 == startOfQueue) {
            return true;
        } else if (startOfQueue==0 && endOfQueue+1== array.length) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmpty() {
//        if (startOfQueue == -1 || endOfQueue == -1) {
//            return true;
//        }
//
//        if (startOfQueue == endOfQueue) {
//            return false;
//        }
//        if (startOfQueue > endOfQueue) {
//            int diff = startOfQueue - endOfQueue;
//            return diff <= 1;
//        } else {
//            int diff = endOfQueue - startOfQueue;
//            return diff < 1;
//        }

        if(endOfQueue+1 == startOfQueue){
            return false;
        }

        if(endOfQueue == array.length-1 && startOfQueue ==0){
            return false;
        }

        return endOfQueue == -1;
    }

    private void printAll() {
        System.out.println("-----------------");
        int size = array.length;
        int startIndex = startOfQueue;
        for (int indx = 0; indx < size; indx++) {
            System.out.print(array[startIndex] + " -> ");
            startIndex++;
            if (startIndex >= size) {
                startIndex = 0;
            }
        }
        System.out.println();
        System.out.println("-----------------");
    }

    private int deQueue() {
        if(isEmpty()){
            System.out.println("Array is empty");
            return Integer.MIN_VALUE;
        }
        int value = array[startOfQueue];
        startOfQueue = (startOfQueue + 1) % array.length;
        return value;
    }

    public static void main(String[] args) {
        ArrayCircularQueue queue = new ArrayCircularQueue(4);
        queue.enQueue(0);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.printAll();
        System.out.println("dequeued value is "+queue.deQueue());
        System.out.println("dequeued value is "+queue.deQueue());
        System.out.println("dequeued value is "+queue.deQueue());
        System.out.println("dequeued value is "+queue.deQueue());
        System.out.println("dequeued value is "+queue.deQueue());
    }


}
