package com.test.binarysearch;

// https://leetcode.com/problems/search-a-2d-matrix/

import java.util.Arrays;

//You are given an m x n integer matrix matrix with the following two properties:
//
//Each row is sorted in non-decreasing order.
//The first integer of each row is greater than the last integer of the previous row.
//Given an integer target, return true if target is in matrix or false otherwise.
//
//You must write a solution in O(log(m * n)) time complexity.
//
//
//
//Example 1:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
//Example 2:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
//
//
//Constraints:
//
//m == matrix.length
//n == matrix[i].length
//1 <= m, n <= 100
//-104 <= matrix[i][j], target <= 104
public class FindMatrix {


    public boolean searchMatrixFlatMatrix(int[][] matrix, int target) {
        int start =0, rows=matrix.length, cols = matrix[0].length;
        // Flat the Matrix
        int end = (rows*cols) - 1;
        System.out.println("target " + target +" start " + start + " end " + end
                +" cols "+cols +" rows "+rows
                +" in array " + Arrays.deepToString(matrix));
        while(start <= end){
            int middle = (start + end) / 2;
            System.out.println("target " + target +" start " + start + " end " + end
                    +" middle "+middle +" in array " + Arrays.toString(matrix[middle/cols]));
            System.out.println("middle/cols " + middle/cols +" middle%cols " + middle%cols
                    +" matrix[middle/cols][middle%cols] " + matrix[middle/cols][middle%cols]);
            if(target == matrix[middle/cols][middle%cols]){
                return true;
            }
            if(target < matrix[middle/cols][middle%cols]){
                end = middle-1;
            }else{
                start = middle+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length-1;
        while(start <= end){
            int middle = (start + end) / 2;
            // System.out.println("target " + target +" start " + start + " end " + end +" middle "+middle +" in array " + Arrays.toString(matrix[middle]));
            if(matrix[middle][0]<= target && matrix[middle][matrix[middle].length-1] >=target){
                //  System.out.println(" Reached the target " + target + " in array " + Arrays.toString(matrix[middle]));
                return findNumber(matrix[middle], target);
            } else if(matrix[middle][0] > target && matrix[middle][matrix[middle].length-1] >target) {
                end = middle -1;
            } else {
                start = middle + 1;
            }
        }
        return false;
    }

    private boolean findNumberDW(int [] matrixRow, int target){
        int start = 0, end = matrixRow.length-1;
        System.out.println(" findNumber target " + target +" start " + start + " end " + end +" in array " + Arrays.toString(matrixRow));
        while(start <= end){
            int middle = (start + end) / 2;
            System.out.println(" findNumber middle " + middle);
            if (matrixRow[middle] > target){
                end = middle - 1;
            } else{
                start = middle + 1;
            }
            if(matrixRow[middle] == target){
                return true;
            }
            // System.out.println(" findNumber middle " + middle +" start " + start + " end " + end );
        }
        return false;
    }

    private boolean findNumber(int[] nums, int target){
        int start = 0, end = nums.length-1;
        while (start <= end){
            int middle = (end + start)/2;
            if(nums[middle] < target) {
                start = middle+1;
            } else {
                end = middle-1;
            }

            if(nums[middle] == target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindMatrix findMatrix = new FindMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println("Should be true " + findMatrix.searchMatrixFlatMatrix(matrix,3));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,13));
//        System.out.println("Should be true " + findMatrix.searchMatrix(matrix,1));
//        System.out.println("Should be true " + findMatrix.searchMatrix(matrix,7));
//        System.out.println("Should be true " + findMatrix.searchMatrix(matrix,10));
//        System.out.println("Should be true " + findMatrix.searchMatrix(matrix,20));
//        System.out.println("Should be true " + findMatrix.searchMatrix(matrix,23));
//        System.out.println("Should be true " + findMatrix.searchMatrix(matrix,30));
//        System.out.println("Should be true " + findMatrix.searchMatrix(matrix,34));
//        System.out.println("Should be true " + findMatrix.searchMatrix(matrix,60));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,0));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,100));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,8));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,9));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,12));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,15));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,19));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,21));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,22));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,29));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,31));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,33));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,35));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,59));
//        System.out.println("Should be false " + findMatrix.searchMatrix(matrix,61));

    }
}
