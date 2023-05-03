package com.test.arrays;

public class KadanesAlgo {
    public static int kadanesAlgorithm(int[] array) {
        // Write your code here.

        int maxSoFar = array[0];
        int maxEndingHere = array[0];

        for (int idx = 1; idx < array.length; idx++) {
            maxEndingHere = Math.max(array[idx], maxEndingHere+array[idx]);
            maxSoFar = Math.max(maxEndingHere,maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        int[] input = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(KadanesAlgo.kadanesAlgorithm(input) == 19);
    }

}
