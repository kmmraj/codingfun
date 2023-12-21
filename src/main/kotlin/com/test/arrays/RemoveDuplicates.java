package com.test.arrays;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        int slowPtr=0;
        for(int fastPtr=1; fastPtr<nums.length; fastPtr++){
            if(nums[slowPtr] != nums[fastPtr]){
                slowPtr++;
                nums[slowPtr]=nums[fastPtr];
            }
        }
        return slowPtr+1;
    }

    public int remove2Duplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        int slowPtr=0;
        int dupsCount = 1;
        int totalDupsCount = 0;
        int skipCount=0;
        for(int fastPtr=1; fastPtr<nums.length; fastPtr++){

            if(nums[fastPtr-1] != nums[fastPtr]){
                nums[slowPtr] = nums[fastPtr];
                slowPtr++;
                dupsCount = 1;
            } else {
                skipCount++;
                if(dupsCount < 2){
                    totalDupsCount++;
                    dupsCount++;
                } else {

                    slowPtr = slowPtr+2; // check this
                    int idx = fastPtr+1;
                    while (idx  < nums.length){
                        nums[idx-1] = nums[idx];
                        idx++;
                    }

                    dupsCount = 1;
                }
            }
        }
        return slowPtr+1;
    }

    public int removeKDuplicates(int[] nums) {
        //define at most k times of duplicate numbers
        final int k = 2;

        //check if it is an empty array
        if(nums.length == 0) return 0;

        //start pointer of new array
        int m = 1;

        // count the time of duplicate numbers occurrence
        int count = 1;

        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] == nums[i - 1]) {
                if(count < k) {
                    nums[m++] = nums[i];
                }
                count++;
            } else {
                count = 1;
                nums[m++] = nums[i];
            }
        }
        return m;
    }

    class Solution {
        public int removeDuplicates(int[] nums) {

            if(nums.length < 2){
                return nums.length;
            }
            int index = 2;
            //[0,0,1,1,1,1,2,3,3]
            for(int idx = 2; idx < nums.length;idx++){
                if(nums[idx]!= nums[index-2]){
                    nums[index] = nums[idx];
                    index++;
                }
            }
            return index;
        }
    }

    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,2,3,3,3};
        RemoveDuplicates duplicates = new RemoveDuplicates();
        System.out.println(duplicates.removeKDuplicates(nums));
    }
}
