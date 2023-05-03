package com.test.arrays;

import java.util.HashSet;

public class FirstDuplicate {
    public int firstDuplicateValue(int[] array) {
        HashSet<Integer> integerHashSet = new HashSet<>();
        for (int idx = 0; idx < array.length; idx++) {
            if(!integerHashSet.contains(array[idx])){
                integerHashSet.add(array[idx]);
            } else {
                return array[idx];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2, 1, 5, 2, 3, 3, 4};
        int expected = 2;
        System.out.println(new FirstDuplicate().firstDuplicateValue(input));
    }
}
