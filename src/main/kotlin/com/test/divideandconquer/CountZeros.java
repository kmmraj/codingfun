package com.test.divideandconquer;


/**
 * Given an array of 1s and 0s which has all 1s first followed by all 0s,
 * write a function called countZeroes, which returns the number of zeroes in the array.
 * <p>
 * countZeroes([1,1,1,1,0,0]) # 2
 * countZeroes([1,0,0,0,0]) # 4
 * countZeroes([0,0,0]) # 3
 * countZeroes([1,1,1,1]) # 0
 */
public class CountZeros {


    public static int countZeroes(int[] array) {
        //   TODO
        int middle;
        int left = 0;
        int right = array.length;
        while (left < right) {
            middle = (left + (right)) / 2;
            if (array[middle] == 1) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return array.length - left;
    }

    public static void main(String[] args) {
        System.out.println(CountZeros.countZeroes(new int[]{1, 1, 1, 1, 0, 0}));
        System.out.println(CountZeros.countZeroes(new int[]{1, 1, 1, 1}));
        System.out.println(CountZeros.countZeroes(new int[]{0, 0, 0}));
    }
}
