package com.test.dynamicprogramming;

public class Knapsack01 {


    private int getMostValuedItems(int[] weight, int[] value, int totalWeight, int size) {
        // BC
        if(totalWeight == 0 ||size == 0){
            return 0;
        }

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

        if(weight[size-1] <= totalWeight){
           return Math.max(value[size-1]+getMostValuedItems(weight,value,totalWeight-weight[size-1],size-1),
                    getMostValuedItems(weight,value,totalWeight,size-1));
        } else if(weight[size-1] > totalWeight){
            return getMostValuedItems(weight,value,totalWeight,size-1);
        }
        return 0;
    }

    public static void main(String[] args) {
        Knapsack01 knapsack01 = new Knapsack01();
        int weight[] = {1,3,4,5};
        int value[] = {1,4,5,7};
        int derivedValue =  knapsack01.getMostValuedItems(weight,value,7,4);
        System.out.println(derivedValue);
    }


}
