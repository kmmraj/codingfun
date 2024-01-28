package com.test.arrays;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

//Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
//
//Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
//
//Return k after placing the final result in the first k slots of nums.
//
//Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
//
//Custom Judge:
//
//The judge will test your solution with the following code:
//
//int[] nums = [...]; // Input array
//int[] expectedNums = [...]; // The expected answer with correct length
//
//int k = removeDuplicates(nums); // Calls your implementation
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//}
//If all assertions pass, then your solution will be accepted.
//
// 
//
//Example 1:
//
//Input: nums = [1,1,1,2,2,3]
//Output: 5, nums = [1,1,2,2,3,_]
//Explanation: Your function should return k = 5, 
// with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//Example 2:
//
//Input: nums = [0,0,1,1,1,1,2,3,3]
//Output: 7, nums = [0,0,1,1,2,3,3,_,_]
//Explanation: Your function should return k = 7, 
// with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray2 {
    public int removeDuplicates1(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }
        int index = 2;
        //[0,0,1,1,1,1,2,3,3]
        for (int idx = 2; idx < nums.length; idx++) {
            if (nums[idx] != nums[index - 2]) {
                nums[index] = nums[idx];
                index++;
            }
        }
        return index;
    }

    public int removeDuplicates2(int[] nums) {
        //  [0,0,1,1,1,1,2,3,3]
        //   [1,1,1,2,2,3]
        int writeIndex = 2;
        for (int readIndex = 2; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[writeIndex - 2]) { // ***This comparison is important**
                // for [1,1,1,2,2,3] At rindex 2 => [1,1,1,2,2,3] (skip)
                nums[writeIndex] = nums[readIndex]; // at rindex 3 => [1,1,2,2,2,3]
                System.out.println("Copy readIndex is " + readIndex + " writeIndex is " + writeIndex + " nums is " + Arrays.toString(nums));
                writeIndex++;
            } else {
                System.out.println("Skip readIndex is " + readIndex + " writeIndex is " + writeIndex + " nums is " + Arrays.toString(nums));
            }

        }
        System.out.println("writeIndex is " + writeIndex + " nums is " + Arrays.toString(nums));
        return writeIndex;

    }

    public static void main(String[] args) {
        RemoveDuplicatesInSortedArray2 removeDuplicatesInSortedArray2 = new RemoveDuplicatesInSortedArray2();
        int[] input = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int result = removeDuplicatesInSortedArray2.removeDuplicates1(input);
        System.out.println("Result is " + result);
        for (int i = 0; i < result; i++) {
            System.out.printf("%2d ", input[i]);
        }

        input = new int[]{1,1,1,2,2,3};
        result = removeDuplicatesInSortedArray2.removeDuplicates2(input);
        System.out.println("Result is " + result);
        for (int i = 0; i < result; i++) {
            System.out.printf("%2d ", input[i]);
        }
    }
}
