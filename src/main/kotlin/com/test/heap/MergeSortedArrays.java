package com.test.heap;


import java.util.*;

/*
The mergeSortedArrays method has a time complexity of O(n log k) and a space complexity of O(k),
where n is the total number of elements in all the sorted arrays and k is the number of sorted arrays.
This is because the PriorityQueue is initialized with a size of k (the number of sorted arrays),
and each insertion operation in a PriorityQueue takes O(log k) time.

The PriorityQueue stores at most k elements at any time, hence the space complexity is O(k).

On the other hand, the mergeSortedArrays2 method has a time complexity of O(n log n) and a space complexity of O(n),
where n is the total number of elements in all the sorted arrays.
This is because all elements from each sorted array are directly added to the PriorityQueue,
and each insertion operation in a PriorityQueue takes O(log n) time.
The PriorityQueue stores all n elements at once, hence the space complexity is O(n).

In summary, mergeSortedArrays is more space-efficient when dealing with a large number of sorted arrays (large k),
while mergeSortedArrays2 is more time-efficient when dealing with a small number of large sorted arrays (small k, large n).
 */
public class MergeSortedArrays {
    private static class ArrayEntry {
        public Integer value;
        public Integer arrayld;

        public ArrayEntry(Integer value, Integer arrayld) {
            this.value = value;
            this.arrayld = arrayld;
        }
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
        List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
        for (List<Integer> array : sortedArrays) {
            iters.add(array.iterator());
        }
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(sortedArrays.size(),
                (ol, o2) -> Integer.compare(ol.value, o2.value));
        for (int i = 0; i < iters.size(); ++i) {
            if (iters.get(i).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(i).next(), i));
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ArrayEntry headEntry = minHeap.poll();
            result.add(headEntry.value);
            if (iters.get(headEntry.arrayld).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(headEntry.arrayld).next(), headEntry.arrayld));
            }
        }
        return result;
    }

    public static List<Integer> mergeSortedArrays2(List<List<Integer>> sortedArrays) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (List<Integer> array : sortedArrays) {
            minHeap.addAll(array);
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> sortedArrays = new ArrayList<>();
        sortedArrays.add(Arrays.asList(3, 5, 10));
        sortedArrays.add(Arrays.asList(1, 2, 100));
        sortedArrays.add(Arrays.asList(1, 12, 13));
        System.out.println(mergeSortedArrays(sortedArrays));
    }

}

