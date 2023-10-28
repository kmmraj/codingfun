package com.test.overalappingintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {


    private static int minHalls(int[][] lectures, int n) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(lectures.length, (one, two) -> one[1] - two[0]);
        Arrays.stream(lectures).sequential().forEach(queue::add);
        int numOfRooms = !queue.isEmpty() ? 1 : 0;
        int prev = !queue.isEmpty() ? queue.poll()[1] : 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (prev > current[0]) {
                numOfRooms++;
            } else {
                prev = current[1];
            }
        }
        return numOfRooms;
    }
    public static void main(String[] args)
    {
        int lectures[][] = { { 0, 5 }, { 1, 2 }, { 1, 10 } };
        int n = lectures.length;

        System.out.println(minHalls(lectures, n));

        // input: lectures[][] = {{0, 5}, {1, 2}, {6, 10}}
        // Output: 2
        // Explanation: Since [1, 2] overlaps with [0, 5],

        lectures = new int[][]{{0, 5}, {1, 2}, {6, 10}};
        n = lectures.length;
        System.out.println(minHalls(lectures, n));

        // input: lectures[][] = {{4, 5}, {2, 3}, {2, 4}, {3, 5}}
        // Output: 3
        // Explanation: Since [2, 4] overlaps with [3, 5],

        lectures = new int[][]{{4, 5}, {2, 3}, {2, 4}, {3, 5}};
        n = lectures.length;
        System.out.println(minHalls(lectures, n));
    }

}
