package com.test.dynamicprogramming;

public class CountOfSubsetsSumWithAGivenSum {

    public int getSubsetCountMatching(int sum, int[] nums){

        int[][] dp = new int[nums.length+1][sum+1];
        for (int indexJ = 0; indexJ < sum+1; indexJ++) {
            dp[0][indexJ] = 0;
        }
        for (int indexI = 0; indexI < nums.length+1; indexI++) {
            dp[indexI][0] = 1;
        }

        printMatrix(dp,nums.length+1,sum+1);

        for (int indexI = 1; indexI < nums.length+1; indexI++) {
            for (int indexJ = 1; indexJ < sum + 1; indexJ++) {
                if(nums[indexI-1] <= indexJ){
                    dp[indexI][indexJ] = dp[indexI-1][indexJ-nums[indexI-1]] +
                            dp[indexI-1][indexJ];
                } else {
                    dp[indexI][indexJ] = dp[indexI-1][indexJ];
                }

            }
        }

        printMatrix(dp,nums.length+1,sum+1);

        return dp[nums.length][sum];

    }
    public static void main(String[] args) {
        CountOfSubsetsSumWithAGivenSum sumWithAGivenSum = new CountOfSubsetsSumWithAGivenSum();
        int[] nums = {1,2,3,3};
        System.out.println( sumWithAGivenSum.getSubsetCountMatching(6,nums));
    }

    private void printMatrix(int [][] dp, int xSize,int ySize){
        System.out.println("-----------XXXXXXX-0000-XXXXXX-------------");
        for (int indexI = 0; indexI < xSize; indexI++) {
            for (int indexJ = 0; indexJ < ySize; indexJ++) {
                System.out.printf("%d, ",dp[indexI][indexJ]);
            }
            System.out.println();
        }
        System.out.println("-----------0000000-xxxx-0000000-------------");
    }
}
