package com.test.twoptrs;
//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquareOfSortedArray {
    public int[] sortedSquares(int[] nums) {

        int start = 0;
        int end = nums.length-1;
        int[] returnArray = new int[nums.length];
        while (start <= end) {
            if(Math.abs(nums[start]) > Math.abs(nums[end])){
                returnArray[end-start] = nums[start] * nums[start];
                start++;
            } else {
                returnArray[end-start] = nums[end] * nums[end];
                end--;
            }
        }
        return returnArray;

    }

    public static void main(String[] args) {
        int[] input = new int[]{-4,-1,0,3,10};
        int[] expected = new int[]{0,1,9,16,100};
        int[] actual = new SquareOfSortedArray().sortedSquares(input);

        for (int i = 0; i < actual.length; i++) {
            System.out.printf("%2d ",actual[i]);
        }
    }
}
