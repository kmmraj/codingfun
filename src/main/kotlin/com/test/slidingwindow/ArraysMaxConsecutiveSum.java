package com.test.slidingwindow;

//Given array of integers, find the maximal possible sum of some of its k consecutive elements.
//
//Example
//
//For inputArray = [2, 3, 5, 1, 6] and k = 2, the output should be
//solution(inputArray, k) = 8.
//All possible sums of 2 consecutive elements are:
//
//2 + 3 = 5;
//3 + 5 = 8;
//5 + 1 = 6;
//1 + 6 = 7.
//Thus, the answer is 8.
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] array.integer inputArray
//
//Array of positive integers.
//
//Guaranteed constraints:
//3 ≤ inputArray.length ≤ 105,
//1 ≤ inputArray[i] ≤ 1000.
//
//[input] integer k
//
//An integer (not greater than the length of inputArray).
//
//Guaranteed constraints:
//1 ≤ k ≤ inputArray.length.
//
//[output] integer
//
//The maximal possible sum.
public class ArraysMaxConsecutiveSum {
    int solution(int[] inputArray, int k) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        int tempResult = 0;
        int jdx = 0;
        while (count < k) {
            tempResult = tempResult + inputArray[jdx];
            // System.out.println("tempResult is " + tempResult + " inputArray[" + jdx + "] is " + inputArray[jdx]);
            jdx++;
            count++;
        }
        result = Integer.max(tempResult, result);
        // System.out.println("result is " + result); [1, 3, 2, 4]
        for (int index = 1; index + k <= inputArray.length; index++) {
            // System.out.println("index is " + index + " inputArray[index - 1] is " + inputArray[index - 1] + " tempResult is " + tempResult + " inputArray[index+k-1] is " + inputArray[index+k-1]);
            tempResult = tempResult - inputArray[index - 1] + inputArray[index + k - 1];
            result = Integer.max(tempResult, result);
            System.out.println("result is " + result);
        }
        return result;
    }

    public static void main(String[] args) {
        ArraysMaxConsecutiveSum arraysMaxConsecutiveSum = new ArraysMaxConsecutiveSum();
        System.out.println("Should be 8 and result is " + arraysMaxConsecutiveSum.solution(new int[]{2, 3, 5, 1, 6}, 2));
        System.out.println("Should be 14 and result is " + arraysMaxConsecutiveSum.solution(new int[]{2, 4, 10, 1}, 2));
        System.out.println("Should be 9 and result is " + arraysMaxConsecutiveSum.solution(new int[]{1, 3, 2, 4}, 3));
        System.out.println("Should be 3 and result is " + arraysMaxConsecutiveSum.solution(new int[]{3, 2, 1, 1}, 1));
        System.out.println("Should be 0 and result is " + arraysMaxConsecutiveSum.solution(new int[]{1, 3, 2, 4}, 0));
        System.out.println("Should be 10 and result is " + arraysMaxConsecutiveSum.solution(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9, 10}, 1));
       // System.out.println("Should be 10 and result is " + arraysMaxConsecutiveSum.solution(new int[]{1, 3, 2, 4, 5, 6, 7, 8, 9
    }
}
