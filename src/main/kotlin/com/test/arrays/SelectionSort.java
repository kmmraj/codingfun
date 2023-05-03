package com.test.arrays;

public class SelectionSort {
    public static int[] selectionSort(int[] array) {
        for (int idx = 0; idx < array.length; idx++) {
            //find min between idx and array end and
            // move the lowest value to idx element
           // int minValue = getMinValue(array,idx);
            int minValue = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int jdx = idx; jdx < array.length; jdx++) {
                //minValue = Math.min(array[jdx],minValue);
                if(minValue > array[jdx]){
                    minValue = array[jdx];
                    minIdx = jdx;
                }
            }
            if(minIdx!=-1){
                int temp = array[idx];
                array[idx] = array[minIdx];
                array[minIdx] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        //int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        int[] expected = SelectionSort.selectionSort(input);
        for (int idx = 0; idx < expected.length; idx++) {
            System.out.printf("%2d ",expected[idx]);
        }
    }
}
