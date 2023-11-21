package com.test.matrixtraversal;
//In the popular Minesweeper game you have a board with some mines and those cells that don't contain a mine have a number in it that indicates the total number of mines in the neighboring cells. Starting off with some arrangement of mines we want to create a Minesweeper game setup.
//
//Example
//
//For
//
//matrix = [[true, false, false],
//          [false, true, false],
//          [false, false, false]]
//the output should be
//
//solution(matrix) = [[1, 2, 1],
//                    [2, 1, 1],
//                    [1, 1, 1]]
//Check out the image below for better understanding:
//
//
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] array.array.boolean matrix
//
//A non-empty rectangular matrix consisting of boolean values - true
// if the corresponding cell contains a mine, false otherwise.
//
//Guaranteed constraints:
//2 ≤ matrix.length ≤ 100,
//2 ≤ matrix[0].length ≤ 100.
//
//[output] array.array.integer
//
//Rectangular matrix of the same size as matrix each cell of which contains an integer equal to
//the number of mines in the neighboring cells. Two cells are called neighboring if they share at least one corner.
public class MineSweeper {
    int[][] solution(boolean[][] matrix) {
        // matrix:
        // [[true,false,false,true],
        // [false,false,true,false],
        // [true,true,false,true]]

        // output:
        // [[0,2,2,1],
        // [3,4,3,3],
        // [1,2,3,1]]

        // NE N NW
        // CE C CW
        // . SE S SW

        int[][] result = new int[matrix.length][matrix[0].length];
        for (int idx = 0; idx < matrix.length; idx++) {
            for (int jdx = 0; jdx < matrix[idx].length; jdx++) {
                int[] coIndex = new int[2];
                // NE
                coIndex[0] = (idx - 1 >= 0) ? idx - 1 : -1;
                coIndex[1] = (jdx - 1 >= 0) ? jdx - 1 : -1;

                int ne = 0;
                if (coIndex[0] >= 0 && coIndex[1] >= 0) {
                    ne = matrix[coIndex[0]][coIndex[1]] == true ? 1 : 0;
                }
                // NO (North)
                coIndex[0] = (idx - 1 >= 0) ? idx - 1 : -1;
                coIndex[1] = (jdx >= 0) ? jdx : -1;
                int no = 0;
                if (coIndex[0] >= 0 && coIndex[1] >= 0) {
                    no = matrix[coIndex[0]][coIndex[1]] == true ? 1 : 0;
                }
                // NW
                coIndex[0] = (idx - 1 >= 0) ? idx - 1 : -1;
                coIndex[1] = (jdx + 1 < matrix[idx].length) ? jdx + 1 : -1;
                int nw = 0;
                if (coIndex[0] >= 0 && coIndex[1] >= 0) {
                    nw = matrix[coIndex[0]][coIndex[1]] == true ? 1 : 0;
                }

                // CE
                coIndex[0] = (idx >= 0) ? idx : -1;
                coIndex[1] = (jdx - 1 >= 0) ? jdx - 1 : -1;
                int ce = 0;
                if (coIndex[0] >= 0 && coIndex[1] >= 0) {
                    ce = matrix[coIndex[0]][coIndex[1]] == true ? 1 : 0;
                }

                // Center (CT)
                coIndex[0] = (idx >= 0) ? idx : -1;
                coIndex[1] = (jdx >= 0) ? jdx : -1;
                int ct = 0;
                if (coIndex[0] >= 0 && coIndex[1] >= 0) {
                    ct = matrix[coIndex[0]][coIndex[1]] == true ? 1 : 0;
                }
                // CW
                coIndex[0] = (idx >= 0) ? idx : -1;
                coIndex[1] = (jdx + 1 < matrix[idx].length) ? jdx + 1 : -1;
                int cw = 0;
                if (coIndex[0] >= 0 && coIndex[1] >= 0) {
                    cw = matrix[coIndex[0]][coIndex[1]] == true ? 1 : 0;
                }

                // SE
                coIndex[0] = (idx + 1 < matrix.length) ? idx + 1 : -1;
                coIndex[1] = (jdx - 1 >= 0) ? jdx - 1 : -1;
                int se = 0;
                if (coIndex[0] >= 0 && coIndex[1] >= 0) {
                    se = matrix[coIndex[0]][coIndex[1]] == true ? 1 : 0;
                }

                // ST (South)

                coIndex[0] = (idx + 1 < matrix.length) ? idx + 1 : -1;
                coIndex[1] = (jdx >= 0) ? jdx : -1;
                int st = 0;
                if (coIndex[0] >= 0 && coIndex[1] >= 0) {
                    st = matrix[coIndex[0]][coIndex[1]] == true ? 1 : 0;
                }

                // SW
                coIndex[0] = (idx + 1 < matrix.length) ? idx + 1 : -1;
                coIndex[1] = (jdx + 1 < matrix[idx].length) ? jdx + 1 : -1;
                int sw = 0;
                if (coIndex[0] >= 0 && coIndex[1] >= 0) {
                    sw = matrix[coIndex[0]][coIndex[1]] == true ? 1 : 0;
                }

                // System.out.println("------------------");
                // System.out.println("ne is " + ne);
                // System.out.println("no is " + no);
                // System.out.println("nw is " + nw);
                // System.out.println("ce is " + ce);
                // System.out.println("ct is " + ct);
                // System.out.println("cw is " + cw);
                // System.out.println("se is " + se);
                // System.out.println("st is " + st);
                // System.out.println("sw is " + sw);

                // [[true,false,false],
                // [false,true,false],
                // [false,false,false]]
                // result[idx][jdx] = ne + no + nw + ce + ct + cw + se + st + sw;
                result[idx][jdx] = ne + no + nw + ce + cw + se + st + sw;
                // System.out.println("result[" + idx + "][" + jdx + "] = " + result[idx][jdx]);
                // System.out.println("------------------");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MineSweeper mineSweeper = new MineSweeper();
        boolean[][] matrix = { { true, false, false }, { false, true, false }, { false, false, false } };
        int[][] result = mineSweeper.solution(matrix);
        print(result);

        boolean[][] matrix2 = { { true, false, false, true }, { false, false, true, false },
                { true, true, false, true } };
        result = mineSweeper.solution(matrix2);
        print(result);

        boolean[][] matrix3 = { { true, false, false, true }, { false, false, true, false },
                { true, true, false, true } };
        result = mineSweeper.solution(matrix3);
           print(result);

        boolean[][] matrix4 = { { true, false, false, true }, { false, false, true, false },
                { true, true, false, true } };
        result = mineSweeper.solution(matrix4);
        print(result);

//        boolean[][] matrix5 = { { true, false, false, true }, { false, false, true, false },
//                { true, true, false, true } };
//        result
    }

    private static void print(int[][] result) {
        for (int[] value : result) {
            for (int indexJ = 0; indexJ < result[0].length; indexJ++) {
                System.out.print(value[indexJ] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }
}
