package com.test.matrixtraversal;
//Given two cells on the standard chess board, determine whether they have the same color or not.
//
//Example
//
//For cell1 = "A1" and cell2 = "C3", the output should be
//solution(cell1, cell2) = true.
//
//
//
//For cell1 = "A1" and cell2 = "H3", the output should be
//solution(cell1, cell2) = false.
//
//
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] string cell1
//
//Guaranteed constraints:
//cell1.length = 2,
//'A' ≤ cell1[0] ≤ 'H',
//1 ≤ cell1[1] ≤ 8.
//
//[input] string cell2
//
//Guaranteed constraints:
//cell2.length = 2,
//'A' ≤ cell2[0] ≤ 'H',
//1 ≤ cell2[1] ≤ 8.
//
//[output] boolean
//
//true if both cells have the same color, false otherwise.
public class ChessBoardColorMatch {
    boolean solution(String cell1, String cell2) {
        boolean[][] chessboard = new boolean[8][8];
        boolean isGreen = true;
        for (int idx = 0; idx < chessboard.length; idx++) {
            for (int jdx = 0; jdx < chessboard[idx].length; jdx++) {
                chessboard[idx][jdx] = isGreen;
                isGreen = !isGreen;
            }
            isGreen = !isGreen;
        }
        int idx1 = cell1.charAt(0) - 65;
        int jdx1 = cell1.charAt(1) - 49;

        int idx2 = cell2.charAt(0) - 65;
        int jdx2 = cell2.charAt(1) - 49;

        System.out.println("cell1 [idx][jdx] are "+ "["+idx1+"]" + "["+jdx1+"] == "+ chessboard[idx1][jdx1]);
        System.out.println("cell2 [idx][jdx] are "+ "["+idx2+"]" + "["+jdx2+"] == "+ chessboard[idx2][jdx2]);

        return chessboard[idx1][jdx1] == chessboard[idx2][jdx2];
    }

    public static void main(String[] args) {
        ChessBoardColorMatch chessBoardColorMatch = new ChessBoardColorMatch();
        System.out.println("Should be true "+ chessBoardColorMatch.solution("A1", "C3"));
        System.out.println("Should be false "+ chessBoardColorMatch.solution("A1", "H3"));
        
    }
}
