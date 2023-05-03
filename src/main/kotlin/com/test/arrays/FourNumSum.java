package com.test.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FourNumSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        List<Integer[]> resultList = new ArrayList<>();
        for (int idx = 0; idx < array.length; idx++) {
            for (int jdx = idx+1; jdx < array.length; jdx++) {
                int left = jdx + 1;
                int right = array.length - 1;
                while (left < right) {
                    int currentSum = array[idx] + array[jdx] + array[left] + array[right];
                    if (currentSum == targetSum) {
                        Integer[] tempArray = new Integer[]{array[idx], array[jdx], array[left], array[right]};
                        resultList.add(tempArray);
                        left++;
                        right--;
                    } else if (currentSum < targetSum) {
                        left++;
                    } else if (currentSum > targetSum) {
                        right--;
                    }
                }
            }
        }
        return resultList;
    }

    private static boolean compare(List<Integer[]> quads1, List<Integer[]> quads2) {
        for (Integer[] quad : quads2) {
            Arrays.sort(quad);
        }
        for (Integer[] quad : quads1) {
            Arrays.sort(quad);
        }
        for (Integer[] quad2 : quads2) {
            boolean found = false;
            for (Integer[] quad1 : quads1) {
                if (Arrays.equals(quad2, quad1)) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                return false;
            }
        }
        return true;
    }

    @Test
    public static void TestCase1() {
        List<Integer[]> output = FourNumSum.fourNumberSum(new int[]{7, 6, 4, -1, 1, 2}, 16);
        List<Integer[]> quadruplets = new ArrayList<>();
        quadruplets.add(new Integer[]{7, 6, 4, -1});
        quadruplets.add(new Integer[]{7, 6, 1, 2});
        assertEquals(quadruplets.size(), output.size());
        assertTrue(FourNumSum.compare(quadruplets, output));
    }
    @Test
    public static void TestCase2() {
        List<Integer[]> output = FourNumSum.fourNumberSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 10);
        List<Integer[]> quadruplets = new ArrayList<>();
        quadruplets.add(new Integer[]{1, 2, 3, 4});
        assertEquals(quadruplets.size(), output.size());
        assertTrue(FourNumSum.compare(quadruplets, output));
    }

    public static void main(String[] args) {
//        FourNumSum.TestCase1();
        FourNumSum.TestCase2();
    }
}
