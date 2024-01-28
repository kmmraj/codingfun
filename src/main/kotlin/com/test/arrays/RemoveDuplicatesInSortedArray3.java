package com.test.arrays;

//Write a program which takes input a sorted array and positive number
// and updates the array so that if x appears m times in array
// then it appears exactly min(2,m) times in array.
// the update should be performed in one pass with no additional memory
//if an array is {2,2,2,2,3} and the method is editArray(arr[],m)
//if m=4
//then after the method array should be {2,2,3,0,0}


import java.util.Arrays;

public class RemoveDuplicatesInSortedArray3 {

    void editArray(int arr[], int m, int arr_size) {
        final int min = Math.min(2, m);
        int writeIndex = min;
        for (int readIndex = min; readIndex < arr.length; readIndex++) {
            if(arr[readIndex]!= arr[writeIndex-min]){
                arr[writeIndex++] = arr[readIndex];
            }
        }

        for (int idx = writeIndex; idx < arr.length; idx++) {
            arr[idx] = 0;
        }

    }

    public static void main(String[] args) {
        RemoveDuplicatesInSortedArray3 removeDuplicatesInSortedArray3 = new RemoveDuplicatesInSortedArray3();
        int arr[] = { 2, 3, 3, 3, 6, 9, 9 };
        int n = arr.length;
        removeDuplicatesInSortedArray3.editArray(arr, n, n);
        System.out.println("After removing duplicates " + Arrays.toString(arr));

        arr = new int[]{2,2,2,2,3};
        n = arr.length;
        removeDuplicatesInSortedArray3.editArray(arr, n, n);
        System.out.println();
        System.out.println("After removing duplicates " + Arrays.toString(arr));

        arr = new int[]{2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,4,4,5,5,5,6,6,6,7,7};
        n = arr.length;
        removeDuplicatesInSortedArray3.editArray(arr, n, n);
        System.out.println();
        System.out.println("After removing duplicates " + Arrays.toString(arr));
    }
}
