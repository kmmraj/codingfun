package com.test.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//https://www.algoexpert.io/questions/Two%20Number%20Sum
public class TwoNumSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        for (int idx = 0; idx < array.length; idx++) {
            for (int jdx = idx+1; jdx < array.length; jdx++) {
                if(array[idx]+array[jdx] == targetSum){
                  return new int[] {array[idx],array[jdx]};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSumUsingHT(int[] array, int targetSum) {
        // Write your code here.
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : array) {
            int neededValue = targetSum - num;
            if (hashSet.contains(neededValue)) {
                return new int[]{num, neededValue};
            } else {
                hashSet.add(num);
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSumUsing2Ptr(int[] array, int targetSum) {
        // Write your code here.
        int left =0;
        int right = array.length;
        Arrays.sort(array);
        while (left<right){
            int currentSum = array[left]+array[right];
            if(currentSum == targetSum){
                return new int[] {array[left], array[right]};
            } else if(currentSum < targetSum){
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }


    private static int[] twoNumberSumUsingMap(final int[] array, final int targetSum){
        // Write your code here.
       Map<Integer,Integer> targetMap = new HashMap<>(); // Value is Key, Key is value
       for(int indx=0; indx <= array.length-1; indx++){
           if(targetMap.containsKey(targetSum - array[indx])){
               return new int[]{targetMap.get(targetSum - array[indx]),indx};
           } else {
               targetMap.put(array[indx],indx);
           }
       }
       return new int[] {0};
    }

    // With offset method
    public int[] twoSum(int[] numbers, int target) {

        int[] arr = new int[2001 + 1];

        for (int i = 0; i < numbers.length; i++) {
            if (arr[ numbers[i] + 1000 ] > 0) return new int[] {arr[ numbers[i] + 1000 ], ++i};

            int searchedValue = target - numbers[i] + 1000;
            if (searchedValue <= 2001) {
                arr[searchedValue] = i + 1;
            }
        }

        return new int[2];
    }

    public static void main(String[] args) {
        int[] array = {3,5,-4,8,11,1,-1,6};
//        int[] answer = TwoNumSum.twoNumberSum(array,10);
        int[] answer = TwoNumSum.twoNumberSumUsingMap(array,10);
        for (int idx = 0; idx < answer.length; idx++) {
            System.out.printf("%2d ",answer[idx]);
        }

        int[] answer1 = TwoNumSum.twoNumberSumUsingHT(array,10);
        for (int idx = 0; idx < answer1.length; idx++) {
            System.out.printf("%2d ",answer1[idx]);
        }

        System.out.println();
        int[] answer2 = TwoNumSum.twoNumberSumUsingHT(array,10);
        for (int idx = 0; idx < answer2.length; idx++) {
            System.out.printf("%2d ",answer2[idx]);
        }
    }
}
