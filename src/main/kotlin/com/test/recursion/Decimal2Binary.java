package com.test.recursion;

public class Decimal2Binary {

    public static void main(String[] args) {
        System.out.println("Decimal2Binary for 10 is " + Decimal2Binary.solveIt(10));
        System.out.println("Decimal2Binary for 13 is " + Decimal2Binary.solveItNeg(13));
        System.out.println("Decimal2Binary for 13 is " + Decimal2Binary.solveItNeg(-13));
    }

    private static String solveItNeg(int decimal){
        if(decimal < 0){
            decimal = - decimal;
            return "-"+ solveIt(decimal);
        }
        return solveIt(decimal);
    }
    private static String solveIt(int decimal) {
        // BC
        if (decimal < 0) {
            decimal = -decimal;
        }
        if (decimal == 0) {
            return "";
        }


        // Hypo & Induction

        return decimal % 2 + "" + solveIt(decimal / 2);
    }
}
