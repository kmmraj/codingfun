package com.test.arrays;

import java.util.*;

public class SingleNum {

    public int singleNumber(int[] nums) {
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

    public static void main(String[] args) {

        int[] nums = {1,2,2,3,3,4,1};
        SingleNum num = new SingleNum();
        System.out.println(num.singleNumber(nums));
    }
}
