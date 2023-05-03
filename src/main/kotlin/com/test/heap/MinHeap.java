package com.test.heap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MinHeap {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
        // Write your code here.
        int parentIdx = ((array.size() - 1) - 1) / 2;
        for (int idx = parentIdx; idx >= 0; idx--) {
            siftDown(idx, array.size() - 1, array);
        }
        return array;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> list) {
        // Write your code here.
        int child1Idx = (currentIdx * 2) + 1;
        while (child1Idx <= endIdx) {
            int tentativeChild2Idx = (currentIdx * 2) + 2;
            int child2Idx = tentativeChild2Idx <= endIdx ? tentativeChild2Idx : -1;
            int idx2Swap;
            if (child2Idx != -1 && list.get(child2Idx) <= list.get(child1Idx)) {
                idx2Swap = child2Idx;
            } else {
                idx2Swap = child1Idx;
            }
            if (list.get(idx2Swap) < list.get(currentIdx)) {
                swapValue(currentIdx, idx2Swap, list);
                currentIdx = idx2Swap;
                child1Idx = (currentIdx * 2) + 1;
            } else {
                return;
            }

        }

    }

    public void siftUp(int currentIdx, List<Integer> heap) {
        // Write your code here.
        int parentIdx = (currentIdx - 1) / 2;
        while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
            swapValue(currentIdx, parentIdx, heap);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }

    public int peek() {
        // Write your code here.
        return heap.get(0);
    }

    public int remove() {
        // Write your code here.
        int returnVal = heap.get(0);
        swapValue(0, heap.size() - 1, heap);
        heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return returnVal;
    }

    private void swapValue(int idx1, int idx2, List<Integer> heap) {
        int temp = heap.get(idx1);
        heap.set(idx1, heap.get(idx2));
        heap.set(idx2, temp);
    }

    public void insert(int value) {
        // Write your code here.
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }

    @Test
    public static void TestCase1() {
        MinHeap minHeap =
                new MinHeap(
                        new ArrayList<>(
                                Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41)));
        minHeap.insert(76);
        assertTrue(isMinHeapPropertySatisfied(minHeap.heap));
        assertTrue(minHeap.peek() == -5);
        assertTrue(minHeap.remove() == -5);
        assertTrue(isMinHeapPropertySatisfied(minHeap.heap));
        assertTrue(minHeap.peek() == 2);
        assertTrue(minHeap.remove() == 2);
        assertTrue(isMinHeapPropertySatisfied(minHeap.heap));
        assertTrue(minHeap.peek() == 6);
        minHeap.insert(87);
        assertTrue(isMinHeapPropertySatisfied(minHeap.heap));
    }

    static boolean isMinHeapPropertySatisfied(List<Integer> array) {
        for (int currentIdx = 1; currentIdx < array.size(); currentIdx++) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                return true;
            }
            if (array.get(parentIdx) > array.get(currentIdx)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MinHeap.TestCase1();
    }
}
