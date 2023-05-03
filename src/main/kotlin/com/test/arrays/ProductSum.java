package com.test.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static int productSum(List<Object> array) {
        // Write your code here.
        int sum=0,multiplier=1;
        return solveIt(array,sum,multiplier);
    }

    private static int solveIt(List<Object> array, int sum, int multiplier) {
//        // BC
//        if(index == array.size())
//            return sum;

        // Hypo & Choices
        for (int idx = 0; idx < array.size(); idx++) {
            Object object  = array.get(idx);
            if(object instanceof ArrayList ){
                sum = sum+solveIt((List<Object>) object,0,multiplier+1);
            } else {
                Integer integer = (Integer) object;
                sum = sum+integer;
            }

        }
        int totalSum =  sum*multiplier;
        return totalSum;
    }

    public static void main(String[] args) {
        List<Object> test =
                new ArrayList<Object>(
                        Arrays.asList(
                                5,
                                2,
                                new ArrayList<Object>(Arrays.asList(7, -1)),
                                3,
                                new ArrayList<Object>(
                                        Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
       // Utils.assertTrue(Program.productSum(test) == 12);
        System.out.println(ProductSum.productSum(test));
    }
}
