package com.test.arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] array) {
        for (int idx = 1; idx < array.length; idx++) {
            int jdx = idx - 1;
            int kdx = idx;
            while (jdx >= 0 && array[jdx] > array[kdx]) {
                int temp = array[kdx];
                array[kdx] = array[jdx];
                array[jdx] = temp;
                jdx--;
                kdx--;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        // int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        int[] expected = InsertionSort.insertionSort(input);
        for (int idx = 0; idx < expected.length; idx++) {
            System.out.printf("%2d ", expected[idx]);
        }
    }
}
