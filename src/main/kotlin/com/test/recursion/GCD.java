package com.test.recursion;

public class GCD {
    public static void main(String[] args) {
//        System.out.println(GCD.gcd(8, 4));
//        System.out.println(GCD.gcd(16, 4));
        System.out.println(GCD.gcd(36, 60));
        System.out.println(GCD.gcd2(36, 60));
        System.out.println(GCD.gcd2(36, -60));
    }

    private static int gcd(int number1, int number2) {
        // Exp
        if (number1 < 0 || number2 < 0) {
            return -1;
        }

        // BC
        if (number2 == 0) {
            return number1;
        }

        // Hypo & Induction
        return gcd(number2, number1 % number2);
    }

    private static int gcd2(int number1, int number2) {
        // Exp
        if (number1 < 0 || number2 < 0) {
            return -1;
        }

        // BC
        if (number1 == 0) {
            return number2;
        }

        // Hypo & Induction
        return gcd2(number2 % number1, number1 );
    }
}
