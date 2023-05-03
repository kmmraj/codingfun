package com.test.dynamicprogramming;

public class PartitionMinSumDiffSubset {
    int getSubsetDiffFor(int[] nums){

        int sum =0;
        sum = getSum(nums, sum);
        System.out.println(sum);

        boolean [][] dpB = new boolean[nums.length+1][sum+1];

        //Get the valid subset totals
        for (int j = 0; j < sum+1 ; j++) {
            dpB[0][j]=false;
        }
        for (int i = 0; i < nums.length+1; i++) {
            dpB[i][0]=true;
        }

        for (int indexI = 1; indexI < nums.length+1; indexI++) {
            for (int indexJ = 1; indexJ < sum+1; indexJ++) {
                if(nums[indexI-1] <= indexJ){
                    dpB[indexI][indexJ] = dpB[indexI-1][indexJ - nums[indexI-1]] || dpB[indexI-1] [indexJ];
                } else {
                    dpB[indexI][indexJ] = dpB[indexI-1] [indexJ];
                }
            }
        }

        printMatrix(dpB,nums.length+1,sum+1);

        int[] validSums = new int[(sum+1)/2];
        int index=0;
        for (int validSumIdx = 0; validSumIdx < (sum+1)/2; validSumIdx++) {
            if(dpB[nums.length][validSumIdx]){
                validSums[index++]=validSumIdx;
            }
        }

        printValidSums(validSums);

        int min = Integer.MAX_VALUE;
        for (int idx = 0; idx < validSums.length; idx++) {
            min = Math.min(min,sum-2*validSums[idx]);
        }
        return min;
    }



    private int getSum(int[] nums, int sum) {
        for (int sumIndex = 0; sumIndex < nums.length; sumIndex++) {
           sum = sum+nums[sumIndex];
        }
        return sum;
    }

    private void printValidSums(int[] validSums) {
        for (int idx = 0; idx < validSums.length; idx++) {
            System.out.printf("%d, ",validSums[idx]);
        }
        System.out.println("-----------0000000-xxxx-0000000-------------");
    }

    private void printMatrix(boolean [][] dp, int xSize,int ySize){
        System.out.println("-----------XXXXXXX-0000-XXXXXX-------------");
        for (int indexI = 0; indexI < xSize; indexI++) {
            for (int indexJ = 0; indexJ < ySize; indexJ++) {
                System.out.printf("%s, ",dp[indexI][indexJ]?"T":"F");
            }
            System.out.println();
        }
        System.out.println("-----------0000000-xxxx-0000000-------------");
    }


    // Do it via Recursion
    int getSubsetDiffForRecursion(int[] nums){
        int sum = 0;
        sum = getSum(nums,sum);
        int workingSum=0;
        int index=0;
        return solveIt(nums,sum,workingSum,index);
       // return 0;
    }

    int solveIt(int[] nums,int sum, int workingSum, int index){
        //  BC
        if(nums.length == index){
           return Math.abs((sum - workingSum)-workingSum);
        }

        // Hypo & Induction
        return Math.min(solveIt(nums,sum,workingSum+nums[index],index+1),
                solveIt(nums,sum,workingSum,index+1));

        //return 0;
    }

    public static void main(String[] args) {
        int nums [] = {1, 6, 11, 5};
        PartitionMinSumDiffSubset minSumDiffSubset = new PartitionMinSumDiffSubset();
        System.out.println("-----------0000000-xxxx-0000000-------------");
        System.out.println(minSumDiffSubset.getSubsetDiffFor(nums));
        System.out.println("-----------0000000-RECURSION-0000000-------------");
        System.out.println(minSumDiffSubset.getSubsetDiffForRecursion(nums));

    }
}
