package com.test.recursion;

public class NPower {

    public static void main(String[] args) {
        System.out.println(NPower.power(2, 4));
        System.out.println(NPower.power(2, -4));
        System.out.println(NPower.power(3, 3));
    }

    private static int power(int base, int exp) {
        // Exp
        if (exp < 0) {
            return -1;
        }

        // BC
        if (exp == 0) {
            return 1;
        }

        // Hypo
        return base * power(base, exp - 1);
    }
}
