package com.test.heap;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    boolean isEven = true;
    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (isEven) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.peek());

        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.peek());
        }
        isEven = !isEven;
    }

    public double findMedian() {
        if (isEven) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
     // ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
        //[[],[1],[2],[],[3],[]]
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double median = medianFinder.findMedian();
        System.out.println("Median: " + median + " expected: 1.5");
        medianFinder.addNum(3);
        median = medianFinder.findMedian();
        System.out.println("Median: " + median +" expected: 2.0");

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

