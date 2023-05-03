package com.test.arrays;

import java.util.HashSet;

public class CheckDups {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> integerHashSet = new HashSet<>();
        for (int item:nums) {
           if(integerHashSet.contains(item))
               return true;
           else
               integerHashSet.add(item);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,4};
        CheckDups dups = new CheckDups();
        System.out.println(dups.containsDuplicate(nums));
    }
}
