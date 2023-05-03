package com.test.queue;

public class ArrayQueue {

    int[] array;
    int startOfQueue = -1;
    int endOfQueue = -1;

    public ArrayQueue(int size) {
        array = new int[size];
    }

    public boolean enQueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full could not enqueue");
            return false;
        }
        if (isEmpty()) {
            startOfQueue++;
        }

        array[endOfQueue + 1] = data;
        endOfQueue++;
        return true;
    }

    private boolean isFull() {
        return endOfQueue >= array.length - 1;
    }

    private boolean isEmpty() {
        return endOfQueue == -1 || startOfQueue == -1;
    }

    private void printAll() {
        System.out.println("-------------------");
        for (int indx = startOfQueue; indx <= endOfQueue; indx++) {
            System.out.print(array[indx] + " -> ");
        }
        System.out.println();
        System.out.println("-------------------");
    }

    private int deQueue() {
        if (startOfQueue > endOfQueue || isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int value = array[startOfQueue];
        startOfQueue++;
        return value;
    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        System.out.println("is Queue empty ? " + queue.isEmpty());
        queue.enQueue(0);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        System.out.println("is Queue empty ? " + queue.isEmpty());
        System.out.println("is Queue full ? " + queue.isFull());
        queue.printAll();
        System.out.println("Dequeued value ? " + queue.deQueue());
        System.out.println("Dequeued value ? " + queue.deQueue());
        System.out.println("Dequeued value ? " + queue.deQueue());
        System.out.println("Dequeued value ? " + queue.deQueue());
        System.out.println("Dequeued value ? " + queue.deQueue());
        queue.printAll();
    }


}
