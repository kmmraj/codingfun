package com.test.bitwise;
// https://leetcode.com/problems/single-number/

// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//
//
//Example 1:
//
//Input: nums = [2,2,1]
//Output: 1
//Example 2:
//
//Input: nums = [4,1,2,1,2]
//Output: 4
//Example 3:
//
//Input: nums = [1]
//Output: 1
//
//
//Constraints:
//
//1 <= nums.length <= 3 * 104
//-3 * 104 <= nums[i] <= 3 * 104
//Each element in the array appears twice except for one element which appears only once.
import java.util.*;

public class SingleNum {

    public int singleNumberOld(int[] nums) {
        Map<Integer,Integer> integerHashMap = new HashMap<>();
        for (int num : nums) {
            if (integerHashMap.containsKey(num)) {
                int val = integerHashMap.get(num);
                integerHashMap.put(num, val + 1);
            } else {
                integerHashMap.put(num, 1);
            }
        }

       return integerHashMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue( Comparator.reverseOrder()))
                .filter(integerEntry -> integerEntry.getValue() == 1 )
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    public int singleNumber(int[] nums) {

        int singular = 0;

        for(int index=0; index<nums.length;index++){
            singular = singular ^ nums[index];
        }
        return singular;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,2,3,3,4,1};
        SingleNum num = new SingleNum();
        System.out.println(num.singleNumber(nums));
    }
}
