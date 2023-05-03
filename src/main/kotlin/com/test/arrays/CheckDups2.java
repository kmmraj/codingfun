// https://leetcode.com/problems/contains-duplicate-ii/submissions/
package com.test.arrays;

import java.util.HashMap;

public class CheckDups2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> integerHashMap = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            if(integerHashMap.containsKey(nums[idx])){
                int index = integerHashMap.get(nums[idx]);
                if(idx-index <= k)
                    return true;
                else
                    integerHashMap.put(nums[idx],idx);
            } else {
                integerHashMap.put(nums[idx],idx);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckDups2 dups2 = new CheckDups2();
        int[] nums = {1,2,3,1};
        System.out.println(dups2.containsNearbyDuplicate(nums,3));
        int[] nums1 = {1,2,3,1,2,3};
        System.out.println(dups2.containsNearbyDuplicate(nums1,2));
    }
}
