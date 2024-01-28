package com.test.matrixtraversal;

import java.util.Arrays;

public class GenerateSpiralMatrix {
    public int[][] generateMatrix(int n) {
        int startRow=0,startCol=0,endRow=n-1,endCol=n-1, index =1,endIndex=n*n;
        int[][] matrix = new int[n][n];
        while(startRow<=endRow && startCol <=endCol && index<=endIndex){
            // Row L->R
            for(int idx=startCol;idx<=endCol;idx++){
                matrix[startRow][idx]= index++;
            }
            startRow++;
            // Col T->B
            for(int idx=startRow;idx<=endRow;idx++){
                matrix[idx][endCol] = index++;
            }
            endCol--;
            /**
             [[1,2,3],
             [8,9,4],
             [7,6,5]]
             */

            // Row Reverse R->L
            if(startRow<=endRow){
                for(int idx=endCol;idx>=startCol;idx--){
                    matrix[endRow][idx] = index++;
                }
            }

            endRow--;

            //Col Reverse B->T
            if(startCol<=endCol){
                for(int idx=endRow; idx>=startRow;idx--){
                    matrix[idx][startCol] = index++;
                }
            }

            startCol++;

        }

        //System.out.println("Array is "+ Arrays.deepToString(matrix));
        return matrix;
    }

    public static void main(String[] args) {
        GenerateSpiralMatrix generateSpiralMatrix = new GenerateSpiralMatrix();
        System.out.println("generateSpiralMatrix.generateMatrix(3) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(3)));
        System.out.println("generateSpiralMatrix.generateMatrix(4) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(4)));
        System.out.println("generateSpiralMatrix.generateMatrix(5) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(5)));
        System.out.println("generateSpiralMatrix.generateMatrix(6) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(6)));
        System.out.println("generateSpiralMatrix.generateMatrix(7) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(7)));
        System.out.println("generateSpiralMatrix.generateMatrix(8) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(8)));
        System.out.println("generateSpiralMatrix.generateMatrix(9) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(9)));
        System.out.println("generateSpiralMatrix.generateMatrix(10) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(10)));
        System.out.println("generateSpiralMatrix.generateMatrix(11) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(11)));
        System.out.println("generateSpiralMatrix.generateMatrix(12) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(12)));
        System.out.println("generateSpiralMatrix.generateMatrix(13) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(13)));
        System.out.println("generateSpiralMatrix.generateMatrix(14) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(14)));
        System.out.println("generateSpiralMatrix.generateMatrix(15) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(15)));
        System.out.println("generateSpiralMatrix.generateMatrix(16) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(16)));
        System.out.println("generateSpiralMatrix.generateMatrix(17) = " + Arrays.deepToString(generateSpiralMatrix.generateMatrix(17)));
    }
}
