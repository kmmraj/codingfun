package com.test.slidingwindow;

//You are given an array of 1s and 0s and you are given an integer k which signifies the number of flips allowed.
// Write a program to return the count of the maximum number of consecutive;
// 1's in the array if you can flip at most;0's.
// Input: X[]= [1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1], k = 2, Output: 7
// Input: X[] = [1, 0, 0, 1, 0, 1, 0, 1, 0], k = 2, Output: 5

public class MaxNumberOfOnesWithAllowedFlips {

    public static void main(String[] args) {
        int[] input = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        int k = 2;

        int maxOnes = findMaxOnes(input, k);
        System.out.println("Max Ones: " + maxOnes);

        input = new int[]{1, 0, 0, 1, 0, 1, 0, 1, 0};
        k = 2;
        System.out.println("Max Ones: " + findMaxOnes(input, k));
    }

    private static int findMaxOnes(int[] input, int k) {
        int left = 0;
        int maxOnes = 0;
        int zeroCount = 0;
        for (int right = 0; right < input.length; right++) {
            if (input[right] == 0) {
                zeroCount = zeroCount + 1;
            }
            if (zeroCount > k) {
                if (input[left] == 0) {
                    zeroCount = zeroCount - 1;
                }
                left = left + 1;
            }
            maxOnes = Integer.max(maxOnes,  right - left + 1);
        }
        return maxOnes;
    }
}
