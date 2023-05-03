package com.test.arrays;

import java.util.Arrays;

public class FindMissingNumbers {

    static int findMissingNumberInArray(int[] arr) {
        // Sorted
        Arrays.sort(arr);
        for(int indx=1; indx<= arr.length-1; indx++){
            if(arr[indx-1]+1 != arr[indx]) {
                return arr[indx]-1;
            }
        }
        return 0;
    }

    public static int findMissingNumberInArraySol2(int[] array) {
        int n = array.length + 1;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int number : array) {
            actualSum += number;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
//        int[] array = {1,2,3,4,5,7,8,9};
        int[] array = {1,8,3,4,5,7,2,9};
        int missingNumber = findMissingNumberInArray(array);
        System.out.println(missingNumber);
    }
}
