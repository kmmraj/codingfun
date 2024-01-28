package com.test.arrays;
//https://leetcode.com/problems/pascals-triangle-ii/description/

//119. Pascal's Triangle II
//Easy
//4.7K
//329
//Companies
//Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//
//
//
//Example 1:
//
//Input: rowIndex = 3
//Output: [1,3,3,1]
//Example 2:
//
//Input: rowIndex = 0
//Output: [1]
//Example 3:
//
//Input: rowIndex = 1
//Output: [1,1]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {

        /*
                1
               1 1
              1 2 1
             1 3 3 1
            1 4 6 4 1

        */
        // Option#1
        int[] resultArray = new int[rowIndex+1];
        Arrays.fill(resultArray,1);
        for(int idx=0;idx<=rowIndex;idx++){
            for(int jdx=idx-1;jdx>0;jdx--){
                resultArray[jdx] = resultArray[jdx] + resultArray[jdx-1];
            }
        }
        return Arrays.stream(resultArray).boxed().toList();

        // Option#2

        //List<Integer> resultList = new ArrayList<>();

        //   for(int idx=0;idx<=rowIndex;idx++){
        //       resultList.add(1);
        //       for(int jdx=idx-1;jdx>0;jdx--){
        //           resultList.set(jdx,resultList.get(jdx-1)+resultList.get(jdx));
        //     }
        //   }

        //return resultList;
    }

    public static void main(String[] args) {
        PascalTriangle2 pascalTriangle = new PascalTriangle2();
        System.out.println("pascalTriangle.getRow(5) = " + pascalTriangle.getRow(5));
        System.out.println("pascalTriangle.getRow(6) = " + pascalTriangle.getRow(6));
        System.out.println("pascalTriangle.getRow(7) = " + pascalTriangle.getRow(7));
        System.out.println("pascalTriangle.getRow(8) = " + pascalTriangle.getRow(8));
        System.out.println("pascalTriangle.getRow(9) = " + pascalTriangle.getRow(9));
    }
}
