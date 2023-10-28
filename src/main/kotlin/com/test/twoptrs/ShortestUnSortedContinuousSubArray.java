package com.test.twoptrs;

import java.util.Arrays;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
public class ShortestUnSortedContinuousSubArray {

    public int findUnsortedSubarray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int [] sortedArray = nums.clone();
        Arrays.sort(sortedArray);
        while (start < nums.length && nums[start] == sortedArray[start]) {
            start++;
        }
        while (end > start && nums[end] == sortedArray[end]) {
            end--;
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 6, 4, 8, 10, 9, 15};
        int expected = 5;
        int actual = new ShortestUnSortedContinuousSubArray().findUnsortedSubarray(input);
        System.out.println("Expected: " + expected + ", Actual: " + actual);
    }
}
