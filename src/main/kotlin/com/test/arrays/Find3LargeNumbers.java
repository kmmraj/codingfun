package com.test.arrays;

import java.util.Arrays;

public class Find3LargeNumbers {
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int[] result = new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        for (int idx = 0; idx < array.length; idx++) {
            if(array[idx]> result[2] || array[idx]> result[0] ){
                result = insertIt(array[idx],result);
            }
        }
        return result;
    }

    private static int[] insertIt(int newValue, int[] result) {
        for (int jdx = 0; jdx < result.length; jdx++) {
            if(result[jdx] < newValue){
                result[jdx] = newValue;
                Arrays.sort(result);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = findThreeLargestNumbers(new int[] {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7});
        for (int item:nums) {
            System.out.printf("%2d ",item);
        }
    }
}
