package com.test.arrays;

import java.util.Arrays;

public class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        boolean visitedOnce = true;
        int index = 0;
        int counter = 0;
        while (counter< array.length) {
            if(index==0 && counter>0) return false;
            index = getIndex(index,array);
            counter++;

        }
        return index == 0;
    }

    private static int getIndex(int index, int[] array) {
        int value =  array[index];
        value = (value+ index) % array.length;
        return value >=0 ? value: value+array.length ;
    }

    public static void main(String[] args) {
        TestCase1();
    }
    public static void TestCase1() {
        System.out.println(SingleCycleCheck.hasSingleCycle(new int[] {2, 3, 1, -4, -4, 2}) == true);
    }
}
