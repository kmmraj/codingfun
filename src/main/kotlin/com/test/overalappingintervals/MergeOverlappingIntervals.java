// https://leetcode.com/problems/non-overlapping-intervals
package com.test.overalappingintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(intervals.length, (one, two) -> one[1] - two[1]);
        Arrays.stream(intervals).parallel().forEach(queue::add);
        int result = 0;
        int prev = !queue.isEmpty() ? queue.poll()[1] : 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (prev > current[0]) {
                result++;
            } else {
                prev = current[1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
        //Output: 1
        //Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int toBeErased = new MergeOverlappingIntervals().eraseOverlapIntervals(intervals);

        System.out.println("To be erased: " + toBeErased);

    }
}
