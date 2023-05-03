package com.test.arrays;

import java.util.Arrays;

public class MinWaitingTime {

    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int totalWaitingTime =0;
        int curWaitingTime =0;
        for (int idx = 1; idx < queries.length; idx++) {
            curWaitingTime = curWaitingTime+queries[idx-1];
            totalWaitingTime = totalWaitingTime+curWaitingTime;
        }

        return totalWaitingTime;
    }

    public static void main(String[] args) {
        int[] queries = new int[] {3, 2, 1, 2, 6};
        int expected = 17;
        int actual = new MinWaitingTime().minimumWaitingTime(queries);
       // Utils.assertTrue(actual == expected);
        System.out.printf("Total Waiting Time is : %2d",actual);
    }
}
