package com.test.matrixtraversal;

// https://app.codesignal.com/arcade/intro/level-11/pwRLrkrNpnsbgMndb
//Given a position of a knight on the standard chessboard, find the number of different moves the knight can perform.
//
//The knight can move to a square that is two squares horizontally and one square vertically,
// or two squares vertically and one square horizontally away from it.
// The complete move therefore looks like the letter L.
// Check out the image below to see all valid moves for a knight piece that is placed on one of the central squares.
//
//
//
//Example
//
//For cell = "a1", the output should be
//solution(cell) = 2.
//
//
//
//For cell = "c2", the output should be
//solution(cell) = 6.
//
//
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] string cell
//
//String consisting of 2 letters - coordinates of the knight on an 8 × 8 chessboard in chess notation.
//
//Guaranteed constraints:
//cell.length = 2,
//'a' ≤ cell[0] ≤ 'h',
//1 ≤ cell[1] ≤ 8.
//
//[output] integer
public class ChessKnightMoves {

    int solution(String cell) {
        int charVal = cell.charAt(0);
        int intVal = cell.charAt(1) - 48;
        int totalMoves = 0;


        //System.out.println("charVal is " + charVal + " intVal is "+ intVal);

        // Left Horizontal Up
        if(charVal - 2 >= 97 && intVal + 1 <= 8){
            totalMoves = totalMoves + 1;
        }
        // Left Vertical Up
        if(charVal -1 >=97 && intVal + 2 <=8){
            totalMoves = totalMoves + 1;
        }

        // Right Horizontal Up
        if(charVal + 2 <= 104 && intVal + 1 <= 8){
            totalMoves = totalMoves + 1;
        }

        // Right Vertical Up
        if(charVal + 1 <= 104 && intVal + 2 <= 8){
            totalMoves = totalMoves + 1;
        }

        // Left Horizontal Down
        if(charVal - 2 >= 97 && intVal - 1 >= 1){
            totalMoves = totalMoves + 1;
        }

        // Left Vertical Down
        if(charVal -1 >=97 && intVal - 2 >=1){
            totalMoves = totalMoves + 1;
        }

        // Right Horizontal Down
        if(charVal + 2 <= 104 && intVal - 1 >= 1){
            totalMoves = totalMoves + 1;
        }

        // Right Vertical Up
        if(charVal + 1 <= 104 && intVal - 2 >= 1){
            totalMoves = totalMoves + 1;
        }


        return totalMoves;

    }


    public static void main(String[] args) {
        ChessKnightMoves chessKnightMoves = new ChessKnightMoves();
        System.out.println("Expected 2 and actual is "+chessKnightMoves.solution("a1"));
        System.out.println("Expected 6 and actual is "+chessKnightMoves.solution("c2"));
        System.out.println("Expected 8 and actual is "+chessKnightMoves.solution("d4"));
        System.out.println("Expected 6 and actual is "+chessKnightMoves.solution("g6"));
        System.out.println("Expected 4 and actual is "+chessKnightMoves.solution("a3"));
        System.out.println("Expected 3 and actual is "+chessKnightMoves.solution("b1"));

    }
}
