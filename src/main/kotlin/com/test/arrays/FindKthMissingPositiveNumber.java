// https://leetcode.com/problems/kth-missing-positive-number/
package com.test.arrays;

public class FindKthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        boolean[] existingNumbers = new boolean[arr[arr.length - 1] + k];
        for (int idx = 0; idx <= arr.length - 1; idx++) {
            existingNumbers[arr[idx] - 1] = true;
        }
        int missingNumber = 0;
        for (int idx = 0; idx <= existingNumbers.length - 1; idx++) {
            if (!existingNumbers[idx]) {
                missingNumber++;
                if (missingNumber == k) {
                    return idx + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //Example 1:
        //
        //Input: arr = [2,3,4,7,11], k = 5
        //Output: 9
        //Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
        //Example 2:
        //
        //Input: arr = [1,2,3,4], k = 2
        //Output: 6
        //Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

        int[] arr = new int[] {2,3,4,7,11};
        int k = 5;
        int kthMissingPositiveNumber = new FindKthMissingPositiveNumber().findKthPositive(arr, k);
        System.out.println("Kth missing positive number: " + kthMissingPositiveNumber);

        arr = new int[] {1,2,3,4};
        k = 2;
        kthMissingPositiveNumber = new FindKthMissingPositiveNumber().findKthPositive(arr, k);
        System.out.println("Kth missing positive number: " + kthMissingPositiveNumber);
    }
}
