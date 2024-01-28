package com.test.arrays;
//https://leetcode.com/problems/remove-element/description/

import java.util.Arrays;

public class RemoveElement {
    public int removeElement1(int[] nums, int val) {
        int count = 0;
        int index1 = 0;
        while(index1 < nums.length){
            if(nums[index1] == val){
                count++;
                nums[index1] = Integer.MAX_VALUE;
            }
            index1++;
        }
        Arrays.sort(nums);
        return nums.length - count;

    }

    public int removeElement2(int[] nums, int val) {
        int writeIndex = 0;
        for(int readIndex=0; readIndex<nums.length; readIndex++){
            if(nums[readIndex] != val){
                nums[writeIndex++] = nums[readIndex];
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {3,2,2,3};
        System.out.println("Retain Index is "+removeElement.removeElement2(nums, 3));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println("Retain Index is "+removeElement.removeElement2(nums, 2));
        System.out.println(Arrays.toString(nums));

        nums =new int[] {0,1,2,3,4,5,5,5,6,7,8,9};
        System.out.println("Retain Index is "+removeElement.removeElement1(nums, 5));
        System.out.println(Arrays.toString(nums));
        }

    }

