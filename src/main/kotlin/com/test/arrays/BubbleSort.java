package com.test.arrays;

import java.io.OutputStream;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        boolean isSorted = true;
        for (int idx = 0; (idx < array.length && isSorted); idx++) {
            isSorted = false;
            for (int jdx = idx; jdx < array.length; jdx++) {
                if (array[idx] > array[jdx]) {
                    int temp = array[idx];
                    array[idx] = array[jdx];
                    array[jdx] = temp;
                    isSorted = true;
                }
            }
        }
        return array;
    }

    public static int[] bubbleSortOne(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            for (int idx = 0; idx < array.length - 1; idx++) {
                if (array[idx] > array[idx + 1]) {
                    int temp = array[idx];
                    array[idx] = array[idx + 1];
                    array[idx + 1] = temp;
                    isSorted = true;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
//        int[] input = {2, 1, 3, 4, 5};
//        int[] input = {1, 3, 2};
        int[] output = BubbleSort.bubbleSortOne(input);
        for (int idx = 0; idx < output.length; idx++) {
            System.out.printf("%2d ", output[idx]);
        }
    }
}
