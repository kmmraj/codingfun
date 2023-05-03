package com.test.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class Permutations {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        return new ArrayList<List<Integer>>();
    }

//    private static List<List<Integer>> solveIt(List<Integer> array, int idx, List<List<Integer>> workingList) {
//        // BC
//        if (idx == array.size()) {
//            return workingList;
//        }
//
//        // Hypothesis and Induction
//
//
//    }

    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<List<Integer>> perms = Permutations.getPermutations(input);
        assertTrue(perms.size() == 6);
        assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 2, 3))));
        assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 3, 2))));
        assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 1, 3))));
        assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 3, 1))));
        assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 1, 2))));
        assertTrue(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 2, 1))));
    }

    public static boolean contains(List<List<Integer>> arr1, List<Integer> arr2) {
        for (List<Integer> subArray : arr1) {
            if (subArray.equals(arr2)) {
                return true;
            }
        }
        return false;
    }
}
