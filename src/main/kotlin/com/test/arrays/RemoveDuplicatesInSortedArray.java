package com.test.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInSortedArray {

    public int removeDuplicates(int[] nums) {
        int count = 0;
        int index = 1;
        while (index < nums.length){
            if(nums[index-1] == nums[index]){
                nums[index-1] = Integer.MAX_VALUE;
                count++;
            }
            index++;
        }
        Arrays.sort(nums);
        return nums.length - count;
    }

    public static void main(String[] args) {
        RemoveDuplicatesInSortedArray removeDuplicatesInSortedArray = new RemoveDuplicatesInSortedArray();
        int[] nums = {1,1,2};
        System.out.println(removeDuplicatesInSortedArray.removeDuplicates(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
