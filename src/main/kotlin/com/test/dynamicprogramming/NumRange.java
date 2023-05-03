package com.test.dynamicprogramming;

public class NumRange {

    int[] cache;
    int[] nums;
    public NumRange(int[] nums) {
        this.nums = nums;
        this.cache = new int[nums.length+1];
        //printRange(this.cache);
        for (int idxI = 1; idxI <= nums.length; idxI++) {
            this.cache[idxI] = this.cache[idxI-1]+nums[idxI-1];
        }

        printRange(this.cache);
    }

    public int sumRange(int i, int j) {
        return this.cache[j+1]-this.cache[i];
    }

    public void update(int i, int val) {
        this.nums[i]=val;
        for (int idxI = i+1; idxI <= this.nums.length; idxI++) {
            this.cache[idxI] = this.cache[idxI-1]+nums[idxI-1];
        }
        printRange(this.cache);

    }
    private void printRange(int [] cache){

        for (int idx = 0; idx < cache.length; idx++) {
            System.out.printf("%4d ",idx);
        }
        System.out.println();
        System.out.println("-----------------------------------------------");
        for (int idx = 0; idx < cache.length; idx++) {
            System.out.printf("%4d ",cache[idx]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        NumRange range = new NumRange(nums);
        System.out.println(range.sumRange(1,3));
        range.update(2,5);
        System.out.println(range.sumRange(1,3));
    }
}
