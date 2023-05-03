package com.test.arrays;

public class MaxSubsetSumNoAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int tempSum = 0, index = 0;

        MaxSumValue maxSumValue = new MaxSumValue();
        maxSum = solveItRecursively(array, maxSumValue, index);
        return maxSum;
    }
    public static class MaxSumValue{
        int maxSum = Integer.MIN_VALUE;
        int tempSum = 0;
    }

    private static int solveItRecursively(int[] array, MaxSumValue maxSumValue, int index) {
        //BC
        //  int maxSum = Integer.MIN_VALUE;
        if (index >= array.length)
            return maxSumValue.tempSum;

        // Choices
        // A -- Add it
        // B -- don't add
        maxSumValue.maxSum = Math.max(maxSumValue.maxSum,maxSumValue.tempSum);

        maxSumValue.tempSum = maxSumValue.tempSum + array[index];
        int maxSumInclude =  solveItRecursively(array, maxSumValue, index + 2);
        maxSumValue.tempSum = maxSumValue.tempSum - array[index];
        int maxSumNotInclude =  solveItRecursively(array, maxSumValue, index + 1);
        return Math.max(maxSumValue.maxSum,
                Math.max(
                        maxSumInclude,
                        maxSumNotInclude)
                );
    }


    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        int[] input = {75, 105, 120, 75, 90, 135};
        System.out.println(MaxSubsetSumNoAdjacent.maxSubsetSumNoAdjacent(input));
//        System.out.println(MaxSubsetSumNoAdjacent.maxSubsetSumNoAdjacent(input) == 330);
    }
}
