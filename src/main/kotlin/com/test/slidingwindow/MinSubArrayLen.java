package com.test.slidingwindow;

public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int start =0;
        int end =0;
        int wSum=0;
        int minNumbers =1000000;

        while (end < nums.length && start < nums.length){
            wSum = wSum+ nums[end];
            if(wSum>=s){
                wSum = wSum - nums[start] - nums[end];// check
                minNumbers = Math.min(minNumbers,end-start+1);
                start++;
            } else {
                end++;
            }


        }
        return minNumbers == 1000000 ? 0 : minNumbers;

    }

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,2,4,3};
        int  minNumbers;
        MinSubArrayLen arrayLen = new MinSubArrayLen();
        minNumbers = arrayLen.minSubArrayLen(7,nums1);
        System.out.println(minNumbers);
        int[] nums2 = {1, 4, 45, 6, 0, 19};
        minNumbers = arrayLen.minSubArrayLen(51,nums2);
        System.out.println(minNumbers);

        int[] nums3 = {11, 10, 5, 2, 7};
        minNumbers = arrayLen.minSubArrayLen(9,nums3);
        System.out.println(minNumbers);

        int[] nums4 = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        minNumbers = arrayLen.minSubArrayLen(280,nums4);
        System.out.println(minNumbers);

        int[] nums5 = {1, 2, 4};
        minNumbers = arrayLen.minSubArrayLen(8,nums5);
        System.out.println(minNumbers);
    }
}
