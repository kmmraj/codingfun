package com.test.dynamicprogramming;

public class Knapsack01WithTopDownTry {

    int[][] dp;

    public Knapsack01WithTopDownTry(int totalWeight, int size) {
        this.dp = new int [size+1][totalWeight+1];

        for (int indexI = 0; indexI < size+1; indexI++) {
            for (int indexJ = 0; indexJ < totalWeight+1; indexJ++) {
                if(indexI==0 || indexJ ==0)
                    dp[indexI][indexJ] =0;
            }
        }
    }

    private int getMostValuedItems(int[] weight, int[] value, int totalWeight, int size) {


        // Hypothesis and Induction
        // 3 choices you have
        // Choice 1 : weight[size-1] <= total weight and you include the item by value[size-1]+ and reduce the weight, call mext item
        // Choice 2 : weight[size-1] <= total weight and you DONOT include the item, call the next item
        // Choice 3:  weight[size-1] > total weight and you CANNOT include the item
        // Why Max -- we want to maximize the value between choice 1 and choice 2 (one includes and one doesn't)

        //                        weight[size-1]: value[size-1]
        //                                      /\
        //                                     /  \
        //                                    /    \
        //         weight[size-1] <= totalWeight   weight[size-1] > totalWeight
        //                   /\                                   |
        //                  /  \                                  |
        //                 /    \                                 |
        //            Include  DON'T Include                  Call next item
        //                |           |
        //                |           |
        //                |           |
        //     Add value and        Call next item
        //     reduce weight             |
        //     Call next item            |
        //           |                   |
        //           |                   |
        //           |___________________|
        //                    |
        //         Max Value of above choices

        for (int indexI = 1; indexI < size+1; indexI++) {
            for (int indexJ = 1; indexJ < totalWeight+1; indexJ++) {

                if(weight[indexI-1] <=  indexJ){
                    dp[indexI][indexJ] = Math.max(
                       value[indexI-1] + dp[indexI-1][indexJ - weight[indexI-1]],
                       dp[indexI-1][indexJ]);
                } else {
                    dp[indexI][indexJ] = dp[indexI-1][indexJ];
                }
            }
        }

        for (int i = 0; i < size+1; i++) {
            for (int j = 0; j < totalWeight+1; j++) {
                System.out.printf("%d, ",dp[i][j]);
            }
            System.out.printf("\n");
        }
        return dp[size][totalWeight];
    }


        public static void main(String[] args) {
        Knapsack01WithTopDownTry knapsack01 = new Knapsack01WithTopDownTry(7,4);
        int weight[] = {1,3,4,5};
        int value[] =  {1,4,5,7};
        int derivedValue =  knapsack01.getMostValuedItems(weight,value,7,4);
        System.out.printf("\n");
        System.out.println(derivedValue);
    }


}
