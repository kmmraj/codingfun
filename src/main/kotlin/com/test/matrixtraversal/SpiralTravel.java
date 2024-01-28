package com.test.matrixtraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpiralTravel {
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        int row = array.length - 1;
        int col = array[0].length - 1;
        int sr = 0, sc = 0, er = row, ec = col;
        List<Integer> returnList = new ArrayList<Integer>();

        while (sr <= er && sc <= ec) {

            for (int idx = sc; idx <= ec; idx++) {
                returnList.add(array[sr][idx]);
            }

            for (int jdx = sr + 1; jdx <= er; jdx++) {
                returnList.add(array[jdx][ec]);
            }
            for (int kdx = ec - 1; kdx >= sr; kdx--) {
                if(sr==er)
                    break;
                returnList.add(array[er][kdx]);
            }
            for (int ldx = er - 1; ldx >= sc + 1; ldx--) {
                if(sc==ec)
                    break;
                returnList.add(array[ldx][sc]);
            }
            sr++;
            sc++;
            ec--;
            er--;
        }
        return returnList;
    }


    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> spiralList = new ArrayList<>();
        if(matrix.length == 1){
            return Arrays.stream(matrix[0]).boxed().collect(Collectors.toList());
        }
        if(matrix[0].length == 1){
            for(int index=0;index<matrix.length;index++){
                spiralList.add(matrix[index][0]);
            }
            return spiralList;
        }
        int startCol =0, startRow=0,endCol=matrix[0].length-1,endRow=matrix.length-1;
        //[[1,2,3],
        // [4,5,6],
        // [7,8,9]]

        while(startRow<=endRow && startCol<=endCol){
            // Row L2R
            for(int jdx=startCol;jdx<=endCol;jdx++){
                // System.out.println("Row L2R adding "+matrix[startRow][jdx]+" startRow is "+startRow+" jdx is "+jdx);
                spiralList.add(matrix[startRow][jdx]);
            }
            startRow++;

            // Col T2B
            for(int idx=startRow; idx<=endRow;idx++){
                // System.out.println("Col T2B adding "+matrix[idx][endCol]+" idx is "+idx+" endCol is "+(endCol));
                spiralList.add(matrix[idx][endCol]);
            }
            endCol--;

            if(startRow<=endRow){


                // Row R2L (Reverse)
                for(int kdx=endCol;kdx>=startCol;kdx--){
                    //  System.out.println("Row R2L (Reverse) adding "+matrix[endRow][kdx]+" endRow is "+(endRow)+" kdx is "+kdx);
                    spiralList.add(matrix[endRow][kdx]);
                }
            }
            endRow--;
            /**
             [[2,3,4],
             [5,6,7],
             [8,9,10],
             [11,12,13],
             [14,15,16]]
             */
            if(startCol<=endCol){


                // Col B2T (Reverse)
                for(int ldx=endRow;ldx>=startRow;ldx--){
                    // System.out.println("Col B2T (Reverse) adding "+matrix[ldx][startCol]+" ldx is "+ldx+" startCol is "+startCol+" startRow is "+startRow);
                    spiralList.add(matrix[ldx][startCol]);
                }
            }

            startCol++;


            // System.out.println("startRow is "+startRow+ " startCol is "+startCol+" endRow is "+ endRow + " endCol is "+endCol);
            // System.out.println("SpiralList is "+ Arrays.toString(spiralList.toArray()));
        }

        // System.out.println("SpiralList is "+ Arrays.toString(spiralList.toArray()));
        return spiralList;

    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7},};

//        int[][] input = new int[][]{
//                {4, 2, 3, 6, 7, 8, 1, 9, 5, 10},
//                {12, 19, 15, 16, 20, 18, 13, 17, 11, 14}};
//
//        int [][] input = new int[][] {
//                {1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}
//        };

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        List<Integer> actual = SpiralTravel.spiralTraverse(input);
        for (int item : actual) {
            System.out.printf("%2d ", item);
        }
        System.out.println();

        System.out.println(" SpiralTravel.spiralOrder(input) = " + Arrays.toString(SpiralTravel.spiralOrder(input).toArray()));
    }
}
