package com.test;

import java.util.ArrayList;

public class MedianOfSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr1;
        int[] arr2;
        if(nums1.length < nums2.length) {
            arr1 = nums1;
            arr2 = nums2;

        } else {
            arr1 = nums2;
            arr2 = nums1;
        }

        ArrayList<Integer> mergedArr = new ArrayList<Integer>();
        int arr1Idx = 0;
        int arr2Idx =0;
        while (arr1Idx < arr1.length && arr2Idx < arr2.length) {
                if(arr1[arr1Idx] > arr2[arr2Idx]){
                    mergedArr.add(arr2[arr2Idx++]);
                } else {
                    mergedArr.add(arr1[arr1Idx++]);
                }
        }
        for (int index1 = arr1Idx; index1 < arr1.length; index1++) {
            mergedArr.add(arr1[index1]);
        }

        for (int index2 = arr2Idx; index2 < arr2.length; index2++) {
            mergedArr.add(arr2[index2]);
        }

        int medianSize1 = mergedArr.size()/2;
        int medianSize2 = mergedArr.size()%2;

        if(medianSize2 == 0){
            return (mergedArr.get(medianSize1-1) + mergedArr.get(medianSize1))/2.0;
        } else {
            return mergedArr.get(medianSize1);
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        MedianOfSortedArray median = new MedianOfSortedArray();
        double medianVal;

        medianVal = median.findMedianSortedArrays(nums1,nums2);
        System.out.println(medianVal);

        int[] nums3 = {1};
        int[] nums4 = {2,3};
        medianVal = median.findMedianSortedArrays(nums3,nums4);
        System.out.println(medianVal);

        int[] nums5 = {1,2};
        int[] nums6 = {3,4};
        medianVal = median.findMedianSortedArrays(nums5,nums6);
        System.out.println(medianVal);

        int[] nums7 = {0,0};
        int[] nums8 = {0,0};
        medianVal = median.findMedianSortedArrays(nums7,nums8);
        System.out.println(medianVal);

        int[] nums9 = {};
        int[] nums10 = {2};
        medianVal = median.findMedianSortedArrays(nums9,nums10);
        System.out.println(medianVal);

        int[] nums11 = {2};
        int[] nums12 = {};
        medianVal = median.findMedianSortedArrays(nums11,nums12);
        System.out.println(medianVal);

        int[] nums13 = {};
        int[] nums14 = {2,3};
        medianVal = median.findMedianSortedArrays(nums13,nums14);
        System.out.println(medianVal);
    }
}
