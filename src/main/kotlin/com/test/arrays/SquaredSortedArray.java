package com.test.arrays;

import java.util.Arrays;

public class SquaredSortedArray {
    public int[] sortedSquaredArray(int[] array) {

        int [] squaredArray = new int[array.length];
        for (int idx = 0; idx < array.length; idx++) {
            squaredArray[idx] = array[idx]*array[idx];
        }
         Arrays.sort(squaredArray);
        return squaredArray;
    }

    public static void main(String[] args) {

    }
}
