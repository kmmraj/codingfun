package com.test.matrixtraversal;

//Given the positions of a white bishop and a black pawn on the standard chess board,
// determine whether the bishop can capture the pawn in one move.
//
//The bishop has no restrictions in distance for each move, but is limited to diagonal movement.
// Check out the example below to see how it can move:
//
//
//Example
//
//For bishop = "a1" and pawn = "c3", the output should be
//solution(bishop, pawn) = true.
//
//
//
//For bishop = "h1" and pawn = "h3", the output should be
//solution(bishop, pawn) = false.
//
//
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] string bishop
//
//Coordinates of the white bishop in the chess notation.
//
//Guaranteed constraints:
//bishop.length = 2,
//'a' ≤ bishop[0] ≤ 'h',
//1 ≤ bishop[1] ≤ 8.
//
//[input] string pawn
//
//Coordinates of the black pawn in the same notation.
//
//Guaranteed constraints:
//pawn.length = 2,
//'a' ≤ pawn[0] ≤ 'h',
//1 ≤ pawn[1] ≤ 8.
//
//[output] boolean
//
//true if the bishop can capture the pawn, false otherwise.
public class BisopAndPawn {
    boolean solution(String bishop, String pawn) {
        char b1 = bishop.charAt(0);
        char b2 = bishop.charAt(1);

        char p1 = pawn.charAt(0);
        char p2 = pawn.charAt(1);

        // if(b1 > p1){
        //     System.out.println("The "+ bishop +" is ahead of " + pawn);
        //     System.out.println(" The char diff is " + (b1 - p1));
        //      System.out.println(" The num diff is " + (b2 - p2));
        // } else {
        //      System.out.println("The "+ pawn +" is ahead of " + bishop);
        //      System.out.println(" The char diff is " + (p1 - b1));
        //     System.out.println(" The num diff is " + (p2 - b2));
        // }
        return ((Math.abs(b1 - p1)) == (Math.abs(b2-p2)));
    }

    public static void main(String[] args) {
           BisopAndPawn bisopAndPawn = new BisopAndPawn();
            System.out.println(bisopAndPawn.solution("a1", "c3"));
            System.out.println(bisopAndPawn.solution("h1", "h3"));
            System.out.println(bisopAndPawn.solution("a5", "c3"));
            System.out.println(bisopAndPawn.solution("a5", "c7"));
            System.out.println(bisopAndPawn.solution("a5", "c8"));
            System.out.println(bisopAndPawn.solution("a5", "c1"));
            System.out.println(bisopAndPawn.solution("a5", "a1"));
            System.out.println(bisopAndPawn.solution("a5", "a8"));
            System.out.println(bisopAndPawn.solution("a5", "h8"));
            System.out.println(bisopAndPawn.solution("a5", "h1"));
            System.out.println(bisopAndPawn.solution("a5", "h2"));
            System.out.println(bisopAndPawn.solution("a5", "h3"));
            System.out.println(bisopAndPawn.solution("a5", "h4"));
            System.out.println(bisopAndPawn.solution("a5", "h5"));
            System.out.println(bisopAndPawn.solution("a5", "h6"));
            System.out.println(bisopAndPawn.solution("a5", "h7"));

    }
}
