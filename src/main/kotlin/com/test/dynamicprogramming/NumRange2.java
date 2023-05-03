package com.test.dynamicprogramming;

public class NumRange2 {

    int[] tree;
    int n;
    public NumRange2(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        NumRange2 range = new NumRange2(nums);
       // System.out.println(range.sumRange(1,3));
       // range.update(2,5);
     //   System.out.println(range.sumRange(1,3));
    }
}
