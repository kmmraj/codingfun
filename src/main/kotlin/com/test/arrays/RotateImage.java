package com.test.arrays;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {

        int start =0;
        int end = matrix.length-1;

        while (start<end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }

        for (int idx = 0; idx <= matrix.length-1; idx++) {
            for (int jdx = idx+1; jdx <= matrix[idx].length-1; jdx++){
                int temp = matrix[idx][jdx];
                matrix[idx][jdx] = matrix[jdx][idx];
                matrix[jdx][idx] = temp;
            }
        }

        for (int idx = 0; idx <= matrix.length - 1; idx++) {
            for (int jdx = 0; jdx <= matrix[idx].length - 1; jdx++) {
                System.out.printf("%2d ",matrix[idx][jdx]);
            }
            System.out.println();
        }

    }


   private static boolean rotateMatrix(int[][] matrix) {

        int start = 0;
        int end = matrix.length-1;

        // Swap the rows
        while(start < end) {
            int[] temp = matrix[end];
            matrix[end] = matrix[start];
            matrix[start] = temp;
            start++;
            end--;
        }

        // Swap the columns

        for (int idx=0; idx <= matrix.length-1 ; idx++)  {
            for(int jdx=idx; jdx <= matrix[idx].length-1; jdx++) {
                int temp = matrix[idx] [jdx];
                matrix[idx][jdx] = matrix[jdx][idx];
                matrix[jdx][idx] = temp;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        RotateImage image = new RotateImage();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        //image.rotate(matrix);
        RotateImage.rotateMatrix(matrix);

        for (int idx = 0; idx <= matrix.length - 1; idx++) {
            for (int jdx = 0; jdx <= matrix[idx].length - 1; jdx++) {
                System.out.printf("%2d ",matrix[idx][jdx]);
            }
            System.out.println();
        }


        System.out.println(Arrays.deepToString(matrix));
    }
}
