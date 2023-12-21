package com.test.arrays;

import java.util.*;

public class ThreeSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        List<Integer[]> resultList = new ArrayList<>();
        for (int idx = 0; idx < array.length; idx++) {
            for (int jdx = idx+1; jdx < array.length; jdx++) {
                for (int kdx = jdx+1; kdx < array.length; kdx++) {
                    if(array[idx]+array[jdx]+array[kdx] == targetSum){
                       Integer[] intArray = new Integer[] {array[idx],array[jdx],array[kdx]};
                       Arrays.sort(intArray);
                       resultList.add(intArray);
                    }
                }
            }
        }
        //resultList = Collections.sort(resultList);
//        resultList.sort((a, b)->b[1].compareTo(a[1]));
        resultList.sort(ThreeSum::compareArray);
        return resultList;
    }

    public static List<Integer[]> threeNumberSumWith2Prt(int[] array, int targetSum){
        Arrays.sort(array);
        List<Integer[]> resultList = new ArrayList<>();
        for (int idx = 0; idx < array.length; idx++) {
            int left=idx+1,right=array.length-1;
            while (left<right){
                int currentSum = array[left]+array[right] +array[idx];
                if(currentSum == targetSum){
                    Integer[] intArray =  new Integer[] {array[idx],array[left],array[right]};
                    resultList.add(intArray);
                    left++;
                    right--;
                } else if(currentSum < targetSum){
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        List<Integer[]> resultList = ThreeSum.threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
     //   List<Integer[]> resultList = ThreeSum.threeNumberSumWith2Prt(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
        for (int idx = 0; idx < resultList.size(); idx++) {
            Integer[] intArray = resultList.get(idx);
            System.out.printf("[ ");
            for (int jdx = 0; jdx < intArray.length; jdx++) {
                System.out.printf("%2d ", intArray[jdx]);
            }
            System.out.printf("]");
        }
    }

    private static int compareArray(Integer[] a, Integer[] b) {
        int compare = 0;
        for (int idx = 0; idx < a.length; idx++) {
            compare = a[idx].compareTo(b[idx]);
            if (compare == 0)
                continue;
            else
                return compare;
        }
        return compare;
    }
}
