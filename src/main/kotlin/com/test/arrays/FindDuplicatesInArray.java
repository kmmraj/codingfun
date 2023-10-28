//https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
package com.test.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FindDuplicatesInArray {

    public static int[] removeDuplicates(int[] arr) {

        List<Integer> uniqueElementList = new ArrayList<>();
        // uniqueElement[0] = arr[0];
        uniqueElementList.add(arr[0]);
        for (int indx = 1; indx <= arr.length - 1; indx++) {
            if (arr[indx - 1] != arr[indx]) {
                uniqueElementList.add(arr[indx]);
            }
        }
        int[] uniqueElementArray = new int[uniqueElementList.size()];
        for (int indx = 0; indx <= uniqueElementList.size() - 1; indx++) {
            uniqueElementArray[indx] = uniqueElementList.get(indx);
        }
        return uniqueElementArray;
    }


    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> uniqueElements = new java.util.HashSet<>();
        for (int indx = 0; indx <= nums.length - 1; indx++) {
            if (!uniqueElements.add(nums[indx])) {
                duplicates.add(nums[indx]);
            }
        }
        return duplicates;

    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 4, 5, 5, 7, 8};
        int[] uniqueElementArray = removeDuplicates(array);
        for (int indx = 0; indx < uniqueElementArray.length; indx++) {
            System.out.println(uniqueElementArray[indx]);
        }

        List<Integer> duplicates = new FindDuplicatesInArray().findDuplicates(array);
        System.out.println("Dupliactes are : " + duplicates);
    }
}
