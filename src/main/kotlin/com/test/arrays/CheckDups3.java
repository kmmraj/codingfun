package com.test.arrays;

import java.util.HashMap;

public class CheckDups3 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        HashMap<Integer,Integer> integerHashMap = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
            int target = t-nums[idx];

            if(integerHashMap.containsKey(idx)
                    && (idx - integerHashMap.get(idx) <= k)) {
                    return true;
            }

           integerHashMap.put(nums[idx],idx);
        }
        return false;
    }

    public static void main(String[] args) {
        CheckDups3 dups3 = new CheckDups3();
//        int[] nums = {1,2,3,1};
//        System.out.println(dups3.containsNearbyAlmostDuplicate(nums,3,0));
////        Input: nums = [1,0,1,1], k = 1, t = 2
////        Output: true
//        int [] nums1 = {1,0,1,1};
//        System.out.println(dups3.containsNearbyAlmostDuplicate(nums1,1,2));

//        Example 3:
//
//        Input: nums = [1,5,9,1,5,9], k = 2, t = 3
//        Output: false
        int [] nums2 = {1,5,9,1,5,9};
        System.out.println(dups3.containsNearbyAlmostDuplicate(nums2,2,3));
    }
}
