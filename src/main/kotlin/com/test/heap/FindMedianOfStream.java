package com.test.heap;
// 295. Find Median from Data Stream
// https://leetcode.com/problems/find-median-from-data-stream/
// Hard
/**
 * The median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value, and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far.
 * Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 *
 * Input
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output
 * [null, null, null, 1.5, null, 2.0]
 *
 * Explanation
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 *
 *
 * Constraints:
 *
 * -105 <= num <= 105
 * There will be at least one element in the data structure before calling findMedian.
 * At most 5 * 104 calls will be made to addNum and findMedian.
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 * If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianOfStream {


    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public FindMedianOfStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(16, Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (minHeap.isEmpty()) {
            minHeap.add(num);
            return;
        }

        if (num > minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        // Min Heap size must be > than max heap

        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.remove());
        } else if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.remove());
        }

    }

    public double findMedian() {
        return minHeap.size() == maxHeap.size()
                ? (0.5 * (minHeap.peek() + maxHeap.peek()))
                : minHeap.peek();
    }


    public static void main(String[] args) {
        FindMedianOfStream medianFinder = new FindMedianOfStream();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("medianFinder.findMedian() should be 1.5 and the result is = " + medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println("medianFinder.findMedian() should be 2 and the result is = " + medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println("medianFinder.findMedian() should be 2.5 and the result is = " + medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println("medianFinder.findMedian() should be 3 and the result is = " + medianFinder.findMedian());

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */