package com.test.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum =0;

        for (int index = 0; index < nums.length; index++) {
            sum +=nums[index];
        }
        if(!(sum%2==0)) {
            return false;
        }  else {
            int partitionSum = sum/2;
            boolean dp[][] = new boolean[nums.length+1][partitionSum+1];
            //BC
            for (int indexJ = 0; indexJ < partitionSum+1; indexJ++) {
                dp[0][indexJ] = false;
            }
            for (int indexI = 0; indexI < nums.length+1; indexI++) {
                dp[indexI][0] = true;
            }

//            printMatrix(nums,partitionSum,dp);
//            System.out.println("-----------");


            //  Induction
            for (int indexI = 1; indexI < nums.length+1; indexI++) {
                for (int indexJ = 1; indexJ < partitionSum+1; indexJ++) {
                    if(nums[indexI-1] <=  indexJ){
                        dp[indexI][indexJ] = dp[indexI-1][indexJ-nums[indexI-1]] || dp[indexI-1][indexJ];
                    } else {
                        dp[indexI][indexJ] = dp[indexI-1][indexJ];
                    }
                }
            }

//            printMatrix(nums,partitionSum,dp);
//            System.out.println("-----------");
            return dp[nums.length][partitionSum];
        }

    }

    private void printMatrix(int[] candidates, int target,boolean [][]dp){
        for (int indexI = 0; indexI < candidates.length+1; indexI++) {
            for (int indexJ = 0; indexJ < target+1; indexJ++) {
                System.out.printf("%s, ",dp[indexI][indexJ]?"T":"F");
            }
            System.out.println();
        }
    }

    public boolean canPartitionByBackTrack(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int index = 0;
        List<Integer> ansList = new ArrayList<>();

        boolean canPartition = ((sum&1) == 0) && solveItBackTracking(nums,sum/2,index,ansList);
        for (int ans: ansList) {
            System.out.printf("%2d",ans);
        }
        System.out.println();
        return canPartition;

    }

    private boolean solveItBackTracking(int[] nums, int sum, int index, List<Integer> ansList) {
        // BC
        if(sum < 0 || index >= nums.length)
            return false;
        if(sum == 0)
            return true;

        // Hypothesis & Choices
        ansList.add(nums[index]);
        boolean choiceOne = solveItBackTracking(nums,sum-nums[index],index+1,ansList);

        // Backtrack
        if(choiceOne == false){
            ansList.remove(ansList.size()-1);
            boolean choiceTwo = solveItBackTracking(nums,sum,index+1,ansList);
            return choiceTwo;
        } else {
            return choiceOne;
        }

    }


    public static void main(String[] args) {
        PartitionEqualSubsetSum subsetSum = new PartitionEqualSubsetSum();
        int[] nums = {1,5,11,5};
        System.out.println(subsetSum.canPartition(nums));

        int[] nums1 = {1,4,4,5};
        System.out.println(subsetSum.canPartition(nums1));
        System.out.println(subsetSum.canPartitionByBackTrack(nums));
    }
}
