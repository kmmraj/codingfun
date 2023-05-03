package com.test.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    }
}
