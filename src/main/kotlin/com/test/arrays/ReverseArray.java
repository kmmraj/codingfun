package com.test.arrays;

import java.util.Arrays;

public class ReverseArray {


    private static int[] reverse(int[] nums){

        int start = 0;
        int end = nums.length-1;
        while (start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] =temp;
            start++;
            end--;
        }
        return nums;
    }

    public static void main(String[] args) {
        final int[] nums = {1,2,3,4,5,6};
        final int[] reversedNums = reverse(nums);
//        System.out.println(Arrays.deepToString(reversedNums));
        for (int idx=0; idx<=reversedNums.length-1; idx++){
            System.out.print(reversedNums[idx]+", ");
        }
    }
}
