package com.test;

import java.util.HashSet;

public class FindDupsNums {

    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int item:nums) {
            if(set.contains(item)){
                return item;
            }
            set.add(item);
        }

        return -1;
    }


    public int findDuplicateFast(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,2,5,1};
        int result;
        FindDupsNums findDupsNums = new FindDupsNums();
        result = findDupsNums.findDuplicateFast(nums);
        System.out.println("Result is "+ result);
    }
}
