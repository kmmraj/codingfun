package com.test.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class SingleNum {

    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> integerHashMap = new HashMap<>();
        for (int idx = 0; idx < nums.length; idx++) {
           if(integerHashMap.containsKey(nums[idx])){
               int val = integerHashMap.get(nums[idx]);
               integerHashMap.put(nums[idx],val+1);
           } else {
               integerHashMap.put(nums[idx],1);
           }
        }

        for (int val: nums) {
            if(integerHashMap.get(val) == 1)
                return val;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,2,3,3,4,1};
        SingleNum num = new SingleNum();
        System.out.println(num.singleNumber(nums));
    }
}
