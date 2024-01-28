package com.test.linklist;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class CircularQueueUsingArray {


    private int head = 0;
    private int tail = 0;
    private int numQueueElements = 0;
    private static final int SCALE_FACTOR = 2;
    private Integer[] entries;

    public CircularQueueUsingArray(int capacity) {
        entries = new Integer[capacity];
    }

    public void enqueue(Integer x) {
        if (numQueueElements == entries.length) { // Need to resize.
            // Makes the queue elements appear consecutively.
            Collections.rotate(Arrays.asList(entries), -head);
            // Resets head and tail.
            head = 0;
            tail = numQueueElements;
            entries = Arrays.copyOf(entries, numQueueElements * SCALE_FACTOR);
        }
        entries[tail] = x;
        tail = (tail + 1) % entries.length;
        ++numQueueElements;
    }

    public Integer dequeue() {
        if (numQueueElements != 0) {
            --numQueueElements;
            Integer ret = entries[head];
            head = (head + 1) % entries.length;
            return ret;
        }
        throw new NoSuchElementException("Dequeue called on an empty queue.");
    }

    public int size() {
        return numQueueElements;
    }


    public static void main(String[] args) {
        // Create a queue of capacity 4
        CircularQueueUsingArray cqa = new CircularQueueUsingArray(4);
        cqa.enqueue(20);
        cqa.enqueue(30);
        cqa.enqueue(40);
        cqa.enqueue(50);
        cqa.dequeue();
        cqa.enqueue(60);
        cqa.enqueue(70);
        cqa.enqueue(80);
        cqa.dequeue();
        cqa.dequeue();
        cqa.enqueue(90);
        cqa.enqueue(100);
        cqa.enqueue(110);
        cqa.enqueue(120);
        cqa.enqueue(130);
        cqa.enqueue(140);

    }

}
