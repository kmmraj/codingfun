package com.test.linklist;

import java.util.*;

public class QueueWithMax<T extends Comparable<T>> {
    private Queue<T> entries = new LinkedList<>();
    private Deque<T> candidatesForMax = new LinkedList<>();

    public void enqueue(T x) {
        entries.add(x); // <-- Add to tail of queue.
        while (!candidatesForMax.isEmpty() && candidatesForMax.getLast().compareTo(x) < 0) {
            // Eliminate dominated elements in candidatesForMax.
//            if (candidatesForMax.getLast().compareTo(x) >= 0) {
//                break;
//            }
            candidatesForMax.removeLast();
        }
        candidatesForMax.addLast(x);
    }

    public T dequeue() {
        if (!entries.isEmpty()) {
            T result = entries.remove();
            if (result.equals(candidatesForMax.getFirst())) {
                candidatesForMax.removeFirst();
            }
            return result;
        }
        throw new NoSuchElementException("Called dequeueQ on empty queue.");
    }

    public T max() {
        if (!candidatesForMax.isEmpty()) {
            return candidatesForMax.getFirst();
        }
        throw new NoSuchElementException("empty queue");
    }

    public static void main(String[] args) {
//        QueueWithMax queueWithMax = new QueueWithMax();
//        queueWithMax.enqueue(1);
//        queueWithMax.enqueue(2);
//        queueWithMax.enqueue(3);
//        queueWithMax.enqueue(4);
//        queueWithMax.enqueue(5);
//        queueWithMax.enqueue(6);
//
//        System.out.println("queueWithMax.max() should be 6 and the result is "+queueWithMax.max());
//        queueWithMax.dequeue();
//        System.out.println("queueWithMax.max() should be 6 and the result is "+queueWithMax.max());
//        queueWithMax.dequeue();
//        System.out.println("queueWithMax.max() should be 6 and the result is "+queueWithMax.max());
//        queueWithMax.enqueue(7);
//        System.out.println("queueWithMax.max() should be 7 and the result is "+queueWithMax.max());
//
//        QueueWithMax queueWithMax2 = new QueueWithMax();
//        queueWithMax2.enqueue(1);
//        queueWithMax2.enqueue(9);
//        queueWithMax2.enqueue(3);
//        queueWithMax2.enqueue(7);
//        queueWithMax2.enqueue(5);
//
//        System.out.println("queueWithMax2.max() should be 9 and the result is "+queueWithMax2.max());
//        System.out.println("queueWithMax2.dequeue() should be 1 and the result is "+queueWithMax2.dequeue());
//        System.out.println("queueWithMax2.max() should be 9 and the result is "+queueWithMax2.max());
//        System.out.println("queueWithMax2.dequeue() should be 9 and the result is "+queueWithMax2.dequeue());
//        System.out.println("queueWithMax2.max() should be 7 and the result is "+queueWithMax2.max());
//        System.out.println("queueWithMax2.dequeue() should be 3 and the result is "+queueWithMax2.dequeue());
//        System.out.println("queueWithMax2.max() should be 7 and the result is "+queueWithMax2.max());
//        System.out.println("queueWithMax2.dequeue() should be 7 and the result is "+queueWithMax2.dequeue());
//        System.out.println("queueWithMax2.max() should be 5 and the result is "+queueWithMax2.max());
//        System.out.println("queueWithMax2.dequeue() should be 5 and the result is "+queueWithMax2.dequeue());
//        System.out.println("queueWithMax2.max() should be NoSuchElementException and the result is "
//                +queueWithMax2.max());


        QueueWithMax queueWithMax3 = new QueueWithMax();
        queueWithMax3.enqueue(1);
        queueWithMax3.enqueue(5);
        queueWithMax3.enqueue(3);
        queueWithMax3.enqueue(9);

    }
}
