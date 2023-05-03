package com.test.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RotateArrayByK {

    public void rotate(int[] nums, int k) {
        if(nums.length < k){
            System.out.println("Not Valid Input");
            return;
        }
        Stack<Integer> integerStack = new Stack<>();
        for (int idx = nums.length-1; idx > nums.length-1-k; idx--) {
            integerStack.add(nums[idx]);
        }
        List<Integer> integers = new ArrayList<>();
        while (!integerStack.isEmpty()){
            integers.add(integerStack.pop());
        }

        int remainLength = nums.length - k;
        for (int idx = 0; idx < remainLength; idx++) {
            integers.add(nums[idx]);
        }

        for (int rev: integers) {
            System.out.printf("%2d ,",rev);
        }
        nums = integers.stream().mapToInt(i->i).toArray();
        System.out.println();
        for (int rev: nums) {
            System.out.printf("%2d ,",rev);
        }
        return;
    }

    public void rotateByKSwap(int[] nums, int k) {

        k = k%nums.length;

        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

        System.out.println("\n------SWAP--------");
        for (int rev: nums) {
            System.out.printf("%2d ,",rev);
        }

    }

    private int[] reverse(int[] nums, int start, int end){
        while (start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }

    public static void main(String[] args) {
        RotateArrayByK byK = new RotateArrayByK();
        int[] nums = {1,2,3,4,5,6,7};

        byK.rotate(nums,3);
        //byK.rotateByKSwap(nums,3);
        byK.rotateByKSwap(nums,18);
    }
}
