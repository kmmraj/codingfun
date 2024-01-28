package com.test.arrays.random;

import java.util.*;

public class RandomPickWithIndex {
    int[] nums;
    Map<Integer, List<Integer>> numMap; // Key is the number and value is the list of indexes (where the duplicates are present)
    Random rand;

    public RandomPickWithIndex(int[] nums) {
        // Option#1
        this.nums = nums;
        this.rand = new Random();

//        // Option#2
//        // this.rand = new Random();
//        this.numMap = new HashMap<>();
//        for(int index=0;index<nums.length;index++){
//            List<Integer> numList = numMap.computeIfAbsent(nums[index],k->new ArrayList<>());
//            numList.add(index);
//        }

    }

    public int pick(int target) {
        // Option#1
        int index = -1;
        int count = 1;
        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] == target && rand.nextInt(count++) == 0) {
                index = idx;
                // return idx;
            }
        }
        return index;

        // Option#2

//        if(!numMap.containsKey(target)){
//            return -1;
//        }
//
//        List<Integer> numList = numMap.get(target);
//        return numList.get(rand.nextInt(numList.size()));
    }


    public static void main(String[] args) {
        RandomPickWithIndex randomPickWithIndex = new RandomPickWithIndex(new int[]{1, 2, 2, 3, 3, 3});
        System.out.println("randomPickWithIndex.pick(3) = " + randomPickWithIndex.pick(3));
        System.out.println("randomPickWithIndex.pick(3) = " + randomPickWithIndex.pick(3));
        System.out.println("randomPickWithIndex.pick(3) = " + randomPickWithIndex.pick(3));
        System.out.println("randomPickWithIndex.pick(3) = " + randomPickWithIndex.pick(3));
        System.out.println("randomPickWithIndex.pick(3) = " + randomPickWithIndex.pick(3));
        System.out.println("randomPickWithIndex.pick(3) = " + randomPickWithIndex.pick(3));
        System.out.println("randomPickWithIndex.pick(3) = " + randomPickWithIndex.pick(3));
        System.out.println("randomPickWithIndex.pick(3) = " + randomPickWithIndex.pick(3));
        System.out.println("randomPickWithIndex.pick(3) = " + randomPickWithIndex.pick(3));
        System.out.println("randomPickWithIndex.pick(2) = " + randomPickWithIndex.pick(2));
        System.out.println("randomPickWithIndex.pick(2) = " + randomPickWithIndex.pick(2));
        System.out.println("randomPickWithIndex.pick(2) = " + randomPickWithIndex.pick(2));
    }
}
