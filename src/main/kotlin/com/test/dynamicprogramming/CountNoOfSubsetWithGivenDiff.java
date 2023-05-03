package com.test.dynamicprogramming;

import java.util.Arrays;

public class CountNoOfSubsetWithGivenDiff {

    int[][] dpMemoized;

    public CountNoOfSubsetWithGivenDiff() {

        this.dpMemoized = new int[1000][1000];
        for (int i = 0; i < 1000; i++) {
            Arrays.fill(dpMemoized[i],Integer.MAX_VALUE);
        }
    }

    public int getCountForWithDiff(int[] nums, int diff){

        int sum = getSum(nums);
        // s1 - s2 = diff  --- A
        // s1 + s2 = sum   --- B
        // -------------- (A+B)
        // 2s1 = diff+sum
        // s1 = diff+sum/2


        int sumS1 = (diff+sum)/2;
        System.out.println("sumS1 is: "+sumS1);

       int[][] dp = new  int[nums.length+1][sumS1+1];

        for (int xAx = 0; xAx < sumS1+1; xAx++) {
            dp[0][xAx]=0;
        }
        for (int yAx = 0; yAx < nums.length+1; yAx++) {
            dp[yAx][0]=1;
        }

        printMatrix(dp,nums.length+1, sumS1+1);


       calculateCount(nums, sumS1, dp);
       printMatrix(dp,nums.length+1, sumS1+1);

       return dp[nums.length][sumS1];
    }

    private void calculateCount(int[] nums, int sumS1, int[][] dp) {
        for (int indexI = 1; indexI < nums.length+1; indexI++) {
            for (int indexJ = 1; indexJ < sumS1+1; indexJ++) {
                if(nums[indexI-1] <=indexJ){
                    dp[indexI][indexJ] = dp[indexI-1][indexJ-nums[indexI-1]]
                            + dp[indexI-1][indexJ];
                } else {
                    dp[indexI][indexJ] =dp[indexI-1][indexJ];
                }

            }
        }
    }

    int getSum(int[] nums){
        int sum =0;
        for (int idx = 0; idx < nums.length; idx++) {
            sum = sum+nums[idx];
        }
        return sum;
    }

    private void printMatrix(int[][] dp, int xLength, int yLength){
        System.out.println("---------xxx---------------");
        for (int xAx = 0; xAx < xLength; xAx++) {
            for (int yAx = 0; yAx < yLength; yAx++) {
                System.out.printf("%d  ,", dp[xAx][yAx]);
            }
            System.out.println();
        }
        System.out.println("---------xxx---------------");
    }

    public int getCountForWithDiffRecursion(int[] nums, int diff){

       int sum = getSum(nums);
       int s1Sum = (diff+sum)/2;

        if(diff > sum)
            return 0;
        if((diff+sum)%2!=0)
            return 0;

       return solveIt(nums,0,0,s1Sum,0);

    }

    int solveIt(int[] nums,int index,int workingSum,int setOneSum,int count){
       // BC

        if(index == nums.length){
            // Why here ? This is NOT many subsets, only 2 subsets of equal count but with diff
            // you need to reach the end
            if(workingSum == setOneSum){
                count = count+1;
            }
            return count;
        }

        return solveIt(nums,index+1,workingSum+nums[index],setOneSum,count)
       + solveIt(nums,index+1,workingSum,setOneSum,count);
    }

    int solveItMemoized(int[] nums,int index,int workingSum,int setOneSum,int count){
        // BC

        if(index == nums.length){
            // Why here ? This is NOT many subsets, only 2 subsets of equal count but with diff
            // you need to reach the end
            if(workingSum == setOneSum){
                count = count+1;
            }
            return count;
        }


        if(dpMemoized[index][workingSum+nums[index]] != Integer.MIN_VALUE){
            dpMemoized[index][workingSum+nums[index]] = solveIt(nums,index+1,workingSum+nums[index],setOneSum,count);
        }

        if(dpMemoized[index][workingSum] != Integer.MIN_VALUE){
            dpMemoized[index][workingSum] = solveIt(nums,index+1,workingSum,setOneSum,count);
        }
        // Hypo & Induction
        return  dpMemoized[index][workingSum+nums[index]]
                +  dpMemoized[index][workingSum];
    }


    public static void main(String[] args) {
        CountNoOfSubsetWithGivenDiff count = new CountNoOfSubsetWithGivenDiff();
        int[] nums = {1,1,2,3};
        System.out.println(count.getCountForWithDiff(nums,1));
        System.out.println(count.getCountForWithDiffRecursion(nums,1));

        int[] nums2 = {1,2,3,5};
        System.out.println(count.getCountForWithDiff(nums2,1));
        System.out.println(count.getCountForWithDiffRecursion(nums2,1));

        int[] nums3 = {7,9,3,8,0,2,4,8,3,9};
        System.out.println(count.getCountForWithDiff(nums3,0));
        System.out.println(count.getCountForWithDiffRecursion(nums3,0));
    }
}
