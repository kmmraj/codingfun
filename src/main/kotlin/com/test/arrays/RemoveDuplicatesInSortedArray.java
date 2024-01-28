package com.test.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInSortedArray {

    public int removeDuplicates(int[] nums) {
        // Option#1 - Using MAX_VALUE to set the duplicate values and sort the array
//        int count = 0;
//        int index = 1;
//        while (index < nums.length) {
//            if (nums[index - 1] == nums[index]) {
//                nums[index - 1] = Integer.MAX_VALUE;
//                count++;
//            }
//            index++;
//        }
//        Arrays.sort(nums);
//        return nums.length - count;

        // Option#2 - Using Set to remove duplicates - Complexity is O(n) and space is O(n)
//         Set<Integer> set = new HashSet<>();
//         for (int num : nums) {
//             set.add(num);
//         }
//        Update the array with the set values
//         int index = 0;
//         for (Integer integer : set) {
//             nums[index] = integer;
//             index++;
//         }
//         return set.size();

        // Option#3 - Using two pointers
        if (nums.length == 0) {
            return 0;
        }
        int writeIndex = 1; // Write Index is the tracking one
        for (int readIndex = 1; readIndex <= nums.length - 1; readIndex++) {
            if (nums[readIndex - 1] != nums[readIndex]) {
                // Skip incrementing write index, when duplicates are encountered
                nums[writeIndex++] = nums[readIndex];
            }
        }
        return writeIndex;


    }

    public static void main(String[] args) {
        RemoveDuplicatesInSortedArray removeDuplicatesInSortedArray = new RemoveDuplicatesInSortedArray();
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicatesInSortedArray.removeDuplicates(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
