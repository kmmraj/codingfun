package com.test.bitwise;
//https://leetcode.com/problems/single-number-ii
///Given an integer array nums where every element appears three times except for one,
// which appears exactly once. Find the single element and return it.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//
//
//Example 1:
//
//Input: nums = [2,2,3,2]
//Output: 3
//Example 2:
//
//Input: nums = [0,1,0,1,0,1,99]
//Output: 99
//
//
//Constraints:
//
//1 <= nums.length <= 3 * 104
//-231 <= nums[i] <= 231 - 1
//Each element in nums appears exactly three times except for one element which appears once.

public class SingleNumII {

    public int singleNumber(int[] nums) {
        int result = 0;
        for(int index=0; index< 32; index++){
            int sum = 0;
            for(final int num: nums){
                sum = sum + ((num >> index) & 1);
            }
            sum = sum % 3;
            result = result | sum << index;
        }
        return result;
    }

    public static void main(String[] args) {

            int[] nums = {1,1,2,2,3,3,3,4,1,2};
            SingleNumII singleNum = new SingleNumII();
            System.out.println(singleNum.singleNumber(nums));
    }
}
