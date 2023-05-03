package com.test.dynamicprogramming;

import java.util.Arrays;

public class Knapsack01WithTopDown {

    int[][] matrix;

    public Knapsack01WithTopDown(int totalWeight, int size) {
        this.matrix = new int [size+1][totalWeight+1];
        for (int indexI = 0; indexI < size+1; indexI++) {
            for (int indexJ = 0; indexJ < totalWeight+1; indexJ++){
                if(indexI ==0 || indexJ ==0)
                    matrix[indexI][indexJ] =0;
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

                if(weight[indexI-1] <= indexJ){ // AA -- weight[indexI-1]
                    matrix[indexI][indexJ] = Math.max(
                            value[indexI-1] +
                                    matrix[indexI-1][indexJ-weight[indexI-1]],// AA- weight[indexI-1]
                            matrix[indexI-1][indexJ]);

                } else {
                    matrix[indexI][indexJ] =   matrix[indexI-1][indexJ];
                }
            }

        }

        for (int indexI = 0; indexI < size+1; indexI++) {
            for (int indexJ = 0; indexJ < totalWeight + 1; indexJ++) {
                System.out.printf("%d, ",matrix[indexI][indexJ]);
            }
            System.out.printf("\n");
        }
        return  matrix[size][totalWeight];
    }

    public static void main(String[] args) {
        Knapsack01WithTopDown knapsack01 = new Knapsack01WithTopDown(7,4);
        int weight[] = {1,3,4,5};
        int value[] =  {1,4,5,7};
        int derivedValue =  knapsack01.getMostValuedItems(weight,value,7,4);
        System.out.printf("\n");
        System.out.println(derivedValue);
    }
}
