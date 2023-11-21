package com.test.dynamicprogramming;
// https://leetcode.com/problems/coin-change/
// https://www.youtube.com/watch?v=jgiZlGzXMBw
//Example 1:
//
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
//Example 2:
//
//Input: coins = [2], amount = 3
//Output: -1
//Example 3:
//
//Input: coins = [1], amount = 0
//Output: 0

public class CoinChange1 {

    public static int coinChange(int[] coins, int amount) {

        int [][] dp = new int[coins.length+1][amount+1];
        // Init
        for (int i = 0; i < coins.length+1; i++) {
            for (int j = 0; j < amount+1; j++) {
                if(i==0)
                    dp[i][j] = Integer.MAX_VALUE-1;
                if(j==0)
                    dp[i][j] = 0;
            }
        }

        printMatrix(dp,coins.length+1,amount+1);
        // Second Init
        for (int j = 1; j < amount+1; j++) {
            if(j % coins[0] == 0) {
                dp[1][j] = j/coins[0] ;
            } else {
                dp[1][j] =  Integer.MAX_VALUE-1;
            }
        }
        printMatrix(dp,coins.length+1,amount+1);

        for (int indexI = 2; indexI < coins.length+1; indexI++) {
            for (int indexJ = 1; indexJ < amount+1; indexJ++) {
                if(coins[indexI-1] <= indexJ){ // AA-- coins[indexI-1]
                    dp[indexI][indexJ] = Math.min(1+dp[indexI][indexJ - coins[indexI-1]], // AA --coins[indexI-1]
                            dp[indexI-1][indexJ]);
                } else {
                    dp[indexI][indexJ] =  dp[indexI-1][indexJ];
                }
            }

        }
        printMatrix(dp,coins.length+1,amount+1);
        return dp[coins.length][amount];
    }

    private static void printMatrix(int[][] dp, int xLength, int yLength){
        System.out.println("---------xxx---------------");
        for (int xAx = 0; xAx < xLength; xAx++) {
            for (int yAx = 0; yAx < yLength; yAx++) {
                System.out.printf("%11d, ", dp[xAx][yAx]);
            }
            System.out.println();
        }
        System.out.println("---------xxx---------------");
    }

    public static void main(String[] args) {
        //Input: coins = [1,2,5], amount = 11
        //Output: 3
        int [] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }
}
