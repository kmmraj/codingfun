package com.test.arrays;

import java.util.Arrays;

public class SmallestDifference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int[] smallestDiffArray = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int smallestDiff = Integer.MAX_VALUE;
        for (int idx = 0; idx < arrayOne.length; idx++) {
            for (int jdx = 0; jdx < arrayTwo.length; jdx++) {
                int newDiff = Math.abs(arrayOne[idx] - arrayTwo[jdx]);
                if (newDiff < smallestDiff) {
                    smallestDiff = newDiff;
                    smallestDiffArray = new int[]{arrayOne[idx], arrayTwo[jdx]};
                }
            }
        }
        return smallestDiffArray;
    }

    public static void main(String[] args) {
        int[] smallestDiffArray = SmallestDifference.smallestDifference(
                new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17});

        for (int idx = 0; idx < smallestDiffArray.length; idx++) {
            System.out.printf("%2d ",smallestDiffArray[idx]);
        }
    }
}
