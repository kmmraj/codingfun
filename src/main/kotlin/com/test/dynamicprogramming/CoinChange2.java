package com.test.dynamicprogramming;

public class CoinChange2 {
    static int[][] dp;
    public static int change(int amount, int[] coins) {

      dp = new int[coins.length+1][amount+1];
        for (int i = 0; i < coins.length+1; i++) {
            for (int j = 0; j < amount+1; j++) {
                if(i==0 ){
                    dp[i][j] =0;
                }
                if(j==0){
                    dp[i][j] =1;
                }
            }
        }
        printMatrix(dp,coins.length+1,amount+1);

        for (int indexI = 1; indexI < coins.length+1; indexI++) {
            for (int indexJ = 1; indexJ < amount+1; indexJ++) {
                if(coins[indexI-1] <= indexJ){
                    //coins[indexI-1]
                    dp[indexI][indexJ] = dp[indexI][indexJ-coins[indexI-1]]
                    + dp[indexI-1][indexJ];
                } else {
                    dp[indexI][indexJ] = dp[indexI-1][indexJ];
                }
            }
        }
        printMatrix(dp,coins.length+1,amount+1);

        return dp[coins.length][amount];
    }

    // TODO : Try recursion

    public static int changeRec(int amount, int[] coins) {
        int index =0;
        return solveItRec(amount,coins,index);
    }

    private static int solveItRec(int amount, int[] coins, int index) {
        // BC
        if(amount <0)
            return 0;
        if(amount == 0) // Matching
            return 1;
        if(coins.length ==index && amount >0) // we reached the end and amount is greater than zero, non matching
            return 0;

        // Induction + Hypo

        // Include and Reduce from the  total
        // don't include and don't reduce from the total
        // Here we are just counting the possibilities
        return solveItRec(amount-coins[index],coins,index)
                + solveItRec(amount,coins,index+1);

    }


    private static void printMatrix(int[][] dp, int xLength, int yLength){
        System.out.println("---------xxx---------------");
        for (int xAx = 0; xAx < xLength; xAx++) {
            for (int yAx = 0; yAx < yLength; yAx++) {
                System.out.printf("%d  ,", dp[xAx][yAx]);
            }
            System.out.println();
        }
        System.out.println("---------xxx---------------");
    }
    public static void main(String[] args) {
        int [] coins = {1, 2, 3};
        int amount = 5;
        System.out.println(CoinChange2.change(amount,coins));
        System.out.println(CoinChange2.changeRec(amount,coins));
    }
}
