package com.test.matrixtraversal;
//Given a rectangular matrix containing only digits, calculate the number of different 2 × 2 squares in it.
//
//Example
//
//For
//
//matrix = [[1, 2, 1],
//          [2, 2, 2],
//          [2, 2, 2],
//          [1, 2, 3],
//          [2, 2, 1]]
//the output should be
//solution(matrix) = 6.
//
//Here are all 6 different 2 × 2 squares:
//
//1 2
//2 2
//2 1
//2 2
//2 2
//2 2
//2 2
//1 2
//2 2
//2 3
//2 3
//2 1
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] array.array.integer matrix
//
//Guaranteed constraints:
//1 ≤ matrix.length ≤ 100,
//1 ≤ matrix[i].length ≤ 100,
//0 ≤ matrix[i][j] ≤ 9.
//
//[output] integer
//
//The number of different 2 × 2 squares in matrix.

import java.util.HashSet;
import java.util.Set;

public class DifferentSquares {

    int solution(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        if (row < 2 || col < 2) {
            return 0;
        }

        Set<String> numSet = new HashSet<>();
        for (int idx = 0; idx < matrix.length - 1; idx++) {
            for (int jdx = 0; jdx < matrix[idx].length - 1; jdx++) {
                //  System.out.println(matrix[idx][jdx] + " , " + matrix[idx][jdx+1] + " , " +matrix[idx+1][jdx] + " , "+ matrix[idx+1][jdx+1]);
                numSet.add(matrix[idx][jdx] + " , " + matrix[idx][jdx + 1] + " , " + matrix[idx + 1][jdx] + " , " + matrix[idx + 1][jdx + 1]);
            }
        }
        return numSet.size();

    }

    public static void main(String[] args) {
        System.out.println("The value should be 6 and the actual value is: "
                + new DifferentSquares().solution(new int[][]{{1, 2, 1}, {2, 2, 2}, {2, 2, 2}, {1, 2, 3}, {2, 2, 1}}));
        System.out.println("The value should be 1 and the actual value is : "
                + new DifferentSquares().solution(new int[][]{
                {9, 9, 9, 9, 9},
                {9, 9, 9, 9, 9},
                {9, 9, 9, 9, 9},
                {9, 9, 9, 9, 9},
                {9, 9, 9, 9, 9},
                {9, 9, 9, 9, 9}}));


    }
}
