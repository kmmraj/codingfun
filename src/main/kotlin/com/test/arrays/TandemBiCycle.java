package com.test.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TandemBiCycle {
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if (fastest) {
//            blueShirtSpeeds = Arrays.stream(blueShirtSpeeds)
//                    .boxed()
//                    .sorted(Comparator.reverseOrder())
//                    .mapToInt(Integer::intValue)
//                    .toArray();
            blueShirtSpeeds = reverseArray(blueShirtSpeeds);
        } else {
            Arrays.sort(blueShirtSpeeds);
        }


        int sum = 0;
        for (int idx = 0; idx < redShirtSpeeds.length; idx++) {
            int maxvalue = Math.max(blueShirtSpeeds[idx], redShirtSpeeds[idx]);
            sum = sum + maxvalue;
        }
        return sum;
    }

    private int[] reverseArray(int[] intArray) {
        int start =0;
        int end = intArray.length-1;
        while (start<end){
            int temp = intArray[start];
            intArray[start] = intArray[end];
            intArray[end] = temp;
            start++;
            end--;
        }
        return intArray;
    }

    public static void TestCase1() {
        int[] redShirtSpeeds = new int[]{5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[]{3, 6, 7, 2, 1};
        boolean fastest = true;
        int expected = 32;
        int actual = new TandemBiCycle().tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest);
        System.out.println(expected == actual);
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
