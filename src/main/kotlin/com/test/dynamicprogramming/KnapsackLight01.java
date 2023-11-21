package com.test.dynamicprogramming;
//You found two items in a treasure chest! The first item weighs weight1 and is worth value1, and the second item weighs weight2 and is worth value2. What is the total maximum value of the items you can take with you, assuming that your max weight capacity is maxW and you can't come back for the items later?
//
//Note that there are only two items and you can't bring more than one item of each type, i.e. you can't take two first items or two second items.
//
//Example
//
//For value1 = 10, weight1 = 5, value2 = 6, weight2 = 4, and maxW = 8, the output should be
//solution(value1, weight1, value2, weight2, maxW) = 10.
//
//You can only carry the first item.
//
//For value1 = 10, weight1 = 5, value2 = 6, weight2 = 4, and maxW = 9, the output should be
//solution(value1, weight1, value2, weight2, maxW) = 16.
//
//You're strong enough to take both of the items with you.
//
//For value1 = 5, weight1 = 3, value2 = 7, weight2 = 4, and maxW = 6, the output should be
//solution(value1, weight1, value2, weight2, maxW) = 7.
//
//You can't take both items, but you can take any of them.
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] integer value1
//
//Guaranteed constraints:
//2 ≤ value1 ≤ 20.
//
//[input] integer weight1
//
//Guaranteed constraints:
//2 ≤ weight1 ≤ 10.
//
//[input] integer value2
//
//Guaranteed constraints:
//2 ≤ value2 ≤ 20.
//
//[input] integer weight2
//
//Guaranteed constraints:
//2 ≤ weight2 ≤ 10.
//
//[input] integer maxW
//
//Guaranteed constraints:
//1 ≤ maxW ≤ 20.
//
//[output] integer
public class KnapsackLight01 {
    int solution(int value1, int weight1, int value2, int weight2, int maxW) {
        int maxValue = 0;

        int[] value = new int[]{value1, value2};
        int[] weight = new int[]{weight1, weight2};

        // return solveItKnapSack(weight.length,value,weight,maxW,maxValue);
        if(weight1 + weight2 <= maxW){
            return value1 + value2;
        } else if(weight1 <= maxW && weight2 <= maxW){
            return Math.max(value1,value2);
        } else if(weight1 <= maxW){
            return value1;
        }else if(weight2 <= maxW){
            return value2;
        }
        return 0;
    }
    // if(weight[size-1] <= totalWeight){
// // return Math.max(value[size-1]+getMostValuedItems(weight,value,totalWeight-weight[size-1],size-1),
//                     getMostValuedItems(weight,value,totalWeight,size-1));
//         } else if(weight[size-1] > totalWeight){
//             return getMostValuedItems(weight,value,totalWeight,size-1);
//         }
    int solveItKnapSack(int size,int [] value,int [] weight,int maxW,int maxValue){
        // BC
        if(size == 0){
            return maxValue;
        }

        // H& I
        if(weight[size-1] <= maxW){
            return Math.max(value[size-1] + solveItKnapSack(size-1,value,weight,maxW -value[size-1], maxValue),
                    solveItKnapSack(size-1,value,weight,maxW, maxValue));
        } else if(weight[size-1] > maxW){
            return solveItKnapSack(size-1,value,weight,maxW, maxValue);
        }
        return 0;
    }

    public static void main(String[] args) {
        KnapsackLight01 knapsackLight01 = new KnapsackLight01();
        int value1 = 10;
        int weight1 = 5;
        int value2 = 6;
        int weight2 = 4;
        int maxW = 8;
        int maxValue = knapsackLight01.solution(value1,weight1,value2,weight2,maxW);
        System.out.println("Expected value 10 and the actual is " +maxValue);

        value1 = 10;
        weight1 = 5;
        value2 = 6;
        weight2 = 4;
        maxW = 9;
        maxValue = knapsackLight01.solution(value1,weight1,value2,weight2,maxW);
        System.out.println("Expected value 16 and the actual is " +maxValue);

        value1 = 5;
        weight1 = 3;
        value2 = 7;
        weight2 = 4;
        maxW = 6;
        maxValue = knapsackLight01.solution(value1,weight1,value2,weight2,maxW);
        System.out.println("Expected value 7 and the actual is " +maxValue);
    }
}
